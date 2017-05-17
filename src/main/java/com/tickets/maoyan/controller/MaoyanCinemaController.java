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

import com.tickets.maoyan.bean.MaoyanCinema;
import com.tickets.common.controller.BaseController;

/**
 * 猫眼影院
 * 
 * @see
 * @author 	nanshouxiao
 * @date	2017-5-8 12:30:46
 * @version	V1.0.0
 */
@Controller
@RequestMapping("maoyanCinema")
public class MaoyanCinemaController extends BaseController<MaoyanCinema>
{

    @RequestMapping("cinemaList")
    public String getListPage(){
        return "maoyan/maoyan_cinema_list";
    }
}