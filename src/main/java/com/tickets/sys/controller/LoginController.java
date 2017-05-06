package com.tickets.sys.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tickets.common.controller.BaseController;
import com.tickets.sys.bean.SysUser;
import com.tickets.sys.service.SysUserService;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController<String>
{
    
    @Resource
    private SysUserService sysUserService;
    
    @RequestMapping("login")
    public void getUser(SysUser user, HttpServletRequest req, HttpServletResponse resp)
    {
        SysUser existsUser = sysUserService.getUserByLoginName(user);
        
        if(existsUser != null && existsUser.getPassword().equals(user.getPassword())){
        	HttpSession session = req.getSession();
        	System.out.println("login session Id:" + session.getId());
        	session.setAttribute("userName", existsUser.getUserName());
        	System.out.println("login session attr" + session.getAttribute("userName"));
        	session.setAttribute("sysUser", existsUser);
        	try {
				resp.sendRedirect("/upload.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
        }else{
        	req.setAttribute("loginErrorMsg", "用户名或密码错误，请重新登录");
        	try {
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
        }
    }
}
