package com.bgi.docking.Bean.cbs;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 作者:Kangy
 * 日期:2019/9/16 9:36
 * <p>
 * <p>
 * ERP支付经办请求(ERPAYSAV)
 */

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "APPAYSAVX")
//按指定顺序生成xml
@XmlType(propOrder = {
        "recnum",
        "oprtyp",
        "bustyp",
        "refnbr",
        //"eptdat",
        //"epttim",
        "cltacc",
        //"cltnbr",
        "trsamt",
        "ccynbr",
        "trsuse",
        //"exttx1",
        //"innacc",
        "revacc",
        "revbnk",
        "revnam",
        "revprv",
        "revcit",
        "bnktyp",
        //"bnkprm",
        "brdnbr",
        "oprmod",
        "paytyp",
        "copflg",
        "ctyflg",
        "payson",
        "trasty",
        "ornttn",
        "grdflg",
        "itmnbr",
        "plnnbr",
        "amtex1",
        "amtex2",
        "amtex3",
        "erpcm1",
        "erpcm2",
        "erpcm3",
        "cnvnbr",
        "trscat",
        "actrac",
        "actpac",
        "revtyp",
        "pkzflg",
        "dccseq",
        "gctflg",
        "gpyson",
        "gpybtm",
        "gbkprm",
        "gbrdnb",
        "gtrsty",
        "gorntn",
        "ggrflg",
        "gkzflg",
        "gopflg",
        "grvtyp",
        "fatpac",
        "revcat",
        "paycat",
        "insnbr",
        "dbcflg",
        "comacn",
        "gdcflg",
        "impdat"})
public class ThreeAppaysavxLevel implements Serializable {

    /**
     * 记录序号
     */
    private String recnum;
    /**
     * 操作类型
     * 202-对外支付    默认
     * 204-银行调拨
     * 206-内转
     * 401-集中支付
     * 235-网银互联
     * 236-集中网银互联
     * 215-联动支付
     */
    private String oprtyp;
    /**
     * 业务子类型
     * 0-   标准支付
     */
    private String bustyp;
    /**
     * 客户参考业务号
     * ERP系统唯一编号，此编号同一渠道不能重复提交（code+payeeTargetBizCode）
     */
    private String refnbr;
    /**
     * 付方账号
     * <p>
     * 对于内转业务为内部付款账号，其他业务为付款银行账号，账号必须系统内登记且用户有操作权限（payerBankAccount）
     * 集中支付时为空
     */
    private String cltacc;
    /**
     * 金额
     * 对应paidAmount
     */
    private String trsamt;
    /**
     * 币种
     * acceptCcy
     */
    private String ccynbr;
    /**
     * 交易用途
     * 工行控制10个汉字内
     */
    private String trsuse;
    /**
     * 收款人账号
     * 对应payeeBankCardNO
     */
    private String revacc;
    /**
     * 收款人开户行
     * payeeBankBranchName
     */
    private String revbnk;
    /**
     * 收款人名称
     * payeeName
     */
    private String revnam;
    /**
     * 收方省份
     * payeeBankProvince
     */
    private String revprv;
    /**
     * 收方城市
     * payeeBankLocation
     */
    private String revcit;
    /**
     * 收款银行类型
     * 参见参数列表：银行类型
     * 如：ICB-工商银行，传 ICB
     */
    private String bnktyp;

