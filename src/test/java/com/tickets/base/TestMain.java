package com.tickets.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.tickets.util.HttpUtils2;
import com.tickets.util.JsonUtils;

public class TestMain
{
    public static void main(String[] args)
    {
        test1();
    }
    
    public static void test1()
    {
        String nuomiCityListUrl = "http://dianying.nuomi.com/common/city/citylist?hasLetter=false&isjson=true";
        String result = HttpUtils2.get(nuomiCityListUrl, "");
        Map<String, Object> resultList = (Map<String, Object>)JsonUtils.parseJSON2Map(result);
        System.out.println(resultList.keySet());
        Map<String, Object> temp1 = (Map<String, Object>)resultList.get("data");
        System.out.println(temp1.keySet());
        List<Map<String, Object>> list = (List<Map<String, Object>>)temp1.get("all");
        Map<Object, Map<String, Object>> cityMap = new HashMap<>(); 
        for(Map<String, Object> map : list){
            cityMap.put(map.get("name"), map);
        }
        System.out.println(list.size());
        System.out.println(cityMap.size());
    }
}
