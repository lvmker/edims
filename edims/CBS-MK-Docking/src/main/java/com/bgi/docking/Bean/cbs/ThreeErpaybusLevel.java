package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 作者:Kangy
 * 日期:2019/9/18 19:52
 *
 * 查支付业务是否存在(ERPAYBUS)  使用这个
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "ERPAYBUSX")
//按指定顺序生成xml
@XmlType(propOrder = {"refnbr",
        "cltacc",
        "trsamt",
        "revacc"})
public class ThreeErpaybusLevel implements Serializable {
    /**
     * 客户参考业务号
     * C（1,30）
     * 否
     * ERP系统唯一编号
     */
    private String refnbr;
    /**
     * 付方账号
     * C（1,35）
     * 否
     */
    private String cltacc;
    /**
     * 金额
     * M(15,2)
     * 1-
     * 否
     */
    private String trsamt;
    /**
     * 收款人账号
     * C（1,35）
     * 否
     * 内转时为收款内部户，其他业务为收款银行账号
     */
    private String revacc;


    @Override
    public String toString() {
        return "ThreeErpaybusLevel{" +
                "refnbr='" + refnbr + '\'' +
                ", cltacc='" + cltacc + '\'' +
                ", trsamt='" + trsamt + '\'' +
                ", revacc='" + revacc + '\'' +
                '}';
    }
    @XmlElement(name = "REFNBR")
    public String getRefnbr() {
        return refnbr;
    }

    public void setRefnbr(String refnbr) {
        this.refnbr = refnbr;
    }
    @XmlElement(name = "CLTACC")
    public String getCltacc() {
        return cltacc;
    }

    public void setCltacc(String cltacc) {
        this.cltacc = cltacc;
    }
    @XmlElement(name = "TRSAMT")
    public String getTrsamt() {
        return trsamt;
    }

    public void setTrsamt(String trsamt) {
        this.trsamt = trsamt;
    }
    @XmlElement(name = "REVACC")
    public String getRevacc() {
        return revacc;
    }

    public void setRevacc(String revacc) {
        this.revacc = revacc;
    }


}
