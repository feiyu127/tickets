package com.tickets.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tickets.sys.service.SysUserService;

public class LoginInterceptor implements HandlerInterceptor
{
    
    @Autowired
    private SysUserService sysUserService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception
    {
        String uri = request.getRequestURI();
        System.out.println(uri);
        HttpSession session = request.getSession();
        System.out.println("filter session Id:" + session.getId());
        
        // 验证登录用
        if (uri.indexOf("/login/") < 0 && session.getAttribute("userName") == null)
        {
//            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))
//            {
//                response.setHeader("sessionstatus", "timeout");// 在响应头设置session状态
//                response.getWriter().print("登录超时！"); // 打印一个返回值，没这一行，在tabs页中无法跳出（导航栏能跳出），具体原因不明
//            }else{
//                response.sendRedirect("/");
//            }
//            return true;
        }
        // 跨域用，表示接受哪个域过来的数据
        response.addHeader("Access-Control-Allow-Origin", "*");
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception
    {
        
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception
    {
        
    }
    
}
