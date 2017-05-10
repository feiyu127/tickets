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
 * 放映信息
 * 
 * @see
 * @author 	nanshouxiao
 * @date	2017-5-10 12:12:46
 * @version	V1.0.0
 */
public class MaoyanMovieShow implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 放映id
     */
    private Integer showId;
    
    /**
     * 影片id
     */
    private Integer movieId;
    
    /**
     * 
     */
    private Integer cinemaId;
    
    /**
     * 放映日期
     */
    private String showDate;
    
    /**
     * 放映日期
     */
    private String dt;
    
    /**
     * 开始时间
     */
    private String tm;
    
    /**
     * 结束时间
     */
    private String end;
    
    /**
     * 
     */
    private Integer preferential;
    
    /**
     * 是否出售
     */
    private Integer sell;
    
    /**
     * 
     */
    private String tp;
    
    /**
     * 语言
     */
    private String lang;
    
    /**
     * 
     */
    private Integer embed;
    
    /**
     * 
     */
    private String grayDesc;
    
    /**
     * 
     */
    private Integer seatStatus;
    
    /**
     * 
     */
    private Integer isMorrow;
    
    /**
     * 
     */
    private String th;
    
    /**
     * 
     */
    private String sellPrStr;
    
    /**
     * 
     */
    private String prStr;
    
    /**
     * 获取放映id
     */
    public Integer getShowId(){
    	return this.showId;
    }
    
    /**
     * 设置放映id
     */
    public void setShowId(Integer showId){
    	this.showId = showId;
    }
    
    /**
     * 获取影片id
     */
    public Integer getMovieId(){
    	return this.movieId;
    }
    
    /**
     * 设置影片id
     */
    public void setMovieId(Integer movieId){
    	this.movieId = movieId;
    }
    
    /**
     * 获取
     */
    public Integer getCinemaId(){
    	return this.cinemaId;
    }
    
    /**
     * 设置
     */
    public void setCinemaId(Integer cinemaId){
    	this.cinemaId = cinemaId;
    }
    
    /**
     * 获取放映日期
     */
    public String getShowDate(){
    	return this.showDate;
    }
    
    /**
     * 设置放映日期
     */
    public void setShowDate(String showDate){
    	this.showDate = showDate;
    }
    
    /**
     * 获取放映日期
     */
    public String getDt(){
    	return this.dt;
    }
    
    /**
     * 设置放映日期
     */
    public void setDt(String dt){
    	this.dt = dt;
    }
    
    /**
     * 获取开始时间
     */
    public String getTm(){
    	return this.tm;
    }
    
    /**
     * 设置开始时间
     */
    public void setTm(String tm){
    	this.tm = tm;
    }
    
    /**
     * 获取结束时间
     */
    public String getEnd(){
    	return this.end;
    }
    
    /**
     * 设置结束时间
     */
    public void setEnd(String end){
    	this.end = end;
    }
    
    /**
     * 获取
     */
    public Integer getPreferential(){
    	return this.preferential;
    }
    
    /**
     * 设置
     */
    public void setPreferential(Integer preferential){
    	this.preferential = preferential;
    }
    
    /**
     * 获取是否出售
     */
    public Integer getSell(){
    	return this.sell;
    }
    
    /**
     * 设置是否出售
     */
    public void setSell(Integer sell){
    	this.sell = sell;
    }
    
    /**
     * 获取
     */
    public String getTp(){
    	return this.tp;
    }
    
    /**
     * 设置
     */
    public void setTp(String tp){
    	this.tp = tp;
    }
    
    /**
     * 获取语言
     */
    public String getLang(){
    	return this.lang;
    }
    
    /**
     * 设置语言
     */
    public void setLang(String lang){
    	this.lang = lang;
    }
    
    /**
     * 获取
     */
    public Integer getEmbed(){
    	return this.embed;
    }
    
    /**
     * 设置
     */
    public void setEmbed(Integer embed){
    	this.embed = embed;
    }
    
    /**
     * 获取
     */
    public String getGrayDesc(){
    	return this.grayDesc;
    }
    
    /**
     * 设置
     */
    public void setGrayDesc(String grayDesc){
    	this.grayDesc = grayDesc;
    }
    
    /**
     * 获取
     */
    public Integer getSeatStatus(){
    	return this.seatStatus;
    }
    
    /**
     * 设置
     */
    public void setSeatStatus(Integer seatStatus){
    	this.seatStatus = seatStatus;
    }
    
    /**
     * 获取
     */
    public Integer getIsMorrow(){
    	return this.isMorrow;
    }
    
    /**
     * 设置
     */
    public void setIsMorrow(Integer isMorrow){
    	this.isMorrow = isMorrow;
    }
    
    /**
     * 获取
     */
    public String getTh(){
    	return this.th;
    }
    
    /**
     * 设置
     */
    public void setTh(String th){
    	this.th = th;
    }
    
    /**
     * 获取
     */
    public String getSellPrStr(){
    	return this.sellPrStr;
    }
    
    /**
     * 设置
     */
    public void setSellPrStr(String sellPrStr){
    	this.sellPrStr = sellPrStr;
    }
    
    /**
     * 获取
     */
    public String getPrStr(){
    	return this.prStr;
    }
    
    /**
     * 设置
     */
    public void setPrStr(String prStr){
    	this.prStr = prStr;
    }
    
    
    @Override
    public String toString()
    {
        return new StringBuilder(super.toString()).append("[")
	      .append("showId=").append(getShowId()).append(", ")
	      .append("movieId=").append(getMovieId()).append(", ")
	      .append("cinemaId=").append(getCinemaId()).append(", ")
	      .append("showDate=").append(getShowDate()).append(", ")
	      .append("dt=").append(getDt()).append(", ")
	      .append("tm=").append(getTm()).append(", ")
	      .append("end=").append(getEnd()).append(", ")
	      .append("preferential=").append(getPreferential()).append(", ")
	      .append("sell=").append(getSell()).append(", ")
	      .append("tp=").append(getTp()).append(", ")
	      .append("lang=").append(getLang()).append(", ")
	      .append("embed=").append(getEmbed()).append(", ")
	      .append("grayDesc=").append(getGrayDesc()).append(", ")
	      .append("seatStatus=").append(getSeatStatus()).append(", ")
	      .append("isMorrow=").append(getIsMorrow()).append(", ")
	      .append("th=").append(getTh()).append(", ")
	      .append("sellPrStr=").append(getSellPrStr()).append(", ")
	      .append("prStr=").append(getPrStr())
	      .append("]").toString();
    }
}