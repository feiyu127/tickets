/*
 * 文 件 名:  JsonUtils.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  nanshouxiao
 * 修改时间:  2017年3月4日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

/**
 * json的工具类
 * 
 * @author nanshouxiao
 * @version [版本号, 2017年3月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

/**
 * Json工具类
 * 
 * @author wanglei
 * @version [版本号, 2015年9月23日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class JsonUtils
{
    
    private static SerializeConfig mapping = new SerializeConfig();
    
    private static String dateFormat;
    static
    {
        dateFormat = "yyyy-MM-dd HH:mm:ss";
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
    }
    
    /**
     * 
     * <把任意对象转换为json字符串 >
     * 
     * @param obj 任意对象
     * @return json字符串
     */
    public static String object2json(Object obj)
    {
        if (obj == null)
        {
            return "{}";
        }
        return JSON.toJSONString(obj, mapping);
    }
    
    /**
     * 
     * <把bean对象转换为json字符串>
     * 
     * @param bean bean对象
     * @return json字符串
     */
    public static String bean2json(Object bean)
    {
        return object2json(bean);
    }
    
    /**
     * 
     * <把list对象转换为json字符串>
     * 
     * @param list list对象
     * @return json字符串
     */
    public static String list2json(List<?> list)
    {
        return object2json(list);
    }
    
    /**
     * 
     * <把数组对象转换为json字符串>
     * 
     * @param array 数组对象
     * @return json字符串
     */
    public static String array2json(Object[] array)
    {
        return object2json(array);
    }
    
    /**
     * 
     * <把数组对象转换为json字符串>
     * 
     * @param map map对象
     * @return json字符串
     */
    public static String map2json(Map<?, ?> map)
    {
        return object2json(map);
    }
    
    /**
     * 
     * <把set对象转换为json字符串>
     * 
     * @param set set对象
     * @return json字符串
     */
    public static String set2json(Set<?> set)
    {
        return object2json(set);
    }
    
    /**
     * 
     * <把String对象转换为json字符串>
     * 
     * @param s String对象
     * @return json字符串
     */
    public static String string2json(String s)
    {
        if (null == s)
        {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            switch (ch)
            {
                case '"':
                    sb.append("\\\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                default:
                    if (ch >= '\u0000' && ch <= '\u001F')
                    {
                        String ss = Integer.toHexString(ch);
                        sb.append("\\u");
                        for (int k = 0; k < 4 - ss.length(); k++)
                        {
                            sb.append('0');
                        }
                        sb.append(ss.toUpperCase());
                    }
                    else
                    {
                        sb.append(ch);
                    }
            }
        }
        return sb.toString();
    }
    
    public static List<Map<String, Object>> parseJSON2List(String jsonStr)
    {
        JSONArray jsonArr = JSONArray.parseArray(jsonStr);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Iterator<Object> it = jsonArr.iterator();
        while (it.hasNext())
        {
            JSONObject json2 = JSONObject.parseObject(JSON.toJSONString(it.next(), mapping));
            list.add(parseJSON2Map(json2.toString()));
        }
        return list;
    }
    
    public static Map<String, Object> parseJSON2Map(String jsonStr)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        // 最外层解析
        JSONObject json = JSONObject.parseObject(jsonStr);
        for (Object k : json.keySet())
        {
            Object v = json.get(k);
            // 如果内层还是数组的话，继续解析
            if (v instanceof JSONArray)
            {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator<Object> it = ((JSONArray)v).iterator();
                while (it.hasNext())
                {
                    JSONObject json2 = JSONObject.parseObject(JSON.toJSONString(it.next(), mapping));
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            }
            else
            {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
    
    public static List<Map<String, Object>> getListByUrl(String url)
    {
        try
        {
            // 通过HTTP获取JSON数据
            InputStream in = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line);
            }
            return parseJSON2List(sb.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] a)
    {
    }
}