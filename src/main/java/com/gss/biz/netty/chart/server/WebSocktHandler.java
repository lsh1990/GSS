package com.gss.biz.netty.chart.server;

import com.gss.biz.netty.chart.processor.MsgProcessor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName WebSocktHandler
 * @Description: TODO
 * @Author lsh
 * @Date 2018/8/23 22:24
 * @Version
 */
public class WebSocktHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{

    protected final Logger log = LoggerFactory.getLogger(getClass());
    private MsgProcessor processor = new MsgProcessor();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        try {
            processor.sendMsg(ctx.channel(), msg.text());
            System.out.println("1111111111111111111111");
        } catch (Exception e) {
            System.out.println("异常");
        }
    }

    /**
     * (2):进入
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel client = ctx.channel();
        String address = processor.getAddress(client);
        log.info("WebSocket Client:" + address + "加入");
    }

    /**
     * 离开
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception { // (3)
        Channel client = ctx.channel();
        processor.logout(client);
        log.info("WebSocket Client:" + processor.getNickName(client) + "离开");
    }

    /**
     * 上线
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception { // (5)
        Channel client = ctx.channel();
        String addr = processor.getAddress(client);
        log.info("WebSocket Client:" + addr + "上线");
    }

    /**
     * 掉线
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
        Channel client = ctx.channel();
        String addr = processor.getAddress(client);
        log.info("WebSocket Client:" + addr + "掉线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        Channel client = ctx.channel();
        String addr = processor.getAddress(client);
        log.info("WebSocket Client:" + addr + "异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
