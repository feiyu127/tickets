/**
 * @单位名称：科大国创—电信资源事业部
 *            USTC Sinovate Software Co.,Ltd.
 * 		      Copyright (c) 2013 All Rights Reserved.
 * @系统名称：NGRMS—下一代网络资源管理系统
 * @工程名称：cptlifts.platformcore
 * @文件名称: BaseController.java
 * @类路径: com.sinovate.ngrms.cptlifts.platformcore.web
 */

package com.tickets.common.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @see		
 * @author  sun.peiwen@ustcinfo.com
 * @date	2013-3-11 下午10:23:02
 * @version	 
 * @desc    TODO
 */
public abstract class BaseController {

protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	public final static String EXCEPTION_MESSAGE = "EXCEPTION_MESSAGE";


	
	@InitBinder//必须有一个参数WebDataBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), false));
	}
}

