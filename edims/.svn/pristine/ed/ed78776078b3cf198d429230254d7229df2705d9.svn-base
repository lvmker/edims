package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 作者:Kangy
 * 日期:2019/9/16 11:01
 *
 * CBS请求  一级根对象
 *
 * 注意：CBS使用的编码表是GBK
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "PGK")
//按指定顺序生成xml
@XmlType(propOrder = {"data","checkcode"})
public class OneLevel implements Serializable {
    /**
     * 报文内容
     */
    private String data;
    /**
     * 报文秘钥
     */
    private String checkcode;


    @Override
    public String toString() {
        return "OneLevel{" +
                "data='" + data + '\'' +
                ", checkcode='" + checkcode + '\'' +
                '}';
    }
    @XmlElement(name = "DATA")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    @XmlElement(name = "CHECKCODE")
    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }
}
