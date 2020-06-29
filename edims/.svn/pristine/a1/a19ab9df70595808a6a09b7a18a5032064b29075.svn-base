package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;

/**
 * 作者:Kangy
 * 日期:2019/9/19 9:18
 *
 * 返回对象
 * 查询支付业务是否存在   ，
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "CBSERPPGK")
//按指定顺序生成xml
@XmlType
public class CbserppgkResponse {
    //INFO
    private ThreeInfoResponse info;
    //ERPAYBUSZ
    private ThreeErpaybuszResponse erpaybusz;
    //SYCOMRETZ
    private TreeSycomretzResponse sycomretz;


    @XmlElement(name = "INFO")
    public ThreeInfoResponse getInfo() {
        return info;
    }

    public void setInfo(ThreeInfoResponse info) {
        this.info = info;
    }
    @XmlElement(name = "ERPAYBUSZ")
    public ThreeErpaybuszResponse getErpaybusz() {
        return erpaybusz;
    }

    public void setErpaybusz(ThreeErpaybuszResponse erpaybusz) {
        this.erpaybusz = erpaybusz;
    }
    @XmlElement(name = "SYCOMRETZ")
    public TreeSycomretzResponse getSycomretz() {
        return sycomretz;
    }

    public void setSycomretz(TreeSycomretzResponse sycomretz) {
        this.sycomretz = sycomretz;
    }

    @Override
    public String toString() {
        return "CbserppgkResponse{" +
                "info=" + info +
                ", erpaybusz=" + erpaybusz +
                ", sycomretz=" + sycomretz +
                '}';
    }
}