    //private String bnkprm;   //银行号
    /**
     * 银行联行号
     * payeeBankBranchNO
     */
    private String brdnbr;
    /**
     * 支付渠道
     * 付款银行账号开通直连时，默认选择3
     * 0-其他
     * 2-打印银行票据
     * 3-银企直联支付
     * 5-银保通支付
     */
    private String oprmod;
    /**
     * 结算方式
     * <p>
     * 0-其它
     * 2-转账   默认2
     * 3-电汇
     * 4-汇票
     */
    private String paytyp;
    /**
     * 公私标志
     * 1-  对私
     * 2-  对公
     * payeeTarget映射   除了对私，其他都是对公
     */
    private String copflg;
    /**
     * 是否同城
     * <p>
     * 0-   同城
     * 1-   异地   默认1
     */
    private String ctyflg;
    private String payson;//是否加急
    private String trasty;//转账方式
    private String ornttn;//是否定向
    private String grdflg;//是否落地
    private String itmnbr;//预算项编号
    private String plnnbr;//资金计划流水号
    private String amtex1;//预算项(或会议批准金额)
    private String amtex2;//已支付金额
    private String amtex3;//剩余预算金额
    private String erpcm1;//ERP备注1
    /**
     * ERP备注2
     * payeeTargetBizCode
     */
    private String erpcm2;//ERP备注2
    private String erpcm3;//ERP备注3
    private String cnvnbr;//网银互联协议编号
    private String trscat;//网银互联业务类型
    private String actrac;//收款实体账号
    private String actpac;//付款实体账号
    private String revtyp;//收方账户类型
    private String pkzflg;//卡折标识
    private String dccseq;//直联流水号
    private String gctflg;//总到子是否同城
    private String gpyson;//总到子是否加急
    private String gpybtm;//总到子是否实时
    private String gbkprm;//总到子银行号
    private String gbrdnb;//总到子银行联行号跨行联动支付用
    private String gtrsty;//总到子转账方式
    private String gorntn;//总到子是否定向
    private String ggrflg;//总到子是否落地
    private String gkzflg;//总到子卡折标志
    private String gopflg;//总到子对公对私标志
    private String grvtyp;//总到子收方类型
    private String fatpac;//付款总账号
    private String revcat;//收款人类别
    private String paycat;//支付类别
    private String insnbr;//用途前面是否前插流水号
    private String dbcflg;//结算卡标志
    private String comacn;//手续费账号
    private String gdcflg;//结算卡标志
    private String impdat;//导入日期
    //private String busnbr;//关联序号（与APPAYSAVX中的recnum相等）
    //private String athnbr;//CBS后台附件编号
    //private String athnam;//附件名字

    @XmlElement(name = "RECNUM")
    public String getRecnum() {
        return recnum;
    }

    public void setRecnum(String recnum) {
        this.recnum = recnum;
    }

    @XmlElement(name = "OPRTYP")
    public String getOprtyp() {
        return oprtyp;
    }

    public void setOprtyp(String oprtyp) {
        this.oprtyp = oprtyp;
    }

    @XmlElement(name = "BUSTYP")
    public String getBustyp() {
        return bustyp;
    }

    public void setBustyp(String bustyp) {
        this.bustyp = bustyp;
    }

    @XmlElement(name = "REFNBR")
    public String getRefnbr() {
        return refnbr;
    }

    public void setRefnbr(String refnbr) {
        this.refnbr = refnbr;
    }

    @XmlElement(name = "CLTACC")
    public String getCltacc() {
        return cltacc;
    }

    public void setCltacc(String cltacc) {
        this.cltacc = cltacc;
    }

    @XmlElement(name = "TRSAMT")
    public String getTrsamt() {
        return trsamt;
    }

    public void setTrsamt(String trsamt) {
        this.trsamt = trsamt;
    }

    @XmlElement(name = "CCYNBR")
    public String getCcynbr() {
        return ccynbr;
    }

    public void setCcynbr(String ccynbr) {
        this.ccynbr = ccynbr;
    }

    @XmlElement(name = "TRSUSE")
    public String getTrsuse() {
        return trsuse;
    }

    public void setTrsuse(String trsuse) {
        this.trsuse = trsuse;
    }

    @XmlElement(name = "REVACC")
    public String getRevacc() {
        return revacc;
    }

    public void setRevacc(String revacc) {
        this.revacc = revacc;
    }

    @XmlElement(name = "REVBNK")
    public String getRevbnk() {
        return revbnk;
    }

    public void setRevbnk(String revbnk) {
        this.revbnk = revbnk;
    }

    @XmlElement(name = "REVNAM")
    public String getRevnam() {
        return revnam;
    }

    public void setRevnam(String revnam) {
        this.revnam = revnam;
    }

