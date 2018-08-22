package com.gss.biz.netty.catalina.netty.server;

import com.gss.biz.netty.catalina.http.Request;
import com.gss.biz.netty.catalina.http.Response;
import com.gss.biz.netty.catalina.servlets.MyServlet;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;


/**
 * @ClassName TmocatHandler
 * @Description: TODO
 * @Author lsh
 * @Date 2018/8/21 19:58
 * @Version
 */
public class TmocatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest r = (HttpRequest) msg;
            Request request = new Request(ctx,r);
            Response response = new Response(ctx,r);
            new MyServlet().doGet(request, response);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
