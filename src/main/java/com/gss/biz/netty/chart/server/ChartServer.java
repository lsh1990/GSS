package com.gss.biz.netty.chart.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName ChartServer
 * @Description: netty聊天室服务端
 * @Author lsh
 * @Date 2018/8/20 21:15
 * @Version
 */
public class ChartServer {

        private int port = 8080;

         /**
         * @Description: 启动
         * @Param
         * @Return
         * @author lsh
         * @date 2018/8/20 21:28
         */
        public void start() {
                //boss线程
                NioEventLoopGroup bossGroup = new NioEventLoopGroup();
                //worker线程
                NioEventLoopGroup workGroup = new NioEventLoopGroup();
                //启动引擎
                ServerBootstrap serverBootstrap = new ServerBootstrap();
                //主从模型
                serverBootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                        .option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                                //自定义业务
                        }
                });


        }
}
