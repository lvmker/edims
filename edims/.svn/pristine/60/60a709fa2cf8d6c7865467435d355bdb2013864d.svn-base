package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;

/**
 * 作者:Kangy
 * 日期:2019/9/18 16:41
 *
 *
 * 返回对象  三级返回目录
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "ERPAYSTAZ")
//按指定顺序生成xml
@XmlType
public class ThreeErpaystazResponse {

    /**
     *
     * 业务状态
     * AC-中心手工录入后需人工复核
     * AD-待预处理
     * AE-审批否决
     * AF-确认支付失败
     * AM-待审批
     * AN-待支付重发审批
     * AQ-业务撤消
     * AW-待企业审批
     * BE-支付信息有误
     * BF-银行支付失败
     * BP-直联支付中
     * BQ-状态可疑
     * BR-银行退票
     * BT-已提交直联接口进行支付
     * BW-待银行答复
     * CC-客户处理中
     * CD-客户撤消
     * CF-客户审批否决
     * CL-已取消支付
     * CP-待中心处理
     * DB-部分成功
     * DP-已支付
     * EP-待银保通支付
     * ET-银保通支付中
     * GC-分公司取消
     * GD-部分成功
     * GF-文件导出
     * GQ-中意可疑状态
     * MC-待人工确认
     * OD-过期
     * PP-待票据打印
     * RW-等待刷新	否	该状态与结算业务查询界面看到的状态相同
     */
    /**
     * 业务流水号	    C(12)		否
     */
    private String busnbr;
    /**
     * 客户参考业务号	C（1,30）		否	ERP系统唯一编号
     */
    private String refnbr;	//
    /**
     * 错误码	        C(7)		否	0000000表示成功，否则表示失败
     */
    private String errcod;	//
    /**
     * 记录状态
     *      0查无此记录（状态可疑）
     *      1：支付成功
     *      2：支付失败
     *      3：未完成
     *      4：银行退票
     *      否
     */
    private String status;	//
    /**
     *  业务状态	    C(2)
     */
    private String optstu;	//
    /**
     * 备注信息	    Z(1,256)		可	支付失败或否决时的错误信息
     */
    private String remark;	//
    /**
     * 业务类型			可
     */
    private String oprtyp;	//
    /**
     * 付款帐号			可
     */
    private String cltacc;	//


    @Override
    public String toString() {
        return "ThreeErpaystazResponse{" +
                "busnbr='" + busnbr + '\'' +
                ", refnbr='" + refnbr + '\'' +
                ", errcod='" + errcod + '\'' +
                ", status='" + status + '\'' +
                ", optstu='" + optstu + '\'' +
                ", remark='" + remark + '\'' +
                ", oprtyp='" + oprtyp + '\'' +
                ", cltacc='" + cltacc + '\'' +
                '}';
    }
    @XmlElement(name = "BUSNBR")
    public String getBusnbr() {
        return busnbr;
    }

    public void setBusnbr(String busnbr) {
        this.busnbr = busnbr;
    }
    @XmlElement(name = "REFNBR")
    public String getRefnbr() {
        return refnbr;
    }

    public void setRefnbr(String refnbr) {
        this.refnbr = refnbr;
    }
    @XmlElement(name = "ERRCOD")
    public String getErrcod() {
        return errcod;
    }

    public void setErrcod(String errcod) {
        this.errcod = errcod;
    }
    @XmlElement(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @XmlElement(name = "OPTSTU")
    public String getOptstu() {
        return optstu;
    }

    public void setOptstu(String optstu) {
        this.optstu = optstu;
    }
    @XmlElement(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @XmlElement(name = "OPRTYP")
    public String getOprtyp() {
        return oprtyp;
    }

    public void setOprtyp(String oprtyp) {
        this.oprtyp = oprtyp;
    }
    @XmlElement(name = "CLTACC")
    public String getCltacc() {
        return cltacc;
    }

    public void setCltacc(String cltacc) {
        this.cltacc = cltacc;
    }
}
