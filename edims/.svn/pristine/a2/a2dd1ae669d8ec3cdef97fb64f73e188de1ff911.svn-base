package com.bgi.docking.util.cbs;

/**
 * 作者:Kangy
 * 日期:2019/9/16 9:28
 *
 * 解决保护数据问题的工具类
 */
public class CDataAdapter  {
    /**
     * 增加 <![CDATA[ ]]>  标签
     * @param v
     * @return
     * @throws Exception
     */
    public static String marshal (String v) throws Exception
    {
        return "<![CDATA[" + v + "]]>";
    }

    /**
     * 解析，去掉 <![CDATA[ ]]>  标签
     * @param v
     * @return
     * @throws Exception
     */
    public static String unmarshal (String v) throws Exception
    {
        if ("<![CDATA[]]>".equals (v))
        {
            return "";
        }
        String v1 = null;
        String v2 = null;
        String subStart = "<![CDATA[";
        int a = v.indexOf (subStart);
        if (a >= 0)
        {
            v1 = v.substring (subStart.length (), v.length ());
        }
        else
        {
            return v;
        }
        String subEnd = "]]>";
        int b = v1.indexOf (subEnd);
        if (b >= 0)
        {
            v2 = v1.substring (0, b);
        }
        return v2;
    }

}