    @XmlElement(name = "REVPRV")
    public String getRevprv() {
        return revprv;
    }

    public void setRevprv(String revprv) {
        this.revprv = revprv;
    }

    @XmlElement(name = "REVCIT")
    public String getRevcit() {
        return revcit;
    }

    public void setRevcit(String revcit) {
        this.revcit = revcit;
    }

    @XmlElement(name = "BNKTYP")
    public String getBnktyp() {
        return bnktyp;
    }

    public void setBnktyp(String bnktyp) {
        this.bnktyp = bnktyp;
    }

    @XmlElement(name = "BRDNBR")
    public String getBrdnbr() {
        return brdnbr;
    }

    public void setBrdnbr(String brdnbr) {
        this.brdnbr = brdnbr;
    }

    @XmlElement(name = "OPRMOD")
    public String getOprmod() {
        return oprmod;
    }

    public void setOprmod(String oprmod) {
        this.oprmod = oprmod;
    }

    @XmlElement(name = "PAYTYP")
    public String getPaytyp() {
        return paytyp;
    }

    public void setPaytyp(String paytyp) {
        this.paytyp = paytyp;
    }

    @XmlElement(name = "COPFLG")
    public String getCopflg() {
        return copflg;
    }

    public void setCopflg(String copflg) {
        this.copflg = copflg;
    }

    @XmlElement(name = "CTYFLG")
    public String getCtyflg() {
        return ctyflg;
    }

    public void setCtyflg(String ctyflg) {
        this.ctyflg = ctyflg;
    }

    @XmlElement(name = "PAYSON")
    public String getPayson() {
        return payson;
    }

    public void setPayson(String payson) {
        this.payson = payson;
    }

    @XmlElement(name = "TRASTY")
    public String getTrasty() {
        return trasty;
    }

    public void setTrasty(String trasty) {
        this.trasty = trasty;
    }

    @XmlElement(name = "ORNTTN")
    public String getOrnttn() {
        return ornttn;
    }

    public void setOrnttn(String ornttn) {
        this.ornttn = ornttn;
    }

    @XmlElement(name = "GRDFLG")
    public String getGrdflg() {
        return grdflg;
    }

    public void setGrdflg(String grdflg) {
        this.grdflg = grdflg;
    }

    @XmlElement(name = "ITMNBR")
    public String getItmnbr() {
        return itmnbr;
    }

    public void setItmnbr(String itmnbr) {
        this.itmnbr = itmnbr;
    }

    @XmlElement(name = "PLNNBR")
    public String getPlnnbr() {
        return plnnbr;
    }

    public void setPlnnbr(String plnnbr) {
        this.plnnbr = plnnbr;
    }

    @XmlElement(name = "AMTEX1")
    public String getAmtex1() {
        return amtex1;
    }

    public void setAmtex1(String amtex1) {
        this.amtex1 = amtex1;
    }

    @XmlElement(name = "AMTEX2")
    public String getAmtex2() {
        return amtex2;
    }

    public void setAmtex2(String amtex2) {
        this.amtex2 = amtex2;
    }

    @XmlElement(name = "AMTEX3")
    public String getAmtex3() {
        return amtex3;
    }

    public void setAmtex3(String amtex3) {
        this.amtex3 = amtex3;
    }

    @XmlElement(name = "ERPCM1")
    public String getErpcm1() {
        return erpcm1;
    }

    public void setErpcm1(String erpcm1) {
        this.erpcm1 = erpcm1;
    }

    @XmlElement(name = "ERPCM2")
    public String getErpcm2() {
        return erpcm2;
    }

    public void setErpcm2(String erpcm2) {
        this.erpcm2 = erpcm2;
    }

    @XmlElement(name = "ERPCM3")
    public String getErpcm3() {
        return erpcm3;
    }

    public void setErpcm3(String erpcm3) {
        this.erpcm3 = erpcm3;
    }

    @XmlElement(name = "CNVNBR")
    public String getCnvnbr() {
        return cnvnbr;
    }

