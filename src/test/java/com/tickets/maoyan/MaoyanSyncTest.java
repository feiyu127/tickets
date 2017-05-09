package com.tickets.maoyan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tickets.maoyan.dao.MaoyanCinemaMapper;
import com.tickets.maoyan.dao.MaoyanCityMapper;
import com.util.HttpUtils;
import com.util.UrlConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-bean.xml" })
public class MaoyanSyncTest {

    @Autowired
    private MaoyanCityMapper maoyanCityMapper;
    
    @Autowired
    private MaoyanCinemaMapper maoyanCinemaMapper;

    @Test
    public void syncMaoyanCity() {
        String string = HttpUtils.get(UrlConstant.MAOYAN_CITY_URL, "");
        JSONObject resultJson = (JSONObject) JSON.parse(string);
        JSONObject data = resultJson.getJSONObject("data");
        JSONObject cityMap = data.getJSONObject("CityMap");
        JSONArray cityChars = data.getJSONArray("CityChars");
        List<JSONObject> entityMapList = new ArrayList<>();
        Set<Integer> idSet = new HashSet<>();
        cityMap.forEach((key, value) -> {
            cityMap.getJSONArray(key).forEach(cityObject -> {
                int cityId = ((JSONObject) cityObject).getIntValue("id");
                if (!idSet.contains(cityId)) {
                    idSet.add(cityId);
                    entityMapList.add((JSONObject) cityObject);
                }
            });
        });
        maoyanCityMapper.batchSaveEntity(entityMapList);
    }

    @Test
    public void testSyncCinemas() {
        // id=867
        String cinemas = HttpUtils.get(UrlConstant.MAOYAN_LOCAL_CINEMAS);
        JSONObject data = JSON.parseObject(cinemas).getJSONObject("data");
        System.out.println(cinemas);
        List<JSONObject> cinemaList = new ArrayList<>();
        data.forEach((key, value) -> {
            data.getJSONArray(key).forEach(cinema -> {
                cinemaList.add((JSONObject) cinema);
            });
        });
        System.out.println(cinemaList);
        maoyanCinemaMapper.batchSaveEntity(cinemaList);
    }
    
    @Test
    public void testSyncMovie(){
        String cinemaUrl = UrlConstant.getUrlByParam(UrlConstant.MAOYAN_CINEMAL_DETAIL, "881", "1197452");
        System.out.println(cinemaUrl);
        String data = HttpUtils.get(cinemaUrl);
        JSONObject result = JSON.parseObject(data).getJSONObject("data");
        // movies, cssLink, Dates, currentMovie, cinemaDetailModel, DateShow
        System.out.println(result.get("DateShow"));
    }
    public static void main(String[] args)
    {
//        new MaoyanSyncTest().testSyncMovie();
        initGongjijinData();
    }
    
    private static void initGongjijinData(){
        String url = "http://www.xazfgjj.gov.cn/xazxkdkxm.jsp?urltype=tree.TreeTempUrl&wbtreeid=1068";
        String param = "videoattformCURURI=2FE6F58EC2BC22E9B44BFF116B182B8C&videoattformKEYTYPES=12,12,12,12&videoattformCountNo=1999&videoattformNOWPAGE=3&videoattformPAGE=1999";
        String str = HttpUtils.post(url, param);
        Document parse = Jsoup.parse(str);
        Element body = parse.select("form[name=\"videoattform\"] table table tbody").get(0);
        Elements trHtml = body.select("tr");
        List<Map<String, String>> list = new ArrayList<>();
        for(Element e : trHtml){
            Map<String, String> map = new HashMap<>();
            map.put("projectName", e.select("td:eq(0)").get(0).text());
            map.put("detail", e.select("td:eq(1)").get(0).text());
            map.put("buildingType", e.select("td:eq(2)").get(0).text());
            map.put("company", e.select("td:eq(3)").get(0).text());
            list.add(map);
        }
        System.out.println(list.size());
//        System.out.println(list);
        
    }
}
