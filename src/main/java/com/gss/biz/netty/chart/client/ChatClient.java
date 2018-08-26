package com.gss.biz.netty.chart.client;

import com.gss.biz.netty.chart.protocol.IMDecoder;
import com.gss.biz.netty.chart.protocol.IMEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName ChatClient
 * @Description: 客户端
 * @Author lsh
 * @Date 2018/8/26 14:27
 * @Version
 */
public class ChatClient {
    private ClientHandler clientHandler;
    /**
     * ip
     */
    private String host;
    /**
     * 端口
     */
    private int port;

    private String nickName;

    public ChatClient(String nickName) {
        this.clientHandler = new ClientHandler(nickName);
    }

    /**
     * 创建连接
     * @param host
     * @param port
     */
    public void connect(String host, int port) {
        this.host = host;
        this.port = port;
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(workGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new IMDecoder());
                        pipeline.addLast(new IMEncoder());
                        pipeline.addLast(clientHandler);
                    }
                });
        try {
            ChannelFuture f = b.connect(this.host, this.port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ChatClient("sam").connect("localhost", 8080);
    }
}
