package com.gss.biz.netty.chart.client;

import com.gss.biz.netty.chart.protocol.IMMessage;
import com.gss.biz.netty.chart.protocol.IMP;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @ClassName ClientHandler
 * @Description: 客户端处理器
 * @Author lsh
 * @Date 2018/8/26 16:29
 * @Version
 */
public class ClientHandler extends ChannelInboundHandlerAdapter{

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private ChannelHandlerContext ctx;
    private String nickName;

    public ClientHandler(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 收到消息后调用
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        IMMessage m = (IMMessage) msg;
        log.info("客户度收到的消息为:" + m);
    }

    /**
     * @Description: 启动客户端控制台
     * @Param
     * @Return
     * @author lsh
     * @date 2018/8/26 16:34
     */
    private void session() {
        new Thread() {
            @Override
            public void run() {
                log.info(nickName + "您好，请在控制台输入消息内容!");
                IMMessage message = null;
                Scanner scanner = new Scanner(System.in);
                do {
                    if (scanner.hasNext()) {
                        String input = scanner.nextLine();
                        if ("exit".equals(input)) {
                             message = new IMMessage(IMP.LOGOUT.getName(), System.currentTimeMillis(), nickName);
                        } else {
                            message = new IMMessage(IMP.CHAT.getName(), System.currentTimeMillis(), nickName, input);
                        }
                    }
                } while (sendMsg(message));
            }
        }.start();
    }

    /**
     * TCP建立成功后调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
        IMMessage message = new IMMessage(IMP.LOGIN.getName(), System.currentTimeMillis(), this.nickName);
        sendMsg(message);
        log.info("成功连接服务器，已执行登录操作!");
        session();
    }

    /**
     * 发送消息
     * @param message
     * @return
     */
    private boolean sendMsg(IMMessage message) {
        ctx.channel().writeAndFlush(message);
        log.info("已发送至聊天面板，请继续输入：");
        return message.getCmd().equals(IMP.LOGOUT) ? false : true;
    }

    /**
     * 异常时调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("与服务器断开连接：" + cause.getMessage());
        ctx.close();
    }
}
