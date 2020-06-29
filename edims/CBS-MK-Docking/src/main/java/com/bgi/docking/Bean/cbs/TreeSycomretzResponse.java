package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;

/**
 * 作者:Kangy
 * 日期:2019/9/17 16:23
 * <p>
 *     INFO 是只接口指令是否成功；APPAYSAVZ是支付接口返回是否成功；SYCOMRETZ是CBS后台系统同步是否成功；
 * 返回对象   三级返回目录
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "SYCOMRETZ")
//按指定顺序生成xml
@XmlType
public class TreeSycomretzResponse {

    /**
     * 错误码
     */
    private String errcod;
    /**
     * 错误详细信息
     */
    private String errdtl;
    /**
     * 错误信息
     */
    private String errmsg;


    @Override
    public String toString() {
        return "TreeSycomretzResponse{" +
                "errcod='" + errcod + '\'' +
                ", errdtl='" + errdtl + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
    @XmlElement(name = "ERRCOD")
    public String getErrcod() {
        return errcod;
    }

    public void setErrcod(String errcod) {
        this.errcod = errcod;
    }
    @XmlElement(name = "ERRDTL")
    public String getErrdtl() {
        return errdtl;
    }

    public void setErrdtl(String errdtl) {
        this.errdtl = errdtl;
    }
    @XmlElement(name = "ERRMSG")
    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
