package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/getHeaders")
public class GetHeaderServlet extends HttpServlet
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4927450632165336750L;
    @Override
    public void init()
        throws ServletException
    {
        System.out.println("初始化 getHeader Servlet");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        
       Cookie cookie = new Cookie("name", "feiyu127");
       Cookie cookie2 = new Cookie("age", "28");
       resp.addCookie(cookie);
       resp.addCookie(cookie2);
       
       Enumeration<String> headerNames = req.getHeaderNames();
       resp.setContentType("text/html;charset=UTF-8");
       PrintWriter pw = resp.getWriter();
       StringBuilder sbr = new StringBuilder("<!DOCTYPE html> \n");
       sbr.append("<html>\n");
       sbr.append("<head>");
       sbr.append("<meta charset=\"utf-8\">");
       sbr.append("<title>标题</title>");
       sbr.append("</head>");
       pw.print(sbr);
       pw.print("<body bgcolor=\"#f0f0f0\">\n" +
            "<h1 align=\"center\">" + "标题" + "</h1>\n" +
            "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
            "<tr bgcolor=\"#949494\">\n" +
            "<th>Header 名称</th><th>Header 值</th>\n"+
            "</tr>\n");
       while(headerNames.hasMoreElements()){
           String name = headerNames.nextElement();
           pw.print("<tr><td>" + name + "</td>\n");
           String paramValue = req.getHeader(name);
           pw.println("<td> " + paramValue + "</td></tr>\n");
       }
       pw.println("</table>\n</body></html>");
       pw.flush();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        this.doGet(req, resp);
    }
    @Override
    public void destroy()
    {
        System.out.println("销毁 getHeader Servlet");
    }
}
