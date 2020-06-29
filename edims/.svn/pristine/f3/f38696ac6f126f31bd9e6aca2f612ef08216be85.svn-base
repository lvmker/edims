package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;

/**
 * 作者:Kangy
 * 日期:2019/9/17 15:32
 * <p>
 *  INFO 是只接口指令是否成功；APPAYSAVZ是支付接口返回是否成功；SYCOMRETZ是CBS后台系统同步是否成功；
 * 返回对象    三级返回目录
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "INFO")
//按指定顺序生成xml
@XmlType
public class ThreeInfoResponse {

    private String erptyp;
    /**
     * 错误信息
     */
    private String errmsg;
    /**
     * 函数名
     */
    private String funnam;
    /**
     * 返回代码
     */
    private String retcod;


    @Override
    public String toString() {
        return "ThreeInfoResponse{" +
                "erptyp='" + erptyp + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", funnam='" + funnam + '\'' +
                ", retcod='" + retcod + '\'' +
                '}';
    }
    @XmlElement(name = "ERPTYP")
    public String getErptyp() {
        return erptyp;
    }

    public void setErptyp(String erptyp) {
        this.erptyp = erptyp;
    }
    @XmlElement(name = "ERRMSG")
    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    @XmlElement(name = "FUNNAM")
    public String getFunnam() {
        return funnam;
    }

    public void setFunnam(String funnam) {
        this.funnam = funnam;
    }
    @XmlElement(name = "RETCOD")
    public String getRetcod() {
        return retcod;
    }

    public void setRetcod(String retcod) {
        this.retcod = retcod;
    }
}
