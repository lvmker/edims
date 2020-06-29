package com.bgi.docking.util;

import com.bgi.docking.Bean.cbs.*;
import com.bgi.docking.Bean.mk.PayForWater;
import com.bgi.docking.pojo.Middle;
import com.bgi.docking.util.cbs.CDataAdapter;
import com.bgi.docking.util.cbs.JaxbUtil;
import com.bgi.docking.util.cbs.SdkUtil;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者:Kangy
 * 日期:2019/9/16 17:26
 * <p>
 * 数据转换工具类
 */
public class TransitionUtil {

    //用户秘钥，用于对应CBS生成报文的秘钥
    @Value("${CBS.secretKey}")
    private String secretKey;

    //银行对应简码集合
    public static Map<String, String> dataMap = new HashMap<>();

    //币种对应集合
    public static Map<String, String> currencyMap = new HashMap<>();

    static {
        //银行类型	银行类型简码
        dataMap.put("中国农业银行", "ABC");
        dataMap.put("中国农业发展银行", "ADB");
        dataMap.put("支付宝", "ALP");
        dataMap.put("安徽农信社", "ARC");
        dataMap.put("北京银行", "BBJ");
        dataMap.put("成都银行", "BCD");
        dataMap.put("交通银行", "BCM");
        dataMap.put("东亚银行", "BEA");
        dataMap.put("北汽财务公司", "BGF");
        dataMap.put("渤海银行", "BHB");
        dataMap.put("华兴银行", "BHX");
        dataMap.put("江苏银行", "BJS");
        dataMap.put("中国银行", "BOC");
        dataMap.put("库尔勒银行", "BOK");
        dataMap.put("北京农商行", "BRB");
        dataMap.put("包商银行", "BSB");
        dataMap.put("上海银行", "BSH");
        dataMap.put("长安银行", "CAB");
        dataMap.put("中国建设银行", "CCB");
        dataMap.put("中信银行", "CCT");
        dataMap.put("国家开发银行", "CDB");
        dataMap.put("#N/A", "CDR");
        dataMap.put("中国光大银行", "CEB");
        dataMap.put("创兴银行", "CHB");
        dataMap.put("兴业银行", "CIB");
        dataMap.put("招商银行", "CMB");
        dataMap.put("中国民生银行", "CMC");
        dataMap.put("东风财务公司", "CMS");
        dataMap.put("重庆农商行", "CQA");
        dataMap.put("庆银行", "CQB");
        dataMap.put("华润银行", "CRB");
        dataMap.put("常熟农商行", "CSB");
        dataMap.put("长沙银行", "CSC");
        dataMap.put("重庆三峡银行", "CTB");
        dataMap.put("银联", "CUP");
        dataMap.put("微保", "CVB");
        dataMap.put("长兴村镇银行", "CXB");
        dataMap.put("浙商银行", "CZB");
        dataMap.put("稠州商业银行", "CZC");
        dataMap.put("星展银行", "DBS");
        dataMap.put("东莞银行", "DGB");
        dataMap.put("大连银行", "DLB");
        dataMap.put("东莞农村商业银行", "DRC");
        dataMap.put("东营银行", "DYC");
        dataMap.put("富滇银行", "FDB");
        dataMap.put("海峡银行", "FHB");
        dataMap.put("福州银行", "FZB");
        dataMap.put("广东发展银行", "GDB");
        dataMap.put("国机财务公司", "GJF");
        dataMap.put("桂林银行", "GLB");
        dataMap.put("广州农商行", "GRB");
        dataMap.put("甘肃银行", "GSB");
        dataMap.put("甘肃农信", "GSR");
        dataMap.put("广西农信", "GXN");
        dataMap.put("贵阳银行", "GYB");
        dataMap.put("贵州银行", "GZA");
        dataMap.put("广州银行", "GZB");
        dataMap.put("恒生银行", "HAS");
        dataMap.put("湖北银行", "HBC");
        dataMap.put("恒丰银行", "HFB");
        dataMap.put("汉口银行", "HKB");
        dataMap.put("哈密银行", "HMB");
        dataMap.put("哈尔滨银行", "HRB");
        dataMap.put("微商银行", "HSB");
        dataMap.put("汇丰银行", "HSC");
        dataMap.put("云南红塔银行", "HTB");
        dataMap.put("湖州银行", "HUB");
        dataMap.put("华夏银行", "HXB");
        dataMap.put("杭州银行", "HZB");
        dataMap.put("中国工商银行", "ICB");
        dataMap.put("晋城银行", "JCB");
        dataMap.put("金川财务公司", "JGF");
        dataMap.put("江南农村商业银行", "JNB");
        dataMap.put("晋商银行", "JSB");
        dataMap.put("江西银行", "JXB");
        dataMap.put("嘉兴银行", "JXC");
        dataMap.put("江阴农商行", "JYR");
        dataMap.put("昆仑银行", "KLB");
        dataMap.put("龙江银行", "LJB");
        dataMap.put("临商银行", "LSC");
        dataMap.put("兰州银行", "LZB");
        dataMap.put("泸州商业银行", "LZC");
        dataMap.put("瑞穗银行", "MZH");
        dataMap.put("宁波银行", "NBB");
        dataMap.put("南洋商业银行", "NCB");
        dataMap.put("南京银行", "NJB");
        dataMap.put("宁夏银行", "NXB");
        dataMap.put("南粤银行", "NYB");
        dataMap.put("旧平安银行", "PAB");
        dataMap.put("上海浦东发展银行", "PDB");
        dataMap.put("中国邮政储蓄银行", "PSB");
        dataMap.put("青岛银行", "QDB");
        dataMap.put("青海银行", "QHB");
        dataMap.put("齐鲁银行", "QLB");
        dataMap.put("齐商银行", "QSB");
        dataMap.put("泉州银行", "QZB");
        dataMap.put("渣打银行", "SCB");
        dataMap.put("平安银行", "SDB");
        dataMap.put("顺德农商行", "SDN");
        dataMap.put("山东农信", "SDR");
        dataMap.put("中材财务公司", "SGF");
        dataMap.put("盛京银行", "SJB");
        dataMap.put("三井住友", "SMB");
        dataMap.put("上海农商行", "SRB");
        dataMap.put("通用银行", "STD");
        dataMap.put("山西农信", "SXN");
        dataMap.put("泰安银行", "TAB");
        dataMap.put("天津银行", "TJB");
        dataMap.put("天津滨海农商行", "TJH");
        dataMap.put("通联", "TLB");
        dataMap.put("泰隆银行", "TLC");
        dataMap.put("天山农商行", "TRB");
        dataMap.put("台州银行", "TZB");
        dataMap.put("乌鲁木齐银行", "UCB");
        dataMap.put("三菱东京日联银行", "UFJ");
        dataMap.put("潍坊银行", "WFB");
        dataMap.put("威海商业银行", "WHB");
        dataMap.put("吴江农商行", "WJB");
        dataMap.put("温州银行", "WZB");
        dataMap.put("西安银行", "XAB");
        dataMap.put("厦门国际银行", "XIB");
        dataMap.put("华融湘江银行", "XJB");
        dataMap.put("新疆银行", "XJC");
        dataMap.put("厦门银行", "XMB");
        dataMap.put("云南省农村信用社", "YNR");
        dataMap.put("烟台银行", "YTB");
        dataMap.put("鄞州银行", "YZA");
        dataMap.put("五家渠村镇银行", "YZB");
        dataMap.put("住建部", "ZJB");
        dataMap.put("浙江农信", "ZJN");
        dataMap.put("淄博农商行", "ZRB");
        dataMap.put("中原银行", "ZYB");
        dataMap.put("郑州银行", "ZZB");
        dataMap.put("郑州农信社", "ZZR");

        currencyMap.put("RMB", "10");//  人民币
        currencyMap.put("CNY", "10");//  人民币
        currencyMap.put("ASF", "11");//  记帐瑞士法朗
        currencyMap.put("BRL", "12");//  巴西里亚尔
        currencyMap.put("IDR", "13");//  印度尼西亚卢比
        currencyMap.put("INR", "14");//  印度卢比
        currencyMap.put("IRR", "15");//  伊朗里亚尔
        currencyMap.put("JOD", "16");//  约旦第纳尔
        currencyMap.put("KRW", "17");//  韩国圆
        currencyMap.put("KWD", "18");//  科威特第纳尔
        currencyMap.put("MOP", "19");//  澳门元
        currencyMap.put("MXN", "20");//  墨西哥比索
        currencyMap.put("HKD", "21");//  港币
        currencyMap.put("MYR", "22");//  马来西亚林吉特
        currencyMap.put("NPR", "23");//  尼泊尔卢比
        currencyMap.put("NZD", "24");//  新西兰元
        currencyMap.put("PHP", "25");//  菲律宾比索
        currencyMap.put("PKR", "26");//  巴基斯坦卢比
        currencyMap.put("RUB", "27");//  俄罗斯卢布
        currencyMap.put("AUD", "29");//  澳元
        currencyMap.put("THB", "30");//  泰国铢
        currencyMap.put("TWD", "31");//  台湾元
        currencyMap.put("USD", "32");//  美元
        currencyMap.put("TZS", "33");//  坦桑尼亚先令
        currencyMap.put("PRK", "34");//  巴基斯坦卢比
        currencyMap.put("EUR", "35");//  欧元
        currencyMap.put("BND", "36");//  文莱元
        currencyMap.put("CAD", "39");//  加拿大元
        currencyMap.put("LKR", "40");//  斯里兰卡卢比
        currencyMap.put("TND", "42");//  突尼斯第纳尔
        currencyMap.put("GBP", "43");//  英镑
        currencyMap.put("UZS", "44");//  乌兹别克斯坦苏姆
        currencyMap.put("XAF", "45");//  中非法郎
        currencyMap.put("GEL", "47");//  格鲁吉亚拉里
        currencyMap.put("MNT", "48");//  蒙图
        currencyMap.put("JPY", "65");//  日元
        currencyMap.put("SGD", "69");//  新加坡元
        currencyMap.put("AON", "71");//  安哥拉宽扎
        currencyMap.put("DZD", "72");//  阿尔及利亚第纳尔
        currencyMap.put("GHS", "73");//  塞地
        currencyMap.put("KES", "74");//  肯尼亚先令
        currencyMap.put("NGN", "75");//  奈拉
        currencyMap.put("QAR", "76");//  卡塔尔里亚尔
        currencyMap.put("VND", "77");//  越南盾
        currencyMap.put("PES", "78");//  新索尔
        currencyMap.put("PLZ", "79");//  兹罗提
        currencyMap.put("TRY", "80");//  土耳其镑
        currencyMap.put("SAR", "81");//  亚尔
        currencyMap.put("KZT", "82");//  哈萨克斯坦腾格
        currencyMap.put("NOK", "83");//  挪威克朗
        currencyMap.put("DKK", "85");//  丹麦克朗
        currencyMap.put("AED", "86");//  阿联酋迪拉姆
        currencyMap.put("CHF", "87");//  瑞士法朗
        currencyMap.put("SEK", "88");//  瑞典克朗
        currencyMap.put("ZAR", "89");//  南非兰特
        currencyMap.put("CDF", "90");//  刚果法郎
        currencyMap.put("LYD", "91");//  利比亚第纳尔
        currencyMap.put("EGP", "92");//  埃及磅
        currencyMap.put("VEF", "93");//  委内瑞拉玻利瓦尔
        currencyMap.put("OMR", "94");//  阿曼里尔
        currencyMap.put("PLN", "95");//  波兰兹罗提
        currencyMap.put("HUF", "96");//  匈牙利福林
        currencyMap.put("BDT", "97");//  孟加拉塔卡
        currencyMap.put("LAK", "98");//  老挝基普

    }


