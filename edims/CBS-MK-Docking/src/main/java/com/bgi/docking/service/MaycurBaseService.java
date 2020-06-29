package com.bgi.docking.service;

import com.alibaba.fastjson.JSON;
import com.bgi.docking.Bean.mk.MaycurAuthInfo;
import com.bgi.docking.Bean.mk.Result;
import com.bgi.docking.util.EmptyUtil;
import com.bgi.docking.util.HttpClientUtil;
import com.bgi.docking.util.mk.ConstantUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 每刻服务基础类
 * 
 */
@Component
public class MaycurBaseService {
    public static final Logger logger = LoggerFactory.getLogger(MaycurBaseService.class);

    @Autowired
    public Environment env;// 这里可以通过environment获取配置文件里面的值

    /**
     * 获取每刻开放api身份验证信息  测试自己公司的时候 把配置文件里面的每刻配置修改成自己公司的--
     * @return
     */
    public Result<MaycurAuthInfo> loginMaycurOpenAPI(){
        Result<MaycurAuthInfo> authResult =new Result<MaycurAuthInfo>();// Result封装的是结果信息
        String maycurHost= env.getProperty(ConstantUtil.MAYCUR_APP_HOST_KEY);//每刻平台主机常量KEY https://uat.maycur.com
        String appCode=env.getProperty(ConstantUtil.MAYCUR_APP_CODE_KEY);//公司的code (app_client 里面的code)
        String secret=env.getProperty(ConstantUtil.MAYCUR_APP_SECRET_KEY);//公司的密钥 每刻平台应用秘钥常量KEY(app_client 里面的secret)
        long timestamp = System.currentTimeMillis(); // 时间戳
        String secretKey = DigestUtils.sha256Hex((secret + ":" + appCode + ":" + timestamp).getBytes());//经过sha256 加密后的密钥
        String authParam="{\"appCode\":\"" + appCode + "\", \"secret\": \"" + secretKey + "\", \"timestamp\": \"" + timestamp + "\"}";
        String authapi = env.getProperty(ConstantUtil.MAYCUR_APP_OPENAPI_AUTH_KEY);//身份认证的路径  /api/openapi/auth/login
        String urlPath=maycurHost+authapi;//身份认证的完整路径 https://uat.maycur.com/api/openapi/auth/login
        logger.info("authParam===="+authParam);
        logger.info(urlPath);
        try {
            // 拿到登陆后返回的json 数据
            String authStr = HttpClientUtil.sendRequest(urlPath,"POST","application/json","UTF-8",new HashMap<String, String>(),authParam);
            logger.info("登陆发送请求后返回的json 数据为："+authStr);
            JSONObject jo = new JSONObject(authStr);
            String responseCode=jo.getString(ConstantUtil.MAYCUR_APP_OPENAPI_RESPONSE_CODE_KEY);//json 中的 code 字段的值
            if(ConstantUtil.RESULT_CODE_SUCCESS_KEY.equalsIgnoreCase(responseCode)){        // "ACK".equals code
                JSONObject jdata = jo.getJSONObject(ConstantUtil.RESULT_SUCCESS_DATA_KEY);//json 中data 字段的值
                MaycurAuthInfo authInfo = new MaycurAuthInfo();
                authInfo.setEntCode(jdata.getString("entCode"));
                authInfo.setTokenId(jdata.getString("tokenId"));
                authInfo.setTimestamp(timestamp);
                authResult.setSuccess(true);
                authResult.setData(authInfo);
            }else{
                authResult.setSuccess(false);
                authResult.setMessage(jo.getString(ConstantUtil.RESULT_FAILURE_MSG_KEY));
            }
        } catch (Exception e) {
            logger.error("每刻身份校验异常，请求参数："+authParam,e);
            authResult.setSuccess(false);
            authResult.setMessage("调用每刻身份验证异常");
        }
        return authResult;
    }

