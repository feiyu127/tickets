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

import com.tickets.maoyan.bean.MaoyanMovieShow;
import com.tickets.common.controller.BaseController;

/**
 * 放映信息
 * 
 * @see
 * @author 	nanshouxiao
 * @date	2017-5-10 12:12:46
 * @version	V1.0.0
 */
@Controller
@RequestMapping("maoyanMovieShow")
public class MaoyanMovieShowController extends BaseController<MaoyanMovieShow>
{
    @RequestMapping("getPage")
    @Fa
    public void test(){
        
    }
}