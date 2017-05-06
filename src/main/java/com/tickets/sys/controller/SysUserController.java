package com.tickets.sys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tickets.common.controller.BaseController;
import com.tickets.sys.bean.SysUser;
import com.tickets.sys.service.SysUserService;

@Controller
@RequestMapping("sysUser")
public class SysUserController extends BaseController<SysUser>
{
    
    @Resource
    private SysUserService sysUserService;
    
    @RequestMapping("getUser")
    @ResponseBody
    public SysUser getUser(Integer userId)
    {
        SysUser user = sysUserService.getEntityByKey(userId);
        return user;
    }
    @RequestMapping("getAll")
    @ResponseBody
    public String getAll()
    {
        List<SysUser> user = sysUserService.getAll();
        
        return user.toString();
    }
    
    @RequestMapping("validateUser")
    @ResponseBody
    public String validate(@Valid SysUser user, Errors errors){
    	
    	System.out.println(errors.hasErrors());
    	System.out.println(errors);
    	return "hello";
    }
}
