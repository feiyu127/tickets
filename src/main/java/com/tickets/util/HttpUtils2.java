package com.tickets.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

public class HttpUtils2
{
    public static void main(String[] args)
    {
        String nuomiCityListUrl = "http://dianying.nuomi.com/common/city/citylist";
        
        get(nuomiCityListUrl, "hasLetter=false&isjson=true");
        // post("http://mobile.fengchaowy.cn/LoginActionN/loginN.do", "userName=xuejiao&password=123456&groupCode=sd");
    }
    
    public static String get(String url, String param)
    {
        String result = "";
        String realUrl = url + "?" + param;
        BufferedReader in = null;
        try
        {
            URL httpUrl = new URL(realUrl);
            URLConnection connection = httpUrl.openConnection();
            connection.addRequestProperty("Cache-Control", "max-age=0");
            connection.addRequestProperty("Host", "dianying.nuomi.com");
            connection.addRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            connection.addRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
            connection.addRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
            connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
            // 建立实际的连接
            connection.connect();
            String contentEncoding = connection.getHeaderField("Content-Encoding");
            System.out.println(contentEncoding);
            // 定义 BufferedReader输入流来读取URL的响应
            InputStream input = connection.getInputStream();
            if("gzip".equals(contentEncoding)){
                input  = new GZIPInputStream(input);
            }
            in = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = in.readLine()) != null)
            {
                result += line;
            }
            return result;
        }
        catch (Exception e)
        {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
        return result;
    }
    
    public static void post(String url, String param)
    {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try
        {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
            {
                result += line;
            }
            System.out.println(result);
        }
        catch (Exception e)
        {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
