package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 作者:Kangy
 * 日期:2019/9/17 15:29
 * <p>
 *
 *
 * 一级返回目录用OneLevel
 * 返回对象     二级返回目录
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "CBSERPPGK")
//按指定顺序生成xml
@XmlType
public class TwoResponse {

    /**
     * INFO 是只接口指令是否成功；
     */
    private ThreeInfoResponse info;
    /**
     * APPAYSAVZ是支付接口返回是否成功；
     */
    private ThreeAppaysavzResponse appaysavz;
    /**
     * SYCOMRETZ是CBS后台系统同步是否成功；
     */
    private TreeSycomretzResponse sycomretz;



    private List<ThreeErpaystazResponse> erpaystaz;


    @Override
    public String toString() {
        return "TwoResponse{" +
                "info=" + info +
                ", appaysavz=" + appaysavz +
                ", sycomretz=" + sycomretz +
                ", erpaystaz=" + erpaystaz +
                '}';
    }
    @XmlElement(name = "ERPAYSTAZ")
    public List<ThreeErpaystazResponse> getErpaystaz() {
        return erpaystaz;
    }
    public void setErpaystaz(List<ThreeErpaystazResponse> erpaystaz) {
        this.erpaystaz = erpaystaz;
    }
    @XmlElement(name = "INFO")
    public ThreeInfoResponse getInfo() {
        return info;
    }

    public void setInfo(ThreeInfoResponse info) {
        this.info = info;
    }
    @XmlElement(name = "APPAYSAVZ")
    public ThreeAppaysavzResponse getAppaysavz() {
        return appaysavz;
    }

    public void setAppaysavz(ThreeAppaysavzResponse appaysavz) {
        this.appaysavz = appaysavz;
    }
    @XmlElement(name = "SYCOMRETZ")
    public TreeSycomretzResponse getSycomretz() {
        return sycomretz;
    }

    public void setSycomretz(TreeSycomretzResponse sycomretz) {
        this.sycomretz = sycomretz;
    }
}
