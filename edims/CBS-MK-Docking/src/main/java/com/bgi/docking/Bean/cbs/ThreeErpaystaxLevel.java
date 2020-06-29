package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;

/**
 * 作者:Kangy
 * 日期:2019/9/19 9:55
 * <p>
 * 三级请求对象，
 * 用于  查询支付状态
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "ERPAYSTAX")
//按指定顺序生成xml
@XmlType
public class ThreeErpaystaxLevel {
    /**
     * 客户参考业务号
     * C（1,30）
     * 否
     * ERP系统唯一编号
     */
    private String refnbr;
    /**
     * 业务流水号
     * C(12)
     * 否
     * CBS生成的流水号
     */
    private String busnbr;


    @Override
    public String toString() {
        return "ThreeErpaystaxLevel{" +
                "refnbr='" + refnbr + '\'' +
                ", busnbr='" + busnbr + '\'' +
                '}';
    }

    @XmlElement(name = "REFNBR")
    public String getRefnbr() {
        return refnbr;
    }

    public void setRefnbr(String refnbr) {
        this.refnbr = refnbr;
    }

    @XmlElement(name = "BUSNBR")
    public String getBusnbr() {
        return busnbr;
    }

    public void setBusnbr(String busnbr) {
        this.busnbr = busnbr;
    }
}
