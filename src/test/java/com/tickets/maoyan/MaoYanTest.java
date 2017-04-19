package com.tickets.maoyan;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.util.HttpUtils;
import com.util.UrlConstant;

public class MaoYanTest
{
    @Test
    public void testCity()
    {
        // id=42 西安
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
        // id=867
        String cinemas = HttpUtils.get(UrlConstant.MAOYAN_LOCAL_CINEMAS);
        JSONObject data = JSON.parseObject(cinemas).getJSONObject("data");
        for(String key : data.keySet()){
            System.out.println(key);
            System.out.println(data.getJSONArray(key));
        }
    }
    
    @Test
    public void testHotMovies(){
        // id = 246969
        String hotMovies = HttpUtils.get("http://m.maoyan.com/movie/list.json", "type=hot&offset=0&limit=100");
        System.out.println(hotMovies);
    }
    
    @Test
    public void testMovieCommit(){
        String reqUrl = UrlConstant.MAOYAN_MOVIE_COMMENT.replace("{movieId}", "246969");
        String commits = HttpUtils.get(reqUrl);
        System.out.println(commits);
    }
    
    @Test
    public void TestCinemaInfo(){
        String reqUrl = UrlConstant.MAOYAN_CINEMAL_DETAIL.replace("{cinemaId}", "867").replace("{movieId}", "246969");
        String commits = HttpUtils.get(reqUrl);
        System.out.println(commits);
    }
    
    @Test
    public void TestSeat(){
        String reqUrl = UrlConstant.MAOYAN_SEAT_INFO.replace("{showId}", "149068").replace("{showDate}", "20170411");
        System.out.println(reqUrl);
        String commits = HttpUtils.get(reqUrl);
        System.out.println(commits);
    }
}
