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
 * 猫眼城市
 * 
 * @see
 * @author 	nanshouxiao
 * @date	2017-5-8 12:30:34
 * @version	V1.0.0
 */
public class MaoyanCity implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 城市id
     */
    private Integer id;
    
    /**
     * 城市名称
     */
    private String name;
    
    /**
     * 城市拼音
     */
    private String pinyin;
    
    /**
     * 上线时间
     */
    private Integer onlineTime;
    
    /**
     * 排序
     */
    private String rank;
    
    /**
     * 是否支持
     */
    private String open;
    
    /**
     * 获取城市id
     */
    public Integer getId(){
    	return this.id;
    }
    
    /**
     * 设置城市id
     */
    public void setId(Integer id){
    	this.id = id;
    }
    
    /**
     * 获取城市名称
     */
    public String getName(){
    	return this.name;
    }
    
    /**
     * 设置城市名称
     */
    public void setName(String name){
    	this.name = name;
    }
    
    /**
     * 获取城市拼音
     */
    public String getPinyin(){
    	return this.pinyin;
    }
    
    /**
     * 设置城市拼音
     */
    public void setPinyin(String pinyin){
    	this.pinyin = pinyin;
    }
    
    /**
     * 获取上线时间
     */
    public Integer getOnlineTime(){
    	return this.onlineTime;
    }
    
    /**
     * 设置上线时间
     */
    public void setOnlineTime(Integer onlineTime){
    	this.onlineTime = onlineTime;
    }
    
    /**
     * 获取排序
     */
    public String getRank(){
    	return this.rank;
    }
    
    /**
     * 设置排序
     */
    public void setRank(String rank){
    	this.rank = rank;
    }
    
    /**
     * 获取是否支持
     */
    public String getOpen(){
    	return this.open;
    }
    
    /**
     * 设置是否支持
     */
    public void setOpen(String open){
    	this.open = open;
    }
    
    
    @Override
    public String toString()
    {
        return new StringBuilder(super.toString()).append("[")
	      .append("id=").append(getId()).append(", ")
	      .append("name=").append(getName()).append(", ")
	      .append("pinyin=").append(getPinyin()).append(", ")
	      .append("onlineTime=").append(getOnlineTime()).append(", ")
	      .append("rank=").append(getRank()).append(", ")
	      .append("open=").append(getOpen())
	      .append("]").toString();
    }
}