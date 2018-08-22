package com.gss.biz.netty.catalina.http;

/**
 * @ClassName Servler
 * @Description: TODO
 * @Author lsh
 * @Date 2018/8/21 20:32
 * @Version
 */
public abstract class Servlet {
    public abstract void doGet(Request requset, Response response);
    public abstract void doPost(Request requset, Response response);
}
