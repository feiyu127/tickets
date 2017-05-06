package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(urlPatterns = "/getHeaders")
public class TestFilter1 implements Filter
{
    
    @Override
    public void init(FilterConfig filterConfig)
        throws ServletException
    {
        System.out.println("init filter");
        systemOutEnumeration(filterConfig.getServletContext().getAttributeNames());
        systemOutEnumeration(filterConfig.getInitParameterNames());
    }
    
    public <E> void systemOutEnumeration(Enumeration<E> enumA)
    {
        System.out.println("-------------------------");
        while (enumA.hasMoreElements())
        {
            E e = (E)enumA.nextElement();
            System.out.println(e);
            
        }
        System.out.println("-------------------------");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        System.out.println("aaaaaaaaaaaaaaaaa");
        chain.doFilter(request, response);
        
    }
    
    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub
        
    }
    
}
