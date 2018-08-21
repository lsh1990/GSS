package com.gss.biz.netty.catalina.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @ClassName Tomcat
 * @Description: 利用netty实现tomcat
 * @Author lsh
 * @Date 2018/8/21 8:09
 * @Version
 */
public class Tomcat {
        public void start(int port) {
            //boss线程
            NioEventLoopGroup bossGroup = new NioEventLoopGroup();
            //work线程
            NioEventLoopGroup workGroup = new NioEventLoopGroup();
            //启动引擎
            ServerBootstrap bootstrap = new ServerBootstrap();
//            bootstrap.group(bossGroup, workGroup).channel()

        }
}