    public void setCnvnbr(String cnvnbr) {
        this.cnvnbr = cnvnbr;
    }

    @XmlElement(name = "TRSCAT")
    public String getTrscat() {
        return trscat;
    }

    public void setTrscat(String trscat) {
        this.trscat = trscat;
    }

    @XmlElement(name = "ACTRAC")
    public String getActrac() {
        return actrac;
    }

    public void setActrac(String actrac) {
        this.actrac = actrac;
    }

    @XmlElement(name = "ACTPAC")
    public String getActpac() {
        return actpac;
    }

    public void setActpac(String actpac) {
        this.actpac = actpac;
    }

    @XmlElement(name = "REVTYP")
    public String getRevtyp() {
        return revtyp;
    }

    public void setRevtyp(String revtyp) {
        this.revtyp = revtyp;
    }

    @XmlElement(name = "PKZFLG")
    public String getPkzflg() {
        return pkzflg;
    }

    public void setPkzflg(String pkzflg) {
        this.pkzflg = pkzflg;
    }

    @XmlElement(name = "DCCSEQ")
    public String getDccseq() {
        return dccseq;
    }

    public void setDccseq(String dccseq) {
        this.dccseq = dccseq;
    }

    @XmlElement(name = "GCTFLG")
    public String getGctflg() {
        return gctflg;
    }

    public void setGctflg(String gctflg) {
        this.gctflg = gctflg;
    }

    @XmlElement(name = "GPYSON")
    public String getGpyson() {
        return gpyson;
    }

    public void setGpyson(String gpyson) {
        this.gpyson = gpyson;
    }

    @XmlElement(name = "GPYBTM")
    public String getGpybtm() {
        return gpybtm;
    }

    public void setGpybtm(String gpybtm) {
        this.gpybtm = gpybtm;
    }

    @XmlElement(name = "GBKPRM")
    public String getGbkprm() {
        return gbkprm;
    }

    public void setGbkprm(String gbkprm) {
        this.gbkprm = gbkprm;
    }

    @XmlElement(name = "GBRDNB")
    public String getGbrdnb() {
        return gbrdnb;
    }

    public void setGbrdnb(String gbrdnb) {
        this.gbrdnb = gbrdnb;
    }

    @XmlElement(name = "GTRSTY")
    public String getGtrsty() {
        return gtrsty;
    }

    public void setGtrsty(String gtrsty) {
        this.gtrsty = gtrsty;
    }

    @XmlElement(name = "GORNTN")
    public String getGorntn() {
        return gorntn;
    }

    public void setGorntn(String gorntn) {
        this.gorntn = gorntn;
    }

    @XmlElement(name = "GGRFLG")
    public String getGgrflg() {
        return ggrflg;
    }

    public void setGgrflg(String ggrflg) {
        this.ggrflg = ggrflg;
    }

    @XmlElement(name = "GKZFLG")
    public String getGkzflg() {
        return gkzflg;
    }

    public void setGkzflg(String gkzflg) {
        this.gkzflg = gkzflg;
    }

    @XmlElement(name = "GOPFLG")
    public String getGopflg() {
        return gopflg;
    }

    public void setGopflg(String gopflg) {
        this.gopflg = gopflg;
    }

    @XmlElement(name = "GRVTYP")
    public String getGrvtyp() {
        return grvtyp;
    }

    public void setGrvtyp(String grvtyp) {
        this.grvtyp = grvtyp;
    }

    @XmlElement(name = "FATPAC")
    public String getFatpac() {
        return fatpac;
    }

    public void setFatpac(String fatpac) {
        this.fatpac = fatpac;
    }

    @XmlElement(name = "FATPAC")
    public String getRevcat() {
        return revcat;
    }

    public void setRevcat(String revcat) {
        this.revcat = revcat;
    }

    @XmlElement(name = "PAYCAT")
    public String getPaycat() {
        return paycat;
    }

    public void setPaycat(String paycat) {
        this.paycat = paycat;
    }

    @XmlElement(name = "INSNBR")
    public String getInsnbr() {
        return insnbr;
    }