    /**
     * 同步信息到每刻
     * @param apiCtx     yml 里面配置的open api 路径
     * @param httpMethod 访问的方式
     * @param contentType 类型
     * @param encode      编码
     * @param dataInfors  要携带的参数 传进去---
     * @return
     * 这里主要拿到认证信息entCode 和tokenId
     */
    public Result synchronizeToMaycur(String apiCtx, String httpMethod, String contentType, String encode, Object dataInfors){
        //Result result=new Result();
        Result r=this.loginMaycurOpenAPI();// 拿到包含entCode和tokenId的身份信息
        if(!r.isSuccess()){
            return r;
        }
        String maycurHost= env.getProperty(apiCtx);  // 拿到yml 里面配置的路径
        // 拿到登陆的用户的信息的实体
        MaycurAuthInfo authInfo = (MaycurAuthInfo)r.getData();
        String entCode = authInfo.getEntCode();
        String tokenId = authInfo.getTokenId();
        return synchronizeToMaycur(entCode,tokenId,authInfo.getTimestamp(),maycurHost,httpMethod,contentType,encode,dataInfors);
    }

    /**
     *
     * @param entCode entCode
     * @param tokenId tokenId
     * @param timestamp timestamp
     * @param apiCtx   要访问的url
     * @param httpMethod httpMethod
     * @param contentType contentType
     * @param encode   encode
     * @param dataInfors  携带的参数
     * @return
     * 这里主要同步信息到每刻要访问的网址，同时携带了需要的参数  (即访问要访问的接口)
     */
    public Result synchronizeToMaycur(String entCode,String tokenId,long timestamp,String apiCtx, String httpMethod, String contentType, String encode, Object dataInfors){
        Result result=new Result();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("entCode", entCode);//将entCode和tokenId放入请求header中。
        headers.put("tokenId",tokenId);
        String maycurHost= env.getProperty(ConstantUtil.MAYCUR_APP_HOST_KEY);//https://uat.maycur.com
        String urlPath = maycurHost+apiCtx;    //要访问的完整路径
        String dataStr = null;
        // 判断携带的参数是否为空，如果不为空，把时间戳和携带的参数设置进map里
        if(!EmptyUtil.isEmpty(dataInfors)){
            Map<String,Object> paramMap=new HashMap<String,Object>();
            paramMap.put(ConstantUtil.REQUEST_TIMESTAMP_KEY,timestamp);//timestamp
            paramMap.put(ConstantUtil.REQUEST_DATA_KEY,dataInfors);//data
            dataStr= JSON.toJSONString(paramMap);//将对象转化为Json字符串
        }
        logger.info("(发出去的请求数据)判断携带的参数是否为空后并将时间戳加进去后转换的json为："+dataStr);
        String resultStr = null;
        try {
            //访问要访问的网址 并且携带有 headers头信息和 要携带的参数
            resultStr= HttpClientUtil.sendRequest(urlPath,httpMethod,contentType,encode,headers,dataStr);
            logger.info("携带headers和参数访问"+urlPath+"后返回的json数据为："+resultStr);
            JSONObject jo = new JSONObject(resultStr);
            String responseCode=jo.getString(ConstantUtil.MAYCUR_APP_OPENAPI_RESPONSE_CODE_KEY);//code
            //System.out.println("responseCode======"+responseCode);


            //JSONArray data = jo.getJSONArray("data");
            //for (Object datum : data) {
            //    System.out.println(datum.toString());
            //}

            if(ConstantUtil.RESULT_CODE_SUCCESS_KEY.equalsIgnoreCase(responseCode)){   //"ACK".equals code
                result.setSuccess(true);
                //result.setData(jo.getString(ConstantUtil.RESULT_SUCCESS_DATA_KEY));//data
                result.setData(jo.get(ConstantUtil.RESULT_SUCCESS_DATA_KEY));//data    //这里需要注意下获取 data的方式

            }else{
                result.setSuccess(false);
                result.setMessage(jo.getString(ConstantUtil.RESULT_FAILURE_MSG_KEY));
            }
        } catch (Exception e) {
            logger.error("【调用每刻接口异常，请求参数】："+dataStr,e);
            result.setSuccess(false);
            result.setMessage("调用每刻接口异常:"+e.getMessage());
        }

        return result;
    }

}
