package com.bgi.docking;


import com.bgi.docking.service.MaycurBaseService;
import com.bgi.docking.util.HttpClientUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: huangshun
 * @Date: 2019/6/6 16:57
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
public class TestSsoController {
    @Autowired
    MaycurBaseService service;

    String userId = "668";// 员工工号
    String entCode="EC18081510YT9UPA"; //企业的 entCode   根据企业的名字在 在mysql 中查询 enterprise 表得到。
    String secret = "asdhdadsfha123kjndfjksdn";// sso_config表里面查到得 secret  每刻管理员为企业生成企业密码secretKey
    String ssoToken="";
    long timestamp =0;
    public String init(){
        timestamp = System.currentTimeMillis();
        // 企业用密码为员工工号或邮箱进行签名 生成ssoToken
        ssoToken = DigestUtils.sha256Hex((secret + ":" + userId + ":" + timestamp).getBytes());
        System.out.println("ssoToken为："+ssoToken);
        //拼接url  便于后面访问sso地址。
        String url="https://uat.maycur.com/api/web/auth/sso?entCode="+entCode+"&userId="+userId+"&timestamp="+timestamp+"&token="+ssoToken;
        return url;
    }

    /**(测试通过)  OK
     * 测试ssoToken
     * @return
     */
    @RequestMapping("/sso")
    @ResponseBody
    public Object testSso() throws Exception {
        String url=init();
        //return "redirect:"+url+"";
        String authToken = HttpClientUtil.sendRequest(url, "GET", "application/json", "UTF-8", null, null);
        System.out.println("init----authToken--------------"+authToken);
        return authToken;
    }

    /**(测试通过） OK 注意这里只需要拼接 ssoToken   而不是 authToken
     * 通过SSO跳转每刻主页(此地址和前面获取sso token地址不同)
     * @return
     */
    //https://uat.maycur.com/sso?entCode={entCode}&userId={userId}&timestamp={timestamp}&token={ssoToken}&language=zh&url={url}
    @RequestMapping("main")
    public String testMain() throws Exception {
        String url = init();
        String authToken = HttpClientUtil.sendRequest(url, "GET", "application/json", "UTF-8", null, null);
        System.out.println("timestamp===="+timestamp+"ssoToken=="+ssoToken);
        return "redirect:"+"https://uat.maycur.com/sso?entCode="+entCode+"&userId="+userId+"&timestamp="+timestamp+"&token="+ssoToken+"&language=zh&url=approve";
    }


    /**
     * 审批列表  OK
     * 获取审批列表
     * 接口: https://{maycurhost}/api/web/report/approvals GET JSON
     * 通过SSO接口获得authToken， 并将entCode与authToken放入http header中；
     * http.setHeader("entCode", {entCode})
     * http.setHeader("tokenId", {authToken})
     */
    @RequestMapping("approvals")
    @ResponseBody
    public String testApprovals(HttpServletResponse response, HttpServletRequest request) throws Exception {
        // 1 通过sso接口获取authToken
        String authToken = (String) testSso();
        System.out.println("authToken----"+authToken);
        // 解析authToken 拿到tokenId  和 ent_code;
        JSONObject object_authToken=new JSONObject(authToken);
        JSONObject data = object_authToken.getJSONObject("data");
        System.out.println("data----"+data);

        String tokenId = (String)data.get("tokenId");
        System.out.println("tokenId----"+tokenId);
        JSONArray ents = data.getJSONArray("ents");

        Object ents_object = ents.getJSONObject(0);
        String entCode = ((JSONObject) ents_object).getString("entCode");
        System.out.println("entCode--------"+ entCode);


        Map<String, String> headers = new HashMap<String, String>();
        headers.put("entCode", entCode);//将entCode和tokenId放入请求header中。
        headers.put("tokenId",tokenId);

        String result = HttpClientUtil.sendRequest("https://uat.maycur.com/api/web/report/approvals",
                "GET", "application/json", "UTF-8", headers, null);
        System.out.println("result--"+result);

        return result;
        //return "redirect:https://uat.maycur.com/api/web/report/approvals";
    }

    /**
     * 获取审批列表
     * 接口: https://{maycurhost}/api/web/report/approvals/history GET JSON
     * 通过SSO接口获得authToken， 并将entCode与authToken放入http header中；
     * http.setHeader("entCode", {entCode})
     * http.setHeader("tokenId", {authToken})
     */
    @RequestMapping("history")
    @ResponseBody
    public String testHistory(HttpServletResponse response, HttpServletRequest request) throws Exception {
        // 1 通过sso接口获取authToken
        String authToken = (String) testSso();
        System.out.println("authToken----"+authToken);
        // 解析authToken 拿到tokenId  和 ent_code;
        JSONObject object_authToken=new JSONObject(authToken);
        JSONObject data = object_authToken.getJSONObject("data");
        System.out.println("data----"+data);
        String tokenId = (String)data.get("tokenId");
        System.out.println("tokenId----"+tokenId);
        JSONArray ents = data.getJSONArray("ents");
        Object ents_object = ents.getJSONObject(0);
        String entCode = ((JSONObject) ents_object).getString("entCode");
        System.out.println("entCode--------"+ entCode);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("entCode", entCode);//将entCode和tokenId放入请求header中。
        headers.put("tokenId",tokenId);//https://uat.maycur.com/api/web/report/approvals
        String result = HttpClientUtil.sendRequest("https://uat.maycur.com/api/web/report/history",
                "GET", "application/json", "UTF-8", headers, null);
        System.out.println("result--"+result);
        return result;
    }

    /**
     * 访问urL 返回的json数据。
     * @param url
     * @return
     */
/*    public String getJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection conn = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(),"utf-8"));//防止乱码
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }*/

}