    /**
     * 提交付款信息到CBS
     *
     * 每刻数据转换成CBS数据
     *
     * @param water
     * @return 返回xml字符串
     */
    public static String toXmlStr(PayForWater water) throws Exception {
        ThreeAppaysavxLevel appaysavx = new ThreeAppaysavxLevel();

        appaysavx.setRecnum("1");
        appaysavx.setOprtyp("202");//默认202
        appaysavx.setBustyp("0");//默认0
        if (water.getCode() != null && water.getPayeeTargetBizCode() != null) {
            appaysavx.setRefnbr(water.getCode() + water.getPayeeTargetBizCode());
        }
        //appaysavx.setCltacc(water.getPayerBankAccount());
        appaysavx.setCltacc("4000027219200095989");//测试
        appaysavx.setTrsamt(water.getPaidAmount());
        appaysavx.setCcynbr(currencyMap.get(water.getAcceptCcy()));//币种映射

        appaysavx.setTrsuse(water.getFormSubTypeName());// 对应对私报销、申请单、对公支付单单据的备注。。。需要问清楚

        //appaysavx.setRevacc(water.getPayeeBankCardNO());
        appaysavx.setRevacc("4000023009027339382");//测试
        appaysavx.setRevbnk(water.getPayeeBankBranchName());
        //appaysavx.setRevnam(water.getPayeeName());
        appaysavx.setRevnam("蘖控绣采恍马钳疏野该痼赴挥傻炼圳晰挥傻（揉拗鸦）");//测试账号名
        appaysavx.setRevprv(water.getPayeeBankProvince());
        appaysavx.setRevcit(water.getPayeeBankLocation());
        appaysavx.setBnktyp(dataMap.get(water.getPayeeBankName()));// 收款银行类型     需要做判断。。。。
        appaysavx.setBrdnbr(water.getPayeeBankBranchNO());
        appaysavx.setOprmod("3");//默认3
        appaysavx.setPaytyp("2");//默认2
        if (water.getPayeeTarget() != null) {
            if (water.getPayeeTarget().trim().equals("PERSONAL")) {
                //1-  对私   2-  对公
                appaysavx.setCopflg("1");//payeeTarget映射 除了对私就是对公
            } else {
                appaysavx.setCopflg("2");
            }
        }
        appaysavx.setCtyflg("1");//默认1
        //appaysavx.setPayson("123");
        //appaysavx.setTrasty("123");
        //appaysavx.setOrnttn("123");
        //appaysavx.setGrdflg("123");
        //appaysavx.setItmnbr("123");
        //appaysavx.setPlnnbr("123");
        //appaysavx.setAmtex1("123");
        //appaysavx.setAmtex2("123");
        //appaysavx.setAmtex3("123");
        //appaysavx.setErpcm1("123");
        appaysavx.setErpcm2(water.getPayeeTargetBizCode());
        //appaysavx.setErpcm3("123");
        //appaysavx.setCnvnbr("123");
        //appaysavx.setTrscat("123");
        //appaysavx.setActrac("123");
        //appaysavx.setActpac("123");
        //appaysavx.setRevtyp("123");
        //appaysavx.setPkzflg("123");
        //appaysavx.setDccseq("123");
        //appaysavx.setGctflg("123");
        //appaysavx.setGpyson("123");
        //appaysavx.setGpybtm("123");
        //appaysavx.setGbkprm("123");
        //appaysavx.setGbrdnb("123");
        //appaysavx.setGtrsty("123");
        //appaysavx.setGorntn("123");
        //appaysavx.setGgrflg("123");
        //appaysavx.setGkzflg("123");
        //appaysavx.setGopflg("123");
        //appaysavx.setGrvtyp("123");
        //appaysavx.setFatpac("123");
        //appaysavx.setRevcat("123");
        //appaysavx.setPaycat("123");
        //appaysavx.setInsnbr("123");
        //appaysavx.setDbcflg("123");
        //appaysavx.setComacn("123");
        //appaysavx.setGdcflg("123");
        //appaysavx.setImpdat("123");


        TwoLevel two = new TwoLevel();
        two.setInfo(new ThreeInfoLevel("ERPAYSAV"));
        two.setAppaysavx(appaysavx);
        String gbk = JaxbUtil.convertToXml(two, "GBK");
        //调用工具类生成报文秘钥
        String miy = SdkUtil.GetCheckSumWithCRC32("12345", gbk);
        //使用工具把xml放在<![CDATA[放在这里]]>
        CDataAdapter adapter = new CDataAdapter();
        String marshal = adapter.marshal(gbk);

        OneLevel one = new OneLevel();
        one.setCheckcode(miy);//设置报文秘钥
        one.setData(marshal);

        return JaxbUtil.convertToXml(one, "GBK");
    }


