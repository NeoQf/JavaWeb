package io.github.neoqf.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        1）获取请求方式，“GET” —— String getMethod()
        2）❤获取虚拟目录，”/day14” —— String getContextPath()
        3）获取Servlet路径，“/demo1” —— String getServletPath()
        4）获取get方式的请求参数，”name=zhangsan“ —— String getQuery()
        5）❤获取请求URI，”/day14/demo1“ —— 
        - String getRequestURI()：/day14/demo1
        - StringBuffer getRequestURL()：http://localhost/day14/demo1

        6）获取协议及版本，”HTTP/1.1“ —— String getProtocal()

        7）获取客户机的IP地址，”“ —— String getRemoteAddr()
         */
        String method = request.getMethod();
        System.out.println(method);

        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        String queryString = request.getQueryString();
        System.out.println(queryString);

        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);

        String protocol = request.getProtocol();
        System.out.println(protocol);

        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);


    }
}