    public void setInsnbr(String insnbr) {
        this.insnbr = insnbr;
    }

    @XmlElement(name = "DBCFLG")
    public String getDbcflg() {
        return dbcflg;
    }

    public void setDbcflg(String dbcflg) {
        this.dbcflg = dbcflg;
    }

    @XmlElement(name = "COMACN")
    public String getComacn() {
        return comacn;
    }

    public void setComacn(String comacn) {
        this.comacn = comacn;
    }

    @XmlElement(name = "GDCFLG")
    public String getGdcflg() {
        return gdcflg;
    }

    public void setGdcflg(String gdcflg) {
        this.gdcflg = gdcflg;
    }

    @XmlElement(name = "IMPDAT")
    public String getImpdat() {
        return impdat;
    }

    public void setImpdat(String impdat) {
        this.impdat = impdat;
    }

    @Override
    public String toString() {
        return "ThreeAppaysavxLevel{" +
                "recnum='" + recnum + '\'' +
                ", oprtyp='" + oprtyp + '\'' +
                ", bustyp='" + bustyp + '\'' +
                ", refnbr='" + refnbr + '\'' +
                ", cltacc='" + cltacc + '\'' +
                ", trsamt='" + trsamt + '\'' +
                ", ccynbr='" + ccynbr + '\'' +
                ", trsuse='" + trsuse + '\'' +
                ", revacc='" + revacc + '\'' +
                ", revbnk='" + revbnk + '\'' +
                ", revnam='" + revnam + '\'' +
                ", revprv='" + revprv + '\'' +
                ", revcit='" + revcit + '\'' +
                ", bnktyp='" + bnktyp + '\'' +
                ", brdnbr='" + brdnbr + '\'' +
                ", oprmod='" + oprmod + '\'' +
                ", paytyp='" + paytyp + '\'' +
                ", copflg='" + copflg + '\'' +
                ", ctyflg='" + ctyflg + '\'' +
                ", payson='" + payson + '\'' +
                ", trasty='" + trasty + '\'' +
                ", ornttn='" + ornttn + '\'' +
                ", grdflg='" + grdflg + '\'' +
                ", itmnbr='" + itmnbr + '\'' +
                ", plnnbr='" + plnnbr + '\'' +
                ", amtex1='" + amtex1 + '\'' +
                ", amtex2='" + amtex2 + '\'' +
                ", amtex3='" + amtex3 + '\'' +
                ", erpcm1='" + erpcm1 + '\'' +
                ", erpcm2='" + erpcm2 + '\'' +
                ", erpcm3='" + erpcm3 + '\'' +
                ", cnvnbr='" + cnvnbr + '\'' +
                ", trscat='" + trscat + '\'' +
                ", actrac='" + actrac + '\'' +
                ", actpac='" + actpac + '\'' +
                ", revtyp='" + revtyp + '\'' +
                ", pkzflg='" + pkzflg + '\'' +
                ", dccseq='" + dccseq + '\'' +
                ", gctflg='" + gctflg + '\'' +
                ", gpyson='" + gpyson + '\'' +
                ", gpybtm='" + gpybtm + '\'' +
                ", gbkprm='" + gbkprm + '\'' +
                ", gbrdnb='" + gbrdnb + '\'' +
                ", gtrsty='" + gtrsty + '\'' +
                ", gorntn='" + gorntn + '\'' +
                ", ggrflg='" + ggrflg + '\'' +
                ", gkzflg='" + gkzflg + '\'' +
                ", gopflg='" + gopflg + '\'' +
                ", grvtyp='" + grvtyp + '\'' +
                ", fatpac='" + fatpac + '\'' +
                ", revcat='" + revcat + '\'' +
                ", paycat='" + paycat + '\'' +
                ", insnbr='" + insnbr + '\'' +
                ", dbcflg='" + dbcflg + '\'' +
                ", comacn='" + comacn + '\'' +
                ", gdcflg='" + gdcflg + '\'' +
                ", impdat='" + impdat + '\'' +
                '}';
    }
}