    /**
     * 查询是否存在
     *
     * 每刻数据转换成CBS数据
     *
     * @param water
     * @return 返回xml字符串
     */
    public static String toXmlErpaybusStr(PayForWater water) throws Exception {
        ThreeErpaybusLevel erpaybusx = new ThreeErpaybusLevel();
        erpaybusx.setCltacc(water.getPayerBankAccount());//付方账号
        erpaybusx.setRefnbr(water.getCode()+water.getPayeeTargetBizCode());//客户参考号
        erpaybusx.setRevacc(water.getPayeeBankCardNO());//收款人账号
        erpaybusx.setTrsamt(water.getPaidAmount());//金额

        TwoLevel two = new TwoLevel();
        two.setInfo(new ThreeInfoLevel("ERPAYBUS"));
        two.setErpaybusx(erpaybusx);
        String gbk = JaxbUtil.convertToXml(two, "GBK");
        //调用工具类生成报文秘钥
        String miy = SdkUtil.GetCheckSumWithCRC32("12345", gbk);
        //使用工具把xml放在<![CDATA[放在这里]]>
        CDataAdapter adapter = new CDataAdapter();
        String marshal = adapter.marshal(gbk);

        OneLevel one = new OneLevel();
        one.setCheckcode(miy);//设置报文秘钥
        one.setData(marshal);
        //把最终的对象转换成xml返回
        return JaxbUtil.convertToXml(one, "GBK");
    }

