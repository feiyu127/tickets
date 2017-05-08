package com.tickets.maoyan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
