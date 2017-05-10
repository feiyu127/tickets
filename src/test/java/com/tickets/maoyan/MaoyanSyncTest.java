package com.tickets.maoyan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tickets.maoyan.bean.MaoyanCinema;
import com.tickets.maoyan.dao.MaoyanCinemaMapper;
import com.tickets.maoyan.dao.MaoyanCityMapper;
import com.tickets.maoyan.dao.MaoyanMovieMapper;
import com.tickets.maoyan.dao.MaoyanMovieShowMapper;
import com.util.HttpUtils;
import com.util.UrlConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-bean.xml"})
public class MaoyanSyncTest
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MaoyanCityMapper maoyanCityMapper;
    
    @Autowired
    private MaoyanCinemaMapper maoyanCinemaMapper;
    
    @Autowired
    private MaoyanMovieMapper maoyanMovieMapper;
    
    @Autowired
    private MaoyanMovieShowMapper maoyanMovieShowMapper;
    
    @Test
    public void syncMaoyanCity()
    {
        String string = HttpUtils.get(UrlConstant.MAOYAN_CITY_URL, "");
        JSONObject resultJson = (JSONObject)JSON.parse(string);
        JSONObject data = resultJson.getJSONObject("data");
        JSONObject cityMap = data.getJSONObject("CityMap");
        JSONArray cityChars = data.getJSONArray("CityChars");
        List<JSONObject> entityMapList = new ArrayList<>();
        Set<Integer> idSet = new HashSet<>();
        cityMap.forEach((key, value) -> {
            cityMap.getJSONArray(key).forEach(cityObject -> {
                int cityId = ((JSONObject)cityObject).getIntValue("id");
                if (!idSet.contains(cityId))
                {
                    idSet.add(cityId);
                    entityMapList.add((JSONObject)cityObject);
                }
            });
        });
        maoyanCityMapper.batchSaveEntity(entityMapList);
    }
    
    @Test
    public void testSyncCinemas()
    {
        // id=867
        String cinemas = HttpUtils.get(UrlConstant.MAOYAN_LOCAL_CINEMAS);
        JSONObject data = JSON.parseObject(cinemas).getJSONObject("data");
        System.out.println(cinemas);
        List<JSONObject> cinemaList = new ArrayList<>();
        data.forEach((key, value) -> {
            data.getJSONArray(key).forEach(cinema -> {
                cinemaList.add((JSONObject)cinema);
            });
        });
        System.out.println(cinemaList);
        maoyanCinemaMapper.batchSaveEntity(cinemaList);
    }
    
    @Test
    public void testSyncMovie()
    {
        String data = HttpUtils.get(UrlConstant.MAOYAN_HOT_MOVIE);
        JSONArray result = JSON.parseObject(data).getJSONObject("data").getJSONArray("movies");
        result.forEach(entity -> {
            JSONObject a = (JSONObject)entity;
            a.put("is3d", a.get("3d"));
        });
        maoyanMovieMapper.batchSaveEntity(result);
    }
    
    @Test
    public void testSyncMovieShow(){
        for(int i = 0; i < 10; i++){
            List<MaoyanCinema> allCinemaList = maoyanCinemaMapper.getAll();
            System.out.println(allCinemaList.size());
        }
//        allCinemaList.forEach(cinema -> {
//            System.out.println(cinema);
////            testSyncCinemaShow(String.valueOf(cinema.getId()));
//        });
    }
    private void testSyncCinemaShow(String cinemaId){
        int sleepTime = 5000;
        String cinemaUrl = UrlConstant.getUrlByParam(UrlConstant.MAOYAN_CINEMAL_DETAIL, cinemaId);
        String data = HttpUtils.get(cinemaUrl);
        System.out.println("cinema:" + data);
        try
        {
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        JSONArray movies = JSON.parseObject(data).getJSONObject("data").getJSONArray("movies");
        movies.stream().forEach(movie -> {
            try
            {
                logger.info("添加影院id为"+cinemaId+"，影片为[" + ((JSONObject)movie).getString("nm") + "]的数据");
                Thread.sleep(sleepTime);
                String movieId = ((JSONObject)movie).getString("id");
                this.sysnCinemaMovieShow(cinemaId, movieId);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });
        // movies, cssLink, Dates, currentMovie, cinemaDetailModel, DateShow
        
    }
    
    private void sysnCinemaMovieShow(String cinemaId, String movieId)
    {
        String cinemaMovieUrl = UrlConstant.getUrlByParam(UrlConstant.MAOYAN_CINEMAL_DETAIL, cinemaId, movieId);
        String data = HttpUtils.get(cinemaMovieUrl);
        JSONObject dateShows = JSON.parseObject(data).getJSONObject("data").getJSONObject("DateShow");
        List<JSONObject> showInfos = new ArrayList<>();
        dateShows.forEach((key, value) -> {
            dateShows.getJSONArray(key).stream().parallel().forEach(movie -> {
                ((JSONObject)movie).put("cinemaId", cinemaId);
                ((JSONObject)movie).put("movieId", movieId);
                showInfos.add(((JSONObject)movie));
            });
        });
        if(showInfos.size() > 0){
            maoyanMovieShowMapper.batchSaveEntity(showInfos);
        }
    }
    
    public static void main(String[] args)
    {
        new MaoyanSyncTest().testSyncMovieShow();
    }
    
}
