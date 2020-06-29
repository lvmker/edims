package com.bgi.docking.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 作者:Kangy
 * 日期:2019/9/20 9:34
 */
@Entity//声明实体类
@Table(name="bisp-finance") //建立实体类和表的映射关系
public class Middle implements Serializable {

    /**
     * cbs客户参考业务号，当做ID,相当于code+payeeTargetBizCode
     */
    @Id//声明当前私有属性为主键
    //@GeneratedValue(strategy= GenerationType.IDENTITY) //配置主键的生成策略 .这里不要主键自增
    @Column(name="refnbr") //指定和表中refnbr字段的映射关系
    private String refnbr;

    /**
     *cbs业务流水号
     */
    @Column(name="busnbr")
    private String busnbr;
    /**
     * 支付流水编码，每刻系统内该条记录唯一 主键
     */
    @Column(name="code")
    private String code;
    /**
     * 每刻单据编码
     */
    @Column(name="payeeTargetBizCode")
    private String payeeTargetBizCode;
    /**
     * 每刻支付记录流水号
     */
    @Column(name="sequence")
    private String sequence;
    /**
     * 每刻  公司支付账号
     */
    @Column(name = "payerBankAccount")
    private String payerBankAccount;
    /**
     * 状态，  使用每刻的状态值
     * CBS_EXPORTED(已导 出),
     * PAY_SUCCESS(支付成功),
     * PAY_FAIL(支付失败),
     * CBS_EXPORT_FAILED(导出失败)
     */
    @Column(name="status")
    private String status;
    /**
     * 存储时间  格式yyyy-MM-dd HH:mm:ss
     */
    @Column(name="storageTime")
    private String storageTime;
    /**
     * 修改状态时间  格式yyyy-MM-dd HH:mm:ss
     */
    @Column(name="updateTime")
    private String updateTime;


    @Override
    public String toString() {
        return "Middle{" +
                "refnbr='" + refnbr + '\'' +
                ", busnbr='" + busnbr + '\'' +
                ", code='" + code + '\'' +
                ", payeeTargetBizCode='" + payeeTargetBizCode + '\'' +
                ", sequence='" + sequence + '\'' +
                ", payerBankAccount='" + payerBankAccount + '\'' +
                ", status='" + status + '\'' +
                ", storageTime='" + storageTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public String getPayerBankAccount() {
        return payerBankAccount;
    }

    public void setPayerBankAccount(String payerBankAccount) {
        this.payerBankAccount = payerBankAccount;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getRefnbr() {
        return refnbr;
    }

    public void setRefnbr(String refnbr) {
        this.refnbr = refnbr;
    }

    public String getBusnbr() {
        return busnbr;
    }

    public void setBusnbr(String busnbr) {
        this.busnbr = busnbr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPayeeTargetBizCode() {
        return payeeTargetBizCode;
    }

    public void setPayeeTargetBizCode(String payeeTargetBizCode) {
        this.payeeTargetBizCode = payeeTargetBizCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
