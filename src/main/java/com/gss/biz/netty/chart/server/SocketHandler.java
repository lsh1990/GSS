package com.gss.biz.netty.chart.server;

import com.gss.biz.netty.chart.processor.MsgProcessor;
import com.gss.biz.netty.chart.protocol.IMMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName SocketHandler
 * @Description: 自定义协议
 * @Author lsh
 * @Date 2018/8/26 10:55
 * @Version
 */
public class SocketHandler extends SimpleChannelInboundHandler<IMMessage>{

    protected final Logger log = LoggerFactory.getLogger(getClass());
    //消息处理器
    private MsgProcessor processor = new MsgProcessor();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, IMMessage msg) throws Exception {
        //利用重载
        processor.sendMsg(ctx.channel(), msg);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("服务端Handler创建...");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel client = ctx.channel();
        processor.logout(client);
        log.info("Socket Client:" + processor.getNickName(client) + "离开");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("Socket Client: 有客户端连接："+ processor.getAddress(ctx.channel()));
        super.channelActive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

}
