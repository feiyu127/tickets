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
 * 猫眼影片
 * 
 * @see
 * @author 	nanshouxiao
 * @date	2017-5-10 11:07:56
 * @version	V1.0.0
 */
public class MaoyanMovie implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 影片id
     */
    private Integer id;
    
    /**
     * 影片名称
     */
    private String nm;
    
    /**
     * 上映信息
     */
    private String rt;
    
    /**
     * 
     */
    private Integer dur;
    
    /**
     * 图片链接
     */
    private String img;
    
    /**
     * 影片播放信息
     */
    private String showInfo;
    
    /**
     * 
     */
    private Integer snum;
    
    /**
     * 导演
     */
    private String dir;
    
    /**
     * 
     */
    private String showDate;
    
    /**
     * 评分
     */
    private Object sc;
    
    /**
     * 想看人数
     */
    private Integer wish;
    
    /**
     * 是否是3D
     */
    private Integer is3d;
    
    /**
     * 
     */
    private Integer late;
    
    /**
     * 类型
     */
    private String cat;
    
    /**
     * 
     */
    private Integer sn;
    
    /**
     * 简介
     */
    private String scm;
    
    /**
     * 版本
     */
    private String ver;
    
    /**
     * 主演
     */
    private String star;
    
    /**
     * 
     */
    private String src;
    
    /**
     * 是否是imax
     */
    private Integer imax;
    
    /**
     * 
     */
    private String vd;
    
    /**
     * 是否预售
     */
    private Integer preSale;
    
    /**
     * 
     */
    private String time;
    
    /**
     * 
     */
    private Integer pn;
    
    /**
     * 
     */
    private Integer cnms;
    
    /**
     * 获取影片id
     */
    public Integer getId(){
    	return this.id;
    }
    
    /**
     * 设置影片id
     */
    public void setId(Integer id){
    	this.id = id;
    }
    
    /**
     * 获取影片名称
     */
    public String getNm(){
    	return this.nm;
    }
    
    /**
     * 设置影片名称
     */
    public void setNm(String nm){
    	this.nm = nm;
    }
    
    /**
     * 获取上映信息
     */
    public String getRt(){
    	return this.rt;
    }
    
    /**
     * 设置上映信息
     */
    public void setRt(String rt){
    	this.rt = rt;
    }
    
    /**
     * 获取
     */
    public Integer getDur(){
    	return this.dur;
    }
    
    /**
     * 设置
     */
    public void setDur(Integer dur){
    	this.dur = dur;
    }
    
    /**
     * 获取图片链接
     */
    public String getImg(){
    	return this.img;
    }
    
    /**
     * 设置图片链接
     */
    public void setImg(String img){
    	this.img = img;
    }
    
    /**
     * 获取影片播放信息
     */
    public String getShowInfo(){
    	return this.showInfo;
    }
    
    /**
     * 设置影片播放信息
     */
    public void setShowInfo(String showInfo){
    	this.showInfo = showInfo;
    }
    
    /**
     * 获取
     */
    public Integer getSnum(){
    	return this.snum;
    }
    
    /**
     * 设置
     */
    public void setSnum(Integer snum){
    	this.snum = snum;
    }
    
    /**
     * 获取导演
     */
    public String getDir(){
    	return this.dir;
    }
    
    /**
     * 设置导演
     */
    public void setDir(String dir){
    	this.dir = dir;
    }
    
    /**
     * 获取
     */
    public String getShowDate(){
    	return this.showDate;
    }
    
    /**
     * 设置
     */
    public void setShowDate(String showDate){
    	this.showDate = showDate;
    }
    
    /**
     * 获取评分
     */
    public Object getSc(){
    	return this.sc;
    }
    
    /**
     * 设置评分
     */
    public void setSc(Object sc){
    	this.sc = sc;
    }
    
    /**
     * 获取想看人数
     */
    public Integer getWish(){
    	return this.wish;
    }
    
    /**
     * 设置想看人数
     */
    public void setWish(Integer wish){
    	this.wish = wish;
    }
    
    /**
     * 获取是否是3D
     */
    public Integer getIs3d(){
    	return this.is3d;
    }
    
    /**
     * 设置是否是3D
     */
    public void setIs3d(Integer is3d){
    	this.is3d = is3d;
    }
    
    /**
     * 获取
     */
    public Integer getLate(){
    	return this.late;
    }
    
    /**
     * 设置
     */
    public void setLate(Integer late){
    	this.late = late;
    }
    
    /**
     * 获取类型
     */
    public String getCat(){
    	return this.cat;
    }
    
    /**
     * 设置类型
     */
    public void setCat(String cat){
    	this.cat = cat;
    }
    
    /**
     * 获取
     */
    public Integer getSn(){
    	return this.sn;
    }
    
    /**
     * 设置
     */
    public void setSn(Integer sn){
    	this.sn = sn;
    }
    
    /**
     * 获取简介
     */
    public String getScm(){
    	return this.scm;
    }
    
    /**
     * 设置简介
     */
    public void setScm(String scm){
    	this.scm = scm;
    }
    
    /**
     * 获取版本
     */
    public String getVer(){
    	return this.ver;
    }
    
    /**
     * 设置版本
     */
    public void setVer(String ver){
    	this.ver = ver;
    }
    
    /**
     * 获取主演
     */
    public String getStar(){
    	return this.star;
    }
    
    /**
     * 设置主演
     */
    public void setStar(String star){
    	this.star = star;
    }
    
    /**
     * 获取
     */
    public String getSrc(){
    	return this.src;
    }
    
    /**
     * 设置
     */
    public void setSrc(String src){
    	this.src = src;
    }
    
    /**
     * 获取是否是imax
     */
    public Integer getImax(){
    	return this.imax;
    }
    
    /**
     * 设置是否是imax
     */
    public void setImax(Integer imax){
    	this.imax = imax;
    }
    
    /**
     * 获取
     */
    public String getVd(){
    	return this.vd;
    }
    
    /**
     * 设置
     */
    public void setVd(String vd){
    	this.vd = vd;
    }
    
    /**
     * 获取是否预售
     */
    public Integer getPreSale(){
    	return this.preSale;
    }
    
    /**
     * 设置是否预售
     */
    public void setPreSale(Integer preSale){
    	this.preSale = preSale;
    }
    
    /**
     * 获取
     */
    public String getTime(){
    	return this.time;
    }
    
    /**
     * 设置
     */
    public void setTime(String time){
    	this.time = time;
    }
    
    /**
     * 获取
     */
    public Integer getPn(){
    	return this.pn;
    }
    
    /**
     * 设置
     */
    public void setPn(Integer pn){
    	this.pn = pn;
    }
    
    /**
     * 获取
     */
    public Integer getCnms(){
    	return this.cnms;
    }
    
    /**
     * 设置
     */
    public void setCnms(Integer cnms){
    	this.cnms = cnms;
    }
    
    
    @Override
    public String toString()
    {
        return new StringBuilder(super.toString()).append("[")
	      .append("id=").append(getId()).append(", ")
	      .append("nm=").append(getNm()).append(", ")
	      .append("rt=").append(getRt()).append(", ")
	      .append("dur=").append(getDur()).append(", ")
	      .append("img=").append(getImg()).append(", ")
	      .append("showInfo=").append(getShowInfo()).append(", ")
	      .append("snum=").append(getSnum()).append(", ")
	      .append("dir=").append(getDir()).append(", ")
	      .append("showDate=").append(getShowDate()).append(", ")
	      .append("sc=").append(getSc()).append(", ")
	      .append("wish=").append(getWish()).append(", ")
	      .append("is3d=").append(getIs3d()).append(", ")
	      .append("late=").append(getLate()).append(", ")
	      .append("cat=").append(getCat()).append(", ")
	      .append("sn=").append(getSn()).append(", ")
	      .append("scm=").append(getScm()).append(", ")
	      .append("ver=").append(getVer()).append(", ")
	      .append("star=").append(getStar()).append(", ")
	      .append("src=").append(getSrc()).append(", ")
	      .append("imax=").append(getImax()).append(", ")
	      .append("vd=").append(getVd()).append(", ")
	      .append("preSale=").append(getPreSale()).append(", ")
	      .append("time=").append(getTime()).append(", ")
	      .append("pn=").append(getPn()).append(", ")
	      .append("cnms=").append(getCnms())
	      .append("]").toString();
    }
}