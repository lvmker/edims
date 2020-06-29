package com.bgi.docking.Bean.mk;

import java.io.Serializable;

/**
 * 作者:Kangy
 * 日期:2019/9/18 10:13
 *
 * 更新每刻状态接口实体类
 */
public class UpdateStatus implements Serializable {

    public interface StatusConstant {
        /**
         * (已导出)
         */
        String CBS_EXPORTED = "CBS_EXPORTED";
        /**
         *(支付成功)
         */
        String PAY_SUCCESS = "PAY_SUCCESS";
        /**
         *(支付失败)
         */
        String PAY_FAIL = "PAY_FAIL";
        /**
         *(导出失败)
         */
        String CBS_EXPORT_FAILED = "CBS_EXPORT_FAILED";
    }


    /**
     * long Y 支付记录流水号
     */
    private long sequence;
    /**
     * string Y 状态可选值:
     * CBS_EXPORTED(已导 出),
     * PAY_SUCCESS(支付成功),
     * PAY_FAIL(支付失败),
     * CBS_EXPORT_FAILED(导出失败)
     */
    private String status;
    /**
     * long N 支付时间，到毫秒的时间戳(在将状态 更新为支付成功时必填)
     */
    private long paidDate;
    /**
     * string N 支付账号，需要传已经在每刻维护的支 付账号(在将状态更新为支付成功时必 填)
     */
    private String payerBankAccount;
    /**
     * string N 错误信息(在将状态更新为支付失败或 导出失败时必填)
     */
    private String errorMsg;
    /**
     * string N 支付系统单号
     */
    private String paymentSystemNumber;


    @Override
    public String toString() {
        return "UpdateStatus{" +
                "sequence=" + sequence +
                ", status='" + status + '\'' +
                ", paidDate=" + paidDate +
                ", payerBankAccount='" + payerBankAccount + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", paymentSystemNumber='" + paymentSystemNumber + '\'' +
                '}';
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(long paidDate) {
        this.paidDate = paidDate;
    }

    public String getPayerBankAccount() {
        return payerBankAccount;
    }

    public void setPayerBankAccount(String payerBankAccount) {
        this.payerBankAccount = payerBankAccount;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getPaymentSystemNumber() {
        return paymentSystemNumber;
    }

    public void setPaymentSystemNumber(String paymentSystemNumber) {
        this.paymentSystemNumber = paymentSystemNumber;
    }
}
