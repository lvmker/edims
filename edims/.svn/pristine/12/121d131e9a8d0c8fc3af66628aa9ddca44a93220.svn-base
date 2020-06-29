package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 作者:Kangy
 * 日期:2019/9/16 11:11
 *
 * CBS请求  二级根对象
 * 注意：CBS使用的编码表是GBK
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "CBSERPPGK")
//按指定顺序生成xml
@XmlType(propOrder = {"info","appaysavx","erpaybusx"})
public class TwoLevel implements Serializable {

    private ThreeInfoLevel info;
    /**
     * ERP支付经办请求使用这个
     */
    private ThreeAppaysavxLevel appaysavx;
    /**
     * 查支付业务是否存在(ERPAYBUS)  使用这个
     */
    private ThreeErpaybusLevel erpaybusx;


    //private String apathinfy;


    @Override
    public String toString() {
        return "TwoLevel{" +
                "info=" + info +
                ", appaysavx=" + appaysavx +
                ", erpaybusx=" + erpaybusx +
                '}';
    }
    @XmlElement(name = "ERPAYBUSX")
    public ThreeErpaybusLevel getErpaybusx() {
        return erpaybusx;
    }

    public void setErpaybusx(ThreeErpaybusLevel erpaybusx) {
        this.erpaybusx = erpaybusx;
    }

    @XmlElement(name = "INFO")
    public ThreeInfoLevel getInfo() {
        return info;
    }

    public void setInfo(ThreeInfoLevel info) {
        this.info = info;
    }

    @XmlElement(name = "APPAYSAVX")
    public ThreeAppaysavxLevel getAppaysavx() {
        return appaysavx;
    }

    public void setAppaysavx(ThreeAppaysavxLevel appaysavx) {
        this.appaysavx = appaysavx;
    }
}
