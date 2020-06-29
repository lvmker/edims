package com.bgi.docking.util;

import com.bgi.docking.util.mk.SslUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

/**
 * 本工具类主要用于发送向服务器发送http服务请求
 * author:zengfanxin
 * date:2017-11-22 20:17:18
 */
public class HttpClientUtil {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    /**
     * 发送http请求
     *
     * @param urlPath
     *            目的地址
     * @param method
     *            请求方法
     *@param contentType
     *            请求类型
     *@param encodeType
     *            编码类型
     *@param headers
     *            请求头参数
     * @param parameters
     *            请求Json结构参数，字符串类型。
     *                    String authParam="{\"appCode\":\"" + appCode + "\", \"secret\": \"" + secretKey + "\", \"timestamp\": \"" + timestamp + "\"}";
     * @return 远程响应结果
     * @throws Exception 异常
     */
    public static String sendRequest(String urlPath, String method, String contentType, String encodeType,Map<String, String> headers, String parameters) throws Exception{
        String result = "";
        BufferedReader reader = null;
        OutputStream outwritestream = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(120000);
            conn.setRequestProperty("Connection", "Keep-Alive");
            String codeType = StringUtils.isEmpty(encodeType)?"UTF-8":encodeType;
            //conn.setRequestProperty("Charset", codeType);
            if(!StringUtils.isEmpty(contentType)){
                // 设置文件类型:
                conn.setRequestProperty("Content-Type",contentType+";charset="+codeType);
                //conn.setRequestProperty("accept","*/*")此处为暴力方法设置接受所有类型，以此来防范返回415;
                //设置接收类型否则返回415错误
                conn.setRequestProperty("accept",contentType);
            }
            if(Optional.ofNullable(headers).isPresent()){
                headers.forEach(conn::setRequestProperty);
            }

            if(Optional.ofNullable(parameters).isPresent()){
                // 往服务器里面发送数据
                byte[] writebytes = parameters.getBytes();
                // 设置文件长度
                conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                outwritestream = conn.getOutputStream();
                outwritestream.write(parameters.getBytes(codeType));
                outwritestream.flush();
            }
            System.out.println("登陆：doJsonPost response code: "+conn.getResponseCode());
            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),codeType));
            }else{
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream(),codeType));
            }
            String s=null;
            while((s=reader.readLine()) != null){
                result = result+s;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (outwritestream != null) {
                try {
                    outwritestream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                conn.disconnect();
            }
        }
        return result;

    }

    /**
     * 发送https请求
     *
     * @param urlPath
     *            目的地址
     * @param method
     *            请求方法
     *@param contentType
     *            请求类型
     *@param encodeType
     *            编码类型
     *@param headers
     *            请求头参数
     * @param parameters
     *            请求Json结构参数，字符串类型。
     * @return 远程响应结果
     * @throws Exception 异常
     */
    public static String sendHttpsRequest(String urlPath, String method, String contentType, String encodeType,Map<String, String> headers, String parameters) throws Exception{
        String result = "";
        BufferedReader reader = null;
        OutputStream outwritestream = null;
        HttpsURLConnection conn = null;
        try {
            SslUtils.ignoreSsl();
            URL url = new URL(urlPath);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(120000);
            conn.setRequestProperty("Connection", "Keep-Alive");
            String codeType = StringUtils.isEmpty(encodeType)?"UTF-8":encodeType;
            //conn.setRequestProperty("Charset", codeType);
            if(!StringUtils.isEmpty(contentType)){
                // 设置文件类型:
                conn.setRequestProperty("Content-Type",contentType+";charset="+codeType);
                //conn.setRequestProperty("accept","*/*")此处为暴力方法设置接受所有类型，以此来防范返回415;
                //设置接收类型否则返回415错误
                conn.setRequestProperty("accept",contentType);
            }
            if(Optional.ofNullable(headers).isPresent()){
                headers.forEach(conn::setRequestProperty);
            }

            if(Optional.ofNullable(parameters).isPresent()){
                // 往服务器里面发送数据
                byte[] writebytes = parameters.getBytes();
                // 设置文件长度
                conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                outwritestream = conn.getOutputStream();
                outwritestream.write(parameters.getBytes(codeType));
                
                outwritestream.flush();
            }
            System.out.println("doJsonPost response code: "+conn.getResponseCode());
            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),codeType));
            }else{
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream(),codeType));
            }
            String s=null;
            while((s=reader.readLine()) != null){
                result = result+s;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (outwritestream != null) {
                try {
                    outwritestream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                conn.disconnect();
            }
        }
        return result;

    }


    /**
     * 发送HttpPost请求
     *      注意：CBS用的是GBK编码表
     * @param strURL
     *            服务地址
     * @param params
     *             请求参数
     * @return 返回GBK编码的xml字符串
     */
    public static String post(String strURL, String params) {
        BufferedReader reader = null;
        try {
            URL url = new URL(strURL);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            // connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "text/html"); // 设置发送数据的格式
            connection.connect();
            //一定要用BufferedReader 来接收响应， 使用字节来接收响应的方法是接收不到内容的
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "GBK"); // utf-8编码
            out.append(params);
            out.flush();
            out.close();
            // 读取响应
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
            String line;
            String res = "";
            while ((line = reader.readLine()) != null) {
                res += line;
            }
            reader.close();
            return res;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "error"; // 自定义错误信息
    }

}
