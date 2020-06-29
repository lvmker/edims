package com.bgi.docking.Bean.mk;

import java.io.Serializable;

/**
 * 作者:Kangy
 * 日期:2019/9/12 17:43
 */
public class PayForWater implements Serializable {
    /**
     * 类型：string
     * 长度：32
     * 描述：支付流水编码，每刻系统内该条记录唯一 主键
     */
    private String code;
    /**
     * 类型：string
     * 长度：128
     * 描述：单据编码
     */
    private String payeeTargetBizCode;
    /**
     * 类型：string
     * 长度：8
     * 描述：第三方支付平台编码， 目前只有CBS
     */
    private String platform; //string 8 第三方支付平台编码， 目前只有CBS
    /**
     * 类型：string
     * 长度：32
     * 描述：公司支付类型
     */
    private String payerPaymentType; //string 32 公司支付类型
    /**
     * 类型：string
     * 长度：256
     * 描述：公司支付账号名称
     */
    private String payerName; //string 256 公司支付账号名称
    /**
     * 类型：string
     * 长度：256
     * 描述：公司支付账号银行
     */
    private String payerBankName; //string 256 公司支付账号银行
    /**
     * 类型：string
     * 长度：256
     * 描述：公司支付账号
     */
    private String payerBankAccount; //string 256 公司支付账号
    /**
     * 类型：string
     * 长度：256
     * 描述：收款人／供应商
     */
    private String payeeName; //string 256 收款人／供应商
    /**
     * 类型：string
     * 长度：256
     * 描述：收款人/供应商账号
     */
    private String payeeBankCardNO; //string 256 收款人/供应商账号
    /**
     * 类型：string
     * 长度：256
     * 描述：收款人／供应商银行
     */
    private String payeeBankName; //string 256 收款人／供应商银行
    /**
     * 类型：string
     * 长度：256
     * 描述：收款人/分支行名
     */
    private String payeeBankBranchName; //string 256 收款人/分支行名
    /**
     * 类型：string
     * 长度：256
     * 描述：收款人／供应商银行联行号
     */
    private String payeeBankBranchNO; //string 256 收款人／供应商银行联行号
    /**
     * 类型：string
     * 长度：256
     * 描述：收款人／供应商银行所在省
     */
    private String payeeBankProvince; //string 256 收款人／供应商银行所在省
    /**
     * 类型：string
     * 长度：256
     * 描述：收款人／供应商银行所在市
     */
    private String payeeBankLocation; //string 256 收款人／供应商银行所在市
    /**
     * 类型：decimal
     * 长度：
     * 描述：金额
     */
    private String paidAmount; //decimal 金额
    /**
     * 类型：string
     * 长度：128
     * 描述：收款人身份认证类别，有身份证等
     */
    private String certificationType; //string 128 收款人身份认证类别，有身份证等
    /**
     * 类型：string
     * 长度：128
     * 描述：收款人认证号码
     */
    private String certification; //string 128 收款人认证号码
    /**
     * 类型：long
     * 长度：
     * 描述：流水号
     */
    private String sequence; //long 流水号
    /**
     * 类型：string
     * 长度：
     * 描述：收款币种
     */
    private String acceptCcy; //string 收款币种
    /**
     * 类型：decimal
     * 长度：
     * 描述：收款金额
     */
    private String acceptAmount; //decimal 收款金额
    /**
     * 类型：string
     * 长度：64
     * 描述：报销人工号
     */
    private String reimEmployeeId; //string 64 报销人工号
    /**
     * 类型：string
     * 长度：64
     * 描述：单据业务实体编码
     */
    private String subsidiaryBizCode; //string 64 单据业务实体编码
    /**
     * 类型：string
     * 长度：256
     * 描述：单据业务实体
     */
    private String subsidiaryName; //string 256 单据业务实体
    /**
     * 类型：string
     * 长度：8
     * 描述：被支付方类型，
     * 可选值包括:  CORP(对公 支付),
     * PERSONAL（对私支付）,
     * EXPENSE（消费申请支付）,
     * 当支付类 型是CORP时，payee* 表示的是供应商 账号信息，其它为员工账号信息
     */
    private String payeeTarget; //string 8
    /**
     * 单据小类名称
     */
    private String formSubTypeName;
    /**
     * 对私报销、申请单、对公支付单单据的备注
     */
    private String comments;


