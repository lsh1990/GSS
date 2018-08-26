package com.gss.biz.netty.chart.server;

import com.gss.biz.netty.chart.protocol.IMDecoder;
import com.gss.biz.netty.chart.protocol.IMEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

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
                serverBootstrap.group(bossGroup, workGroup)
                        .channel(NioServerSocketChannel.class)
                        .option(ChannelOption.SO_BACKLOG, 1024)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline pipeline = ch.pipeline();
                                //自定义业务
                                pipeline.addLast(new IMDecoder());
                                pipeline.addLast(new IMEncoder());
                                pipeline.addLast(new SocketHandler());
                                //====================http================
                                //解码和编码HTTP请求
                                pipeline.addLast(new HttpServerCodec());
                                //主要是将同一个http请求或响应的多个消息对象变成一个 fullHttpRequest完整的消息对象
                                pipeline.addLast(new HttpObjectAggregator(64 * 1024));
                                //处理文件流
                                pipeline.addLast(new ChunkedWriteHandler());
                                pipeline.addLast(new CharHttpHandler());

                                //====================WebSocket================
                                pipeline.addLast(new WebSocketServerProtocolHandler("/im"));
                                pipeline.addLast(new WebSocktHandler());

                        }
                });
                try {
                        ChannelFuture c =serverBootstrap.bind(port).sync();
                        System.out.println("服务端已启动，监听端口" + this.port);
                        c.channel().closeFuture().sync();
                } catch (InterruptedException e) {
                        e.printStackTrace();
                } finally {
                        workGroup.shutdownGracefully();
                        bossGroup.shutdownGracefully();
                }

        }
        public static void main(String[] args) {
            new ChartServer().start();
        }
}
