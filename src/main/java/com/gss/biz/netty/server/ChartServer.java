package com.gss.biz.netty.server;

import io.netty.channel.nio.NioEventLoopGroup;

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
                NioEventLoopGroup bossGroup = new NioEventLoopGroup();
                NioEventLoopGroup workGroup = new NioEventLoopGroup();


        }
}