    /**
     *  查询支付状态请求转XML字符串
     * 每刻数据转换成CBS数据
     *
     * @param erpaybusResponse
     * @param funnam  请求方法
     * @return
     * @throws Exception
     */
    public static String toXmlStr(CbserppgkResponse erpaybusResponse,String funnam) throws Exception {
        ThreeErpaystaxLevel erpaystaxLevel = new ThreeErpaystaxLevel();
        erpaystaxLevel.setBusnbr(erpaybusResponse.getErpaybusz().getBusnbr());//业务流水号
        erpaystaxLevel.setRefnbr(erpaybusResponse.getErpaybusz().getRefnbr());//客户参考业务号
        TwoCbserppgkLevel level = new TwoCbserppgkLevel();
        level.getErpaystax().add(erpaystaxLevel);

        level.setInfo(new ThreeInfoLevel(funnam));

        String gbk = JaxbUtil.convertToXml(level, "GBK");
        //调用工具类生成报文秘钥
        String miy = SdkUtil.GetCheckSumWithCRC32("12345", gbk);
        //使用工具把xml放在<![CDATA[放在这里]]>
        CDataAdapter adapter = new CDataAdapter();
        String marshal = adapter.marshal(gbk);

        OneLevel one = new OneLevel();
        one.setCheckcode(miy);//设置报文秘钥
        one.setData(marshal);

        return JaxbUtil.convertToXml(one, "GBK");
    }

