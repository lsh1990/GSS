package com.gss.biz.netty.chart.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * @ClassName WebSocktHandler
 * @Description: TODO
 * @Author lsh
 * @Date 2018/8/23 22:24
 * @Version
 */
public class WebSocktHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        try {
            System.out.println(msg.text());
            System.out.println("1111111111111111111111");
        } catch (Exception e) {
            System.out.println("异常");
        }

    }

//    @Override
//    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        super.handlerAdded(ctx);
//    }
//
//    @Override
//    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//        super.handlerRemoved(ctx);
//    }
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
//    }
}
