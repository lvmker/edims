package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 作者:Kangy
 * 日期:2019/9/16 14:51
 *
 * CBS请求  三级级根对象
 * 注意：CBS使用的编码表是GBK
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "INFO")
public class ThreeInfoLevel implements Serializable {
    /**
     * 函数名
     */
    private String funnam = "ERPAYSAV";

    public ThreeInfoLevel() {
    }

    public ThreeInfoLevel(String funnam) {
        this.funnam = funnam;
    }

    @Override
    public String toString() {
        return "ThreeInfoLevel{" +
                "funnam='" + funnam + '\'' +
                '}';
    }
    @XmlElement(name = "FUNNAM")
    public String getFunnam() {
        return funnam;
    }

    public void setFunnam(String funnam) {
        this.funnam = funnam;
    }
}