    @Override
    public String toString() {
        return "PayForWater{" +
                "code='" + code + '\'' +
                ", payeeTargetBizCode='" + payeeTargetBizCode + '\'' +
                ", platform='" + platform + '\'' +
                ", payerPaymentType='" + payerPaymentType + '\'' +
                ", payerName='" + payerName + '\'' +
                ", payerBankName='" + payerBankName + '\'' +
                ", payerBankAccount='" + payerBankAccount + '\'' +
                ", payeeName='" + payeeName + '\'' +
                ", payeeBankCardNO='" + payeeBankCardNO + '\'' +
                ", payeeBankName='" + payeeBankName + '\'' +
                ", payeeBankBranchName='" + payeeBankBranchName + '\'' +
                ", payeeBankBranchNO='" + payeeBankBranchNO + '\'' +
                ", payeeBankProvince='" + payeeBankProvince + '\'' +
                ", payeeBankLocation='" + payeeBankLocation + '\'' +
                ", paidAmount='" + paidAmount + '\'' +
                ", certificationType='" + certificationType + '\'' +
                ", certification='" + certification + '\'' +
                ", sequence='" + sequence + '\'' +
                ", acceptCcy='" + acceptCcy + '\'' +
                ", acceptAmount='" + acceptAmount + '\'' +
                ", reimEmployeeId='" + reimEmployeeId + '\'' +
                ", subsidiaryBizCode='" + subsidiaryBizCode + '\'' +
                ", subsidiaryName='" + subsidiaryName + '\'' +
                ", payeeTarget='" + payeeTarget + '\'' +
                ", formSubTypeName='" + formSubTypeName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public String getFormSubTypeName() {
        return formSubTypeName;
    }

    public void setFormSubTypeName(String formSubTypeName) {
        this.formSubTypeName = formSubTypeName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPayerPaymentType() {
        return payerPaymentType;
    }

    public void setPayerPaymentType(String payerPaymentType) {
        this.payerPaymentType = payerPaymentType;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerBankName() {
        return payerBankName;
    }

    public void setPayerBankName(String payerBankName) {
        this.payerBankName = payerBankName;
    }

    public String getPayerBankAccount() {
        return payerBankAccount;
    }

    public void setPayerBankAccount(String payerBankAccount) {
        this.payerBankAccount = payerBankAccount;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeBankCardNO() {
        return payeeBankCardNO;
    }

    public void setPayeeBankCardNO(String payeeBankCardNO) {
        this.payeeBankCardNO = payeeBankCardNO;
    }

    public String getPayeeBankName() {
        return payeeBankName;
    }

    public void setPayeeBankName(String payeeBankName) {
        this.payeeBankName = payeeBankName;
    }

    public String getPayeeBankBranchName() {
        return payeeBankBranchName;
    }

    public void setPayeeBankBranchName(String payeeBankBranchName) {
        this.payeeBankBranchName = payeeBankBranchName;
    }

    public String getPayeeBankBranchNO() {
        return payeeBankBranchNO;
    }

    public void setPayeeBankBranchNO(String payeeBankBranchNO) {
        this.payeeBankBranchNO = payeeBankBranchNO;
    }

    public String getPayeeBankProvince() {
        return payeeBankProvince;
    }

    public void setPayeeBankProvince(String payeeBankProvince) {
        this.payeeBankProvince = payeeBankProvince;
    }

    public String getPayeeBankLocation() {
        return payeeBankLocation;
    }

    public void setPayeeBankLocation(String payeeBankLocation) {
        this.payeeBankLocation = payeeBankLocation;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getCertificationType() {
        return certificationType;
    }

    public void setCertificationType(String certificationType) {
        this.certificationType = certificationType;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getAcceptCcy() {
        return acceptCcy;
    }

    public void setAcceptCcy(String acceptCcy) {
        this.acceptCcy = acceptCcy;
    }

    public String getAcceptAmount() {
        return acceptAmount;
    }

    public void setAcceptAmount(String acceptAmount) {
        this.acceptAmount = acceptAmount;
    }

    public String getReimEmployeeId() {
        return reimEmployeeId;
    }

    public void setReimEmployeeId(String reimEmployeeId) {
        this.reimEmployeeId = reimEmployeeId;
    }

    public String getSubsidiaryBizCode() {
        return subsidiaryBizCode;
    }

    public void setSubsidiaryBizCode(String subsidiaryBizCode) {
        this.subsidiaryBizCode = subsidiaryBizCode;
    }

    public String getSubsidiaryName() {
        return subsidiaryName;
    }

    public void setSubsidiaryName(String subsidiaryName) {
        this.subsidiaryName = subsidiaryName;
    }

    public String getPayeeTarget() {
        return payeeTarget;
    }

    public void setPayeeTarget(String payeeTarget) {
        this.payeeTarget = payeeTarget;
    }
}
