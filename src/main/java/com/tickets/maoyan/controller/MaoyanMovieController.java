/**
 * @单位名称：飞羽个人
 * 	Copyright (c) 2017 All Rights Reserved.
 * @系统名称：测试
 * @工程名称：
 * @文件名称: 
 * @类路径: 
 */
package com.tickets.maoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tickets.maoyan.bean.MaoyanMovie;
import com.tickets.common.controller.BaseController;

/**
 * 猫眼影片
 * 
 * @see
 * @author 	nanshouxiao
 * @date	2017-5-10 11:07:56
 * @version	V1.0.0
 */
@Controller
@RequestMapping("maoyanMovie")
public class MaoyanMovieController extends BaseController<MaoyanMovie>
{

}