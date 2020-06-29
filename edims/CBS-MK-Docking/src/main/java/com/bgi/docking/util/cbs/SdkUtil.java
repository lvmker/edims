package com.bgi.docking.util.cbs;

import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;

/**
 * 作者:Kangy
 * 日期:2019/9/16 17:08
 *
 *
 * 生成报文秘钥的工具类
 */
public class SdkUtil {
    static String CRC32_PASSWORD ="CMBChina2009";
    static String CRC32_PREFIX ="Z";

    /**
     * 生成报文秘钥
     *
     * 生成规则: CRC32_PASSWORD + key + xmlData(需去掉回车换行符) 拼接成一个字符串,通过crc32校验规则生成字符串.
     *把该字符串转换成16进制,然后再大写,如果不足八位,则左补0,最后再加前缀CRC32_PREFIX
     * @param key   秘钥
     * @param xmlData   报文内容
     * @return
     */
    public static String GetCheckSumWithCRC32(String key, String xmlData) throws UnsupportedEncodingException {
        CRC32 crc32 = new CRC32();
        String str = CRC32_PASSWORD + key + xmlData.replaceAll("\n","").replaceAll("\r", "");
        crc32.update(str.getBytes("GBK"));  //如果不指定gbk，就会取平台默认字符集
        String result = Long.toHexString(crc32.getValue()).toUpperCase();
        String pattern="00000000";
        return CRC32_PREFIX + pattern.substring(0, pattern.length()-result.length()) + result ;
    }
}
