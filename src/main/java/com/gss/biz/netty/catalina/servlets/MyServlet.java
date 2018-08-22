package com.gss.biz.netty.catalina.servlets;

import com.gss.biz.netty.catalina.http.Request;
import com.gss.biz.netty.catalina.http.Response;
import com.gss.biz.netty.catalina.http.Servlet;

/**
 * @ClassName MyServlet
 * @Description: TODO
 * @Author lsh
 * @Date 2018/8/21 20:47
 * @Version
 */
public class MyServlet extends Servlet {
    @Override
    public void doGet(Request requset, Response response) {
        String param = "name";
        String str = requset.getParameter(param);
        response.write(param + ":" + str,200);
        System.out.println("相应客户端");
    }

    @Override
    public void doPost(Request requset, Response response) {

    }
}
