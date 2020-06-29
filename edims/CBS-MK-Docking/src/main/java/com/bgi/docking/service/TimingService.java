package com.bgi.docking.service;

import com.alibaba.fastjson.JSON;
import com.bgi.docking.Bean.cbs.*;
import com.bgi.docking.Bean.mk.PayForWater;
import com.bgi.docking.Bean.mk.Result;
import com.bgi.docking.Bean.mk.UpdateStatus;
import com.bgi.docking.util.HttpClientUtil;
import com.bgi.docking.util.TransitionUtil;
import com.bgi.docking.util.cbs.CDataAdapter;
import com.bgi.docking.util.cbs.JaxbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.logging.Logger;

/**
 * 作者:Kangy
 * 日期:2019/9/16 17:41
 *
 *
 * 定时提交付款信息
 */
@Component
@EnableScheduling
public class TimingService {

    private static final Logger logger = Logger.getLogger("SCHEDULAR");

    private boolean isRunning = false;//定时器任务状态
    @Autowired
    private MaycurBaseService service;

    @Autowired
    private MiddleSqlService sqlService;

    @Autowired
    public Environment env;// 这里可以通过environment获取配置文件里面的值



    //@Scheduled(fixedRate = 1000*60*60*24) //一天执行一次
    //@Scheduled(cron = "0 15 23 * * ?")  //每天上午23点15分执行
    @Scheduled(fixedRate = 80000) //每隔80秒执行一次
    public void runScheduled() {
        logger.info("【开始定时任务提交付款信息】");
        if (!isRunning) {
            isRunning = true;
            try {
                CbsVSMk();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                logger.info("【提交付款信息定时器运行结束】");
                isRunning = false;
            }
        } else {
            logger.info("【提交付款信息定时器运行尚未结束】");
        }
    }

    public void CbsVSMk() {

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("sequence", "-1");
        hashMap.put("pageSize", "1");//每次拉取的条数

        Result result = service.synchronizeToMaycur("openapi.maycur.paymenttransaction-list",
                "POST", "application/json", "UTF-8", hashMap);

        //如果返回成功才继续
        if (result.isSuccess()) {

            if (!result.getData().toString().equals("[]") || result.getData().toString() != null){
                //把返回的数组转换成对象数组
                List<PayForWater> waterList = JSON.parseArray(result.getData().toString(), PayForWater.class);
                for (PayForWater forWater : waterList) {
                    String xmlStr = null;
                    try {
                        //调用工具类转换数据
                        xmlStr = TransitionUtil.toXmlStr(forWater);
                    } catch (Exception e) {
                        logger.info("【对象转XML字符串发生异常,位置11】"+e.toString());
                    }
                    System.out.println("【传递的xml数据】" + xmlStr);
                        String response = HttpClientUtil.post(env.getProperty("CBS.host"), xmlStr);
                        //返回XML转成对象
                        OneLevel responseLevel = JaxbUtil.converyToJavaBean(response, OneLevel.class);
                        //获取对象里面的xml,去除xml的外标签
                    String unmarshal = null;
                    try {
                        unmarshal = CDataAdapter.unmarshal(responseLevel.getData());
                    } catch (Exception e) {
                        logger.info("解析，去除 <![CDATA[ ]]>  标签发生异常");
                        e.printStackTrace();
                    }
                    //然后再把去掉外标签的xml转成对象
                        TwoResponse twoResponse = JaxbUtil.converyToJavaBean(unmarshal, TwoResponse.class);

                        if (twoResponse.getSycomretz().getErrcod().trim().equals("0000000")
                                &&twoResponse.getInfo().getRetcod().trim().equals("0000000")
                                &&twoResponse.getAppaysavz().getErrcod().trim().equals("0000000")) {
                            //成功，调用每刻接口改变数据状态
                            Result results = updateStatus(forWater, twoResponse, UpdateStatus.StatusConstant.CBS_EXPORTED);//支付状态,这里更改为已导出

                            logger.info("【导出成功】"+results);
                        } else {
                            //失败
                            //调用CBS接口查询状态，
                            if (twoResponse.getAppaysavz().getErrmsg().equals("业务参考号重复!")) {
                                //如果业务参考号重复，就到CBS接口查询业务流水号。然后再根据业务流水号查询状态












                            }else {
                                logger.info("【CBS存储异常】："+twoResponse.getAppaysavz().getErrmsg());
                                Result results = updateStatus(forWater, twoResponse, UpdateStatus.StatusConstant.CBS_EXPORT_FAILED);
                                logger.info("【导出失败】"+results);
                            }


                        }
                }
            }else {
                logger.info("【每刻没有支付数据】");
            }

        }else {
            //查询每刻数据失败
            logger.info("【查询每刻数据失败】"+result);
        }

    }

    /**
     * 调用每刻接口  修改数据状态
     * @param forWater  每刻数据对象
     * @param twoResponse 二级返回对象
     * @param status
     * @return
     */
    public Result updateStatus(PayForWater forWater,TwoResponse twoResponse,String status){

        List<UpdateStatus> statusList = new ArrayList<>();
        UpdateStatus update = new UpdateStatus();
        update.setSequence(Long.valueOf(forWater.getSequence()));//支付记录流水号
        update.setStatus(status);//支付状态,这里更改为支付成功
        update.setPaidDate(new Date().getTime());//支付时间
        update.setPayerBankAccount(forWater.getPayerBankAccount());//支付账号，
        update.setErrorMsg(twoResponse.getAppaysavz().getErrmsg());//错误信息
        update.setPaymentSystemNumber(twoResponse.getAppaysavz().getBusnbr());//支付系统单号
        statusList.add(update);
        return service.synchronizeToMaycur("openapi.maycur.paymenttransaction-update",
                "POST", "application/json", "UTF-8", statusList);

    }

}
