package com.bgi.docking.service;

import com.bgi.docking.Bean.cbs.ThreeErpaystazResponse;
import com.bgi.docking.Bean.cbs.TwoResponse;
import com.bgi.docking.Bean.mk.Result;
import com.bgi.docking.Bean.mk.UpdateStatus;
import com.bgi.docking.pojo.Middle;
import com.bgi.docking.util.HttpClientUtil;
import com.bgi.docking.util.TransitionUtil;
import com.bgi.docking.util.cbs.JaxbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * 作者:Kangy
 * 日期:2019/9/20 10:12
 *
 *
 * 定时更新支付状态服务
 */
@Component
@EnableScheduling
public class TimingUpdateService {


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
    //@Scheduled(fixedRate = 60000) //每隔80秒执行一次
    public void runScheduled() {
        logger.info("【开始定时任务更新支付状态】");
        if (!isRunning) {
            isRunning = true;
            try {
                TimingUpdateStatus();
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


    public void TimingUpdateStatus() throws Exception{
        List<Middle> middleList = sqlService.findByStatus(UpdateStatus.StatusConstant.CBS_EXPORTED);
        List<UpdateStatus> statusList = new ArrayList<>();

        String xmlStr = TransitionUtil.toXmlStr(middleList);
        String response = HttpClientUtil.post(env.getProperty("CBS.host"), xmlStr);
        TwoResponse twoResponseBean = JaxbUtil.converyToJavaBean(response, TwoResponse.class);
        if ( twoResponseBean.getErpaystaz().size()> 0 ||  twoResponseBean.getErpaystaz()!=null){
            for (ThreeErpaystazResponse ter : twoResponseBean.getErpaystaz()) {
                //0查无此记录（状态可疑）
                //1：支付成功
                //2：支付失败
                //3：未完成
                //4：银行退票
                if (ter.getStatus().equals("1")){
                    //根据CBS业务流水号到数据库查询数据
                    Middle middle = sqlService.findByBusnbr(ter.getBusnbr());
                    //把数据添加到集合。批量修改状态。
                    UpdateStatus status = new UpdateStatus();
                    status.setSequence(Long.valueOf(middle.getSequence()));
                    status.setStatus(UpdateStatus.StatusConstant.PAY_SUCCESS);
                    status.setPaymentSystemNumber(middle.getBusnbr());
                    status.setPaidDate(new Date().getTime());
                    status.setPayerBankAccount(middle.getPayerBankAccount());
                    statusList.add(status);
                    //调用每刻接口修改数据状态为支付成功

                    //每刻返回成功，再修改数据库状态

                }else {
                    //Result results = updateStatus(, UpdateStatus.StatusConstant.PAY_FAIL);//支付状态

                }

            }
            Result result = service.synchronizeToMaycur("openapi.maycur.paymenttransaction-update",
                    "POST", "application/json", "UTF-8", statusList);

        }




    }


    /**
     * 调用每刻接口  修改数据状态
     * @param status
     * @return
     */
    public Result updateStatus(List<Middle> middleList, String status){

        List<UpdateStatus> statusList = new ArrayList<>();

        for (Middle middle : middleList) {
            UpdateStatus update = new UpdateStatus();
            update.setSequence(Long.valueOf(middle.getSequence()));//支付记录流水号
            update.setStatus(status);//支付状态,
            update.setPaidDate(new Date().getTime());//支付时间戳
            update.setErrorMsg("");//错误信息
            update.setPaymentSystemNumber(middle.getBusnbr());//支付系统单号
            statusList.add(update);
        }

        return service.synchronizeToMaycur("openapi.maycur.paymenttransaction-update",
                "POST", "application/json", "UTF-8", statusList);

    }
}
