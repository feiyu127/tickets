/*
 * 文 件 名:  MyHttpUtils.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  nanshouxiao
 * 修改时间:  2017年3月4日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.util;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * <一句话功能简述>
 * 
 * @author nanshouxiao
 * @version [版本号, 2017年3月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MyHttpUtils
{
    public static void main(String[] args)
    {
        doGet(null);
    }
    public static String doGet(String url)
    {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://dianying.nuomi.com/common/city/citylist?hasLetter=false&isjson=true");
        System.out.println("executing request " + httpget.getURI());
        
        try
        {
            
            // 客户端执行get请求 返回响应实体
            HttpResponse response = httpClient.execute(httpget);
            
            // 服务器响应状态行
            System.out.println(response.getStatusLine());
            
            Header[] heads = response.getAllHeaders();
            // 打印所有响应头
            for (Header h : heads)
            {
                System.out.println(h.getName() + ":" + h.getValue());
            }
            
            // 获取响应消息实体
            HttpEntity entity = response.getEntity();
            
            System.out.println("------------------------------------");
            
            if (entity != null)
            {
                
                // 响应内容
                System.out.println(EntityUtils.toString(entity));
                
                System.out.println("----------------------------------------");
                // 响应内容长度
                System.out.println("响应内容长度：" + entity.getContentLength());
            }
            
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            httpClient.getConnectionManager().shutdown();
        }
        return null;
    }
    
}
