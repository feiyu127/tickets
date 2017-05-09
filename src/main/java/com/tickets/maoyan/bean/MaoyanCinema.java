/**
 * @单位名称：飞羽个人
 * 	Copyright (c) 2017 All Rights Reserved.
 * @系统名称：测试
 * @工程名称：
 * @文件名称: 
 * @类路径: 
 */
package com.tickets.maoyan.bean;

import java.io.Serializable;

/**
 * 猫眼影院
 * 
 * @see
 * @author 	nanshouxiao
 * @date	2017-5-8 12:30:46
 * @version	V1.0.0
 */
public class MaoyanCinema implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 影院id
     */
    private Integer id;
    
    /**
     * 影院名称
     */
    private String nm;
    
    /**
     * 影院地址
     */
    private String addr;
    
    /**
     * 维度
     */
    private Double lat;
    
    /**
     * 经度
     */
    private Double lng;
    
    /**
     * 区域
     */
    private String area;
    
    /**
     * 
     */
    private Integer deal;
    
    /**
     * 
     */
    private Integer distance;
    
    /**
     * 
     */
    private Integer sell;
    
    /**
     * 
     */
    private Double sellPrice;
    
    /**
     * 
     */
    private Integer imax;
    
    /**
     * 
     */
    private Integer sellmin;
    
    /**
     * 
     */
    private Double dealPrice;
    
    /**
     * 
     */
    private Integer follow;
    
    /**
     * 
     */
    private String dis;
    
    /**
     * 
     */
    private Double preferential;
    
    /**
     * 
     */
    private String ct;
    
    /**
     * 
     */
    private Double referencePrice;
    
    /**
     * 
     */
    private Integer showCount;
    
    /**
     * 影城名称
     */
    private String brd;
    
    /**
     * 影城id
     */
    private Integer brdId;
    
    /**
     * 
     */
    private Integer poiId;
    
    /**
     * 获取影院id
     */
    public Integer getId(){
    	return this.id;
    }
    
    /**
     * 设置影院id
     */
    public void setId(Integer id){
    	this.id = id;
    }
    
    /**
     * 获取影院名称
     */
    public String getNm(){
    	return this.nm;
    }
    
    /**
     * 设置影院名称
     */
    public void setNm(String nm){
    	this.nm = nm;
    }
    
    /**
     * 获取影院地址
     */
    public String getAddr(){
    	return this.addr;
    }
    
    /**
     * 设置影院地址
     */
    public void setAddr(String addr){
    	this.addr = addr;
    }
    
    /**
     * 获取维度
     */
    public Double getLat(){
    	return this.lat;
    }
    
    /**
     * 设置维度
     */
    public void setLat(Double lat){
    	this.lat = lat;
    }
    
    /**
     * 获取经度
     */
    public Double getLng(){
    	return this.lng;
    }
    
    /**
     * 设置经度
     */
    public void setLng(Double lng){
    	this.lng = lng;
    }
    
    /**
     * 获取区域
     */
    public String getArea(){
    	return this.area;
    }
    
    /**
     * 设置区域
     */
    public void setArea(String area){
    	this.area = area;
    }
    
    /**
     * 获取
     */
    public Integer getDeal(){
    	return this.deal;
    }
    
    /**
     * 设置
     */
    public void setDeal(Integer deal){
    	this.deal = deal;
    }
    
    /**
     * 获取
     */
    public Integer getDistance(){
    	return this.distance;
    }
    
    /**
     * 设置
     */
    public void setDistance(Integer distance){
    	this.distance = distance;
    }
    
    /**
     * 获取
     */
    public Integer getSell(){
    	return this.sell;
    }
    
    /**
     * 设置
     */
    public void setSell(Integer sell){
    	this.sell = sell;
    }
    
    /**
     * 获取
     */
    public Double getSellPrice(){
    	return this.sellPrice;
    }
    
    /**
     * 设置
     */
    public void setSellPrice(Double sellPrice){
    	this.sellPrice = sellPrice;
    }
    
    /**
     * 获取
     */
    public Integer getImax(){
    	return this.imax;
    }
    
    /**
     * 设置
     */
    public void setImax(Integer imax){
    	this.imax = imax;
    }
    
    /**
     * 获取
     */
    public Integer getSellmin(){
    	return this.sellmin;
    }
    
    /**
     * 设置
     */
    public void setSellmin(Integer sellmin){
    	this.sellmin = sellmin;
    }
    
    /**
     * 获取
     */
    public Double getDealPrice(){
    	return this.dealPrice;
    }
    
    /**
     * 设置
     */
    public void setDealPrice(Double dealPrice){
    	this.dealPrice = dealPrice;
    }
    
    /**
     * 获取
     */
    public Integer getFollow(){
    	return this.follow;
    }
    
    /**
     * 设置
     */
    public void setFollow(Integer follow){
    	this.follow = follow;
    }
    
    /**
     * 获取
     */
    public String getDis(){
    	return this.dis;
    }
    
    /**
     * 设置
     */
    public void setDis(String dis){
    	this.dis = dis;
    }
    
    /**
     * 获取
     */
    public Double getPreferential(){
    	return this.preferential;
    }
    
    /**
     * 设置
     */
    public void setPreferential(Double preferential){
    	this.preferential = preferential;
    }
    
    /**
     * 获取
     */
    public String getCt(){
    	return this.ct;
    }
    
    /**
     * 设置
     */
    public void setCt(String ct){
    	this.ct = ct;
    }
    
    /**
     * 获取
     */
    public Double getReferencePrice(){
    	return this.referencePrice;
    }
    
    /**
     * 设置
     */
    public void setReferencePrice(Double referencePrice){
    	this.referencePrice = referencePrice;
    }
    
    /**
     * 获取
     */
    public Integer getShowCount(){
    	return this.showCount;
    }
    
    /**
     * 设置
     */
    public void setShowCount(Integer showCount){
    	this.showCount = showCount;
    }
    
    /**
     * 获取影城名称
     */
    public String getBrd(){
    	return this.brd;
    }
    
    /**
     * 设置影城名称
     */
    public void setBrd(String brd){
    	this.brd = brd;
    }
    
    /**
     * 获取影城id
     */
    public Integer getBrdId(){
    	return this.brdId;
    }
    
    /**
     * 设置影城id
     */
    public void setBrdId(Integer brdId){
    	this.brdId = brdId;
    }
    
    /**
     * 获取
     */
    public Integer getPoiId(){
    	return this.poiId;
    }
    
    /**
     * 设置
     */
    public void setPoiId(Integer poiId){
    	this.poiId = poiId;
    }
    
    
    @Override
    public String toString()
    {
        return new StringBuilder(super.toString()).append("[")
	      .append("id=").append(getId()).append(", ")
	      .append("nm=").append(getNm()).append(", ")
	      .append("addr=").append(getAddr()).append(", ")
	      .append("lat=").append(getLat()).append(", ")
	      .append("lng=").append(getLng()).append(", ")
	      .append("area=").append(getArea()).append(", ")
	      .append("deal=").append(getDeal()).append(", ")
	      .append("distance=").append(getDistance()).append(", ")
	      .append("sell=").append(getSell()).append(", ")
	      .append("sellPrice=").append(getSellPrice()).append(", ")
	      .append("imax=").append(getImax()).append(", ")
	      .append("sellmin=").append(getSellmin()).append(", ")
	      .append("dealPrice=").append(getDealPrice()).append(", ")
	      .append("follow=").append(getFollow()).append(", ")
	      .append("dis=").append(getDis()).append(", ")
	      .append("preferential=").append(getPreferential()).append(", ")
	      .append("ct=").append(getCt()).append(", ")
	      .append("referencePrice=").append(getReferencePrice()).append(", ")
	      .append("showCount=").append(getShowCount()).append(", ")
	      .append("brd=").append(getBrd()).append(", ")
	      .append("brdId=").append(getBrdId()).append(", ")
	      .append("poiId=").append(getPoiId())
	      .append("]").toString();
    }
}