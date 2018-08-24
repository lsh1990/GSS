package com.gss.biz.netty.catalina.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @ClassName Tomcat
 * @Description: 利用netty实现tomcat
 * @Author lsh
 * @Date 2018/8/21 8:09
 * @Version
 */
public class Tomcat {

        public static void main(String[] args) {
            new Tomcat().start(8080);
        }
        public void start(int port) {
            //boss线程
            NioEventLoopGroup bossGroup = new NioEventLoopGroup();
            //work线程
            NioEventLoopGroup workGroup = new NioEventLoopGroup();
            //启动引擎
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    //主线程处理类
                    .channel(NioServerSocketChannel.class)
                    //子线程处理类
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //无锁化串行编程
                            //业务逻辑，编码器
                            ch.pipeline().addLast(new HttpResponseEncoder());
                            //解码器
                            ch.pipeline().addLast(new HttpRequestDecoder());
                            //自定义业务
                            ch.pipeline().addLast(new TmocatHandler());
                        }
                    })
                    //配置信息
                    //主线程配置信息 非阻塞 128线程数量
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //子线程配置信息 长连接
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            try {
                //等待
                ChannelFuture sync = bootstrap.bind(port).sync();
                System.out.println("Tomcat已启动" + port);
                sync.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                bossGroup.shutdownGracefully();
                workGroup.shutdownGracefully();
            }
        }
}
