package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;

/**
 * 作者:Kangy
 * 日期:2019/9/19 9:24
 *
 * 三级返回对象， 用于查询支付业务是否存在
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "ERPAYBUSZ")
//按指定顺序生成xml
@XmlType
public class ThreeErpaybuszResponse {

    /**
     * 业务流水号
     * C(12)
     * 可
     * 空表示CBS未登记该业务信息
     */
    private String busnbr;
    /**
     * 客户参考业务号
     * C（1,30）
     * 否
     */
    private String refnbr;
    /**
     * 错误码
     * C(7)
     * 否
     * 0000000表示成功，否则表示失败
     */
    private String errcod;
    /**
     * 错误消息
     * Z(1,256)
     * 否
     */
    private String errmsg;

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
    @XmlElement(name = "ERRMSG")
    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "ThreeErpaybuszResponse{" +
                "busnbr='" + busnbr + '\'' +
                ", refnbr='" + refnbr + '\'' +
                ", errcod='" + errcod + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
