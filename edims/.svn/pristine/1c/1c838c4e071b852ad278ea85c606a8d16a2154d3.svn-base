package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 作者:Kangy
 * 日期:2019/9/19 9:51
 * <p>
 * 二级请求对象。
 * 用于  查询支付状态
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "CBSERPPGK")
//按指定顺序生成xml
@XmlType
public class TwoCbserppgkLevel {

    private ThreeInfoLevel info;
    private List<ThreeErpaystaxLevel> erpaystax;


    @Override
    public String toString() {
        return "TwoCbserppgkLevel{" +
                "info=" + info +
                ", erpaystax=" + erpaystax +
                '}';
    }

    @XmlElement(name = "INFO")
    public ThreeInfoLevel getInfo() {
        return info;
    }

    public void setInfo(ThreeInfoLevel info) {
        this.info = info;
    }

    @XmlElement(name = "ERPAYSTAX")
    public List<ThreeErpaystaxLevel> getErpaystax() {
        return erpaystax;
    }

    public void setErpaystax(List<ThreeErpaystaxLevel> erpaystax) {
        this.erpaystax = erpaystax;
    }
}

