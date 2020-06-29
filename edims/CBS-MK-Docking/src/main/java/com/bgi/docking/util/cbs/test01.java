package com.bgi.docking.util.cbs;

import com.bgi.docking.Bean.cbs.OneLevel;
import com.bgi.docking.Bean.cbs.ThreeAppaysavxLevel;
import com.bgi.docking.Bean.cbs.ThreeInfoLevel;
import com.bgi.docking.Bean.cbs.TwoLevel;

/**
 * 作者:Kangy
 * 日期:2019/9/16 14:32
 */
public class test01 {
    public static void main(String[] args) throws Exception {

        ThreeAppaysavxLevel appaysavx = new ThreeAppaysavxLevel();

        appaysavx.setRecnum("1");
        //appaysavx.setOprtyp("2");
        appaysavx.setBustyp("3");
        appaysavx.setRefnbr("4");
        appaysavx.setCltacc("5");
        appaysavx.setTrsamt("6");
        appaysavx.setCcynbr("7");
        appaysavx.setTrsuse("8");
        appaysavx.setRevacc("9");
        appaysavx.setRevbnk("0");
        appaysavx.setRevnam("123");
        appaysavx.setRevprv("123");
        appaysavx.setRevcit("123");
        appaysavx.setBnktyp("123");
        appaysavx.setBrdnbr("123");
        appaysavx.setOprmod("123");
        appaysavx.setPaytyp("123");
        appaysavx.setCopflg("123");
        appaysavx.setCtyflg("123");
        appaysavx.setPayson("123");
        appaysavx.setTrasty("123");
        appaysavx.setOrnttn("123");
        appaysavx.setGrdflg("123");
        appaysavx.setItmnbr("123");
        appaysavx.setPlnnbr("123");
        appaysavx.setAmtex1("123");
        appaysavx.setAmtex2("123");
        appaysavx.setAmtex3("123");
        appaysavx.setErpcm1("123");
        appaysavx.setErpcm2("123");
        appaysavx.setErpcm3("123");
        appaysavx.setCnvnbr("123");
        appaysavx.setTrscat("123");
        appaysavx.setActrac("123");
        appaysavx.setActpac("123");
        appaysavx.setRevtyp("123");
        appaysavx.setPkzflg("123");
        appaysavx.setDccseq("123");
        appaysavx.setGctflg("123");
        appaysavx.setGpyson("123");
        appaysavx.setGpybtm("123");
        appaysavx.setGbkprm("123");
        appaysavx.setGbrdnb("123");
        appaysavx.setGtrsty("123");
        appaysavx.setGorntn("123");
        appaysavx.setGgrflg("123");
        appaysavx.setGkzflg("123");
        appaysavx.setGopflg("123");
        appaysavx.setGrvtyp("123");
        appaysavx.setFatpac("123");
        appaysavx.setRevcat("123");
        appaysavx.setPaycat("123");
        appaysavx.setInsnbr("123");
        appaysavx.setDbcflg("123");
        appaysavx.setComacn("123");
        appaysavx.setGdcflg("123");
        appaysavx.setImpdat("123");





        TwoLevel two = new TwoLevel();
        two.setInfo(new ThreeInfoLevel("ERPAYSAV"));
        two.setAppaysavx(appaysavx);
        String gbk = JaxbUtil.convertToXml(two, "GBK");
        //使用工具把xml放在<![CDATA[放在这里]]>
        CDataAdapter adapter = new CDataAdapter();
        String marshal = adapter.marshal(gbk);

        OneLevel one = new OneLevel();
        one.setCheckcode("123456");
        one.setData(marshal);

        String s = JaxbUtil.convertToXml(one, "GBK");

        System.out.println(s);


    }
}
