/*
 * 文 件 名:  City.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  nanshouxiao
 * 修改时间:  2017年3月10日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.tickets.bean;

import java.io.Serializable;

/**
 * 城市
 * 
 * @author nanshouxiao
 * @version [版本号, 2017年3月10日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class City implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1850258848130756024L;

	private String cityName;

	private String cityPinYin;

	private String cityCode;

	/**
	 * 百度里的id
	 */
	private String nuomiId;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityPinYin() {
		return cityPinYin;
	}

	public void setCityPinYin(String cityPinYin) {
		this.cityPinYin = cityPinYin;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * 获取 nuomiId
	 * 
	 * @return 返回 nuomiId
	 */
	public String getNuomiId() {
		return nuomiId;
	}

	/**
	 * 设置 nuomiId
	 * 
	 * @param 对nuomiId进行赋值
	 */
	public void setNuomiId(String nuomiId) {
		this.nuomiId = nuomiId;
	}
}
