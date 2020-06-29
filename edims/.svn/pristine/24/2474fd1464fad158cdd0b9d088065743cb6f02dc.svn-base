package com.bgi.docking.util.cbs;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 作者:Kangy
 * 日期:2019/9/16 9:25
 *
 * xml,javaBeen的相互装换 工具
 */
public class JaxbUtil {


    /**
     * 日志
     */
    private static final Log _logger = LogFactory.getLog (JaxbUtil.class);

    public static String convertToXml (Object obj)
    {
        return convertToXml (obj, "UTF-8");
    }

    /**
     * JavaBean转换成xml
     *
     * @param obj
     * @param encoding
     * @return
     */
    public static String convertToXml (Object obj, String encoding)
    {
        String result = null;
        try
        {
            JAXBContext context = JAXBContext.newInstance (obj.getClass ());
            Marshaller marshaller = context.createMarshaller ();
            //xml格式
            marshaller.setProperty (Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //设置编码表
            marshaller.setProperty (Marshaller.JAXB_ENCODING, encoding);
            //去掉生成xml的默认报文头
            //marshaller.setProperty(Marshaller.JAXB_FRAGMENT,true);
            //不进行转义字符的处理
            marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
                @Override
                public void escape(char[] chars, int start, int length, boolean b, Writer writer) throws IOException {
                    writer.write(chars,start,length);
                }
            });
            StringWriter writer = new StringWriter ();
            marshaller.marshal (obj, writer);
            result = writer.toString ();
        }
        catch (Exception ex)
        {
            _logger.error (ex.getMessage (), ex);
        }
        return result;



    }

    /**
     * xml转换成JavaBean
     *
     * @param xml
     * @param c
     * @return
     */
    @SuppressWarnings ("unchecked")
    public static <T> T converyToJavaBean (String xml, Class <T> c)
    {
        T t = null;
        try
        {
            JAXBContext context = JAXBContext.newInstance (c);
            Unmarshaller unmarshaller = context.createUnmarshaller ();
            t = (T) unmarshaller.unmarshal (new StringReader(xml));
        }
        catch (Exception ex)
        {
            _logger.error (ex.getMessage (), ex);
        }
        return t;
    }
}
