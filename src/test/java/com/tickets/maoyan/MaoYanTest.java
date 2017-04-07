package com.tickets.maoyan;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.util.HttpUtils;
import com.util.UrlConstant;

public class MaoYanTest
{
//    @Test
    public void testCity()
    {
        String string = HttpUtils.get(UrlConstant.MAOYAN_CITY_URL, "");
        System.out.println(string);
        JSONObject resultJson = (JSONObject)JSON.parse(string);
        JSONObject data = resultJson.getJSONObject("data");
        JSONObject cityMap = data.getJSONObject("CityMap");
        
        JSONArray cityChars = data.getJSONArray("CityChars");
        for(Object str : cityChars){
            
            System.out.println(str);
            System.out.println(cityMap.getJSONArray((String)str));
        }
    }
    
    @Test
    public void testCinemas(){
        String cinemas = HttpUtils.get(UrlConstant.MAOYAN_LOCAL_CINEMAS);
        JSONObject data = JSON.parseObject(cinemas).getJSONObject("data");
        for(String key : data.keySet()){
            System.out.println(key);
            System.out.println(data.getJSONArray(key));
        }
    }
    
    @Test
    public void testHotMovies(){
        String hotMovies = HttpUtils.post("http://m.maoyan.com/movie/list.json", "type=hot&offset=0&limit=100");
        System.out.println(hotMovies);
    }
}