    /**
     *  查询支付状态请求转XML字符串
     * 每刻数据转换成CBS数据
     *
     * @param middle
     * @param funnam  请求方法
     * @return
     * @throws Exception
     */
    public static String toXmlStr(Middle middle, String funnam) throws Exception {
        ThreeErpaystaxLevel erpaystaxLevel = new ThreeErpaystaxLevel();
        erpaystaxLevel.setBusnbr(middle.getBusnbr());//业务流水号
        erpaystaxLevel.setRefnbr(middle.getRefnbr());//客户参考业务号
        TwoCbserppgkLevel level = new TwoCbserppgkLevel();
        level.getErpaystax().add(erpaystaxLevel);

        level.setInfo(new ThreeInfoLevel(funnam));

        String gbk = JaxbUtil.convertToXml(level, "GBK");
        //调用工具类生成报文秘钥
        String miy = SdkUtil.GetCheckSumWithCRC32("12345", gbk);
        //使用工具把xml放在<![CDATA[放在这里]]>
        CDataAdapter adapter = new CDataAdapter();
        String marshal = adapter.marshal(gbk);

        OneLevel one = new OneLevel();
        one.setCheckcode(miy);//设置报文秘钥
        one.setData(marshal);

        return JaxbUtil.convertToXml(one, "GBK");
    }


    /**
     *  【批量查询支付状态】请求转XML字符串
     * 每刻数据转换成CBS数据
     *
     * @param middleList
     * @return
     * @throws Exception
     */
    public static String toXmlStr(List<Middle> middleList) throws Exception {
        TwoCbserppgkLevel level = new TwoCbserppgkLevel();
        for (Middle middle : middleList) {
            ThreeErpaystaxLevel erpaystaxLevel = new ThreeErpaystaxLevel();
            erpaystaxLevel.setBusnbr(middle.getBusnbr());//业务流水号
            erpaystaxLevel.setRefnbr(middle.getRefnbr());//客户参考业务号
            level.getErpaystax().add(erpaystaxLevel);
        }

        level.setInfo(new ThreeInfoLevel("ERPAYSTA"));

        String gbk = JaxbUtil.convertToXml(level, "GBK");
        //调用工具类生成报文秘钥
        String miy = SdkUtil.GetCheckSumWithCRC32("12345", gbk);
        //使用工具把xml放在<![CDATA[放在这里]]>
        CDataAdapter adapter = new CDataAdapter();
        String marshal = adapter.marshal(gbk);

        OneLevel one = new OneLevel();
        one.setCheckcode(miy);//设置报文秘钥
        one.setData(marshal);

        return JaxbUtil.convertToXml(one, "GBK");
    }


}
