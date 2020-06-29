package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;

/**
 * 作者:Kangy
 * 日期:2019/9/17 16:20
 *
 * INFO 是只接口指令是否成功；APPAYSAVZ是支付接口返回是否成功；SYCOMRETZ是CBS后台系统同步是否成功；
 * 返回对象     三级返回目录
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "APPAYSAVZ")
//按指定顺序生成xml
@XmlType
public class ThreeAppaysavzResponse {
    /**
     * 返回代码
     */
    private String errcod;
    /**
     * 错误信息
     */
    private String errmsg;
    /**
     *
     */
    private String recnum;
    /**
     * 客户参考业务号
     */
    private String refnbr;
    /**
     * 业务流水号
     */
    private String busnbr;

    @Override
    public String toString() {
        return "ThreeAppaysavzResponse{" +
                "errcod='" + errcod + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", recnum='" + recnum + '\'' +
                ", refnbr='" + refnbr + '\'' +
                ", busnbr='" + busnbr + '\'' +
                '}';
    }

    @XmlElement(name = "BUSNBR")
    public String getBusnbr() {
        return busnbr;
    }

    public void setBusnbr(String busnbr) {
        this.busnbr = busnbr;
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
    @XmlElement(name = "RECNUM")
    public String getRecnum() {
        return recnum;
    }

    public void setRecnum(String recnum) {
        this.recnum = recnum;
    }
    @XmlElement(name = "REFNBR")
    public String getRefnbr() {
        return refnbr;
    }

    public void setRefnbr(String refnbr) {
        this.refnbr = refnbr;
    }
}
