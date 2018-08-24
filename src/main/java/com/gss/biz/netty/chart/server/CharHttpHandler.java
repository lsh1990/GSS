package com.gss.biz.netty.chart.server;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @ClassName CharHttpHandler
 * @Description: TODO
 * @Author lsh
 * @Date 2018/8/23 20:23
 * @Version
 */
public class CharHttpHandler  extends SimpleChannelInboundHandler<FullHttpRequest>{

    private URL baseURL = CharHttpHandler.class.getProtectionDomain().getCodeSource().getLocation();
    private final String webroot = "webroot";

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        //获取请求的url
        String uri = request.getUri();
        String page = uri.equals("/") ? "chat.html" : uri;
        RandomAccessFile file = new RandomAccessFile(getResource(page), "r");

        HttpResponse response = new DefaultHttpResponse(request.getProtocolVersion(), HttpResponseStatus.OK);
        String contextType = "text/html;";

        //判断文件类型
        if(uri.endsWith(".css")){
            contextType = "text/css;";
        }else if(uri.endsWith(".js")){
            contextType = "text/javascript;";
        }else if(uri.toLowerCase().matches("(jpg|png|gif)$")){
            String ext = uri.substring(uri.lastIndexOf("."));
            contextType = "image/" + ext;
        }
        response.headers().set(HttpHeaders.Names.CONTENT_TYPE, contextType + "charset=utf-8;");
        boolean keepAlive = HttpHeaders.isKeepAlive(request);

        if (keepAlive) {
            response.headers().set(HttpHeaders.Names.CONTENT_LENGTH, file.length());
            response.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        }
        ctx.write(response);

        ctx.write(new DefaultFileRegion(file.getChannel(), 0, file.length()));
//        ctx.write(new ChunkedNioFile(file.getChannel()));

        ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
        if (!keepAlive) {
            future.addListener(ChannelFutureListener.CLOSE);
        }

        file.close();
    }

     /**
     * @Description: 获取文件
     * @Param
     * @Return
     * @author lsh
     * @date 2018/8/23 20:58
     */
    private File getResource(String fileName) {
        String path = null;
        try {
             path = baseURL.toURI() + webroot + "/" + fileName;
            path = !path.contains("file:") ? path : path.substring(5).replace("//", "/");

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new File(path);
    }
}
