package com.gss.biz.netty.chart.processor;

import com.alibaba.fastjson.JSONObject;
import com.gss.biz.netty.chart.protocol.IMDecoder;
import com.gss.biz.netty.chart.protocol.IMEncoder;
import com.gss.biz.netty.chart.protocol.IMMessage;
import com.gss.biz.netty.chart.protocol.IMP;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ClassName MsgProcessor
 * @Description: 自定义协议内容逻辑处理
 * @Author lsh
 * @Date 2018/8/25 17:11
 * @Version
 */
public class MsgProcessor {

    //记录在线用户-全局。相当于spring的applaction
    private static ChannelGroup onlineUsers = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //定义属性
    private final AttributeKey<String> NICK_NAME = AttributeKey.valueOf("nickName");
    private final AttributeKey<String> IP_ADDR = AttributeKey.valueOf("ipAddr");
    private final AttributeKey<JSONObject> ATTRS = AttributeKey.valueOf("attrs");

    //自定义解码器
    private IMDecoder imDecoder = new IMDecoder();
    //自定义编码器
    private IMEncoder imEncoder = new IMEncoder();

    /**
     * 获取用户昵称
     * @param client
     * @return
     */
    public String getNickName(Channel client) {
        return client.attr(NICK_NAME).get();
    }

    /**
     * 获取用户远程IP地址
     * @param client
     * @return
     */
    public String getAddress(Channel client) {
        return client.remoteAddress().toString().replaceFirst("/", "");
    }

    /**
     * 获取扩展属性
     * @param client
     * @return
     */
    public JSONObject getAtrrs(Channel client) {
        return client.attr(ATTRS).get();
    }

    /**
     * 设置扩展属性
     * @param client
     * @param key
     * @param value
     */
    private void setAttrs(Channel client, String key, Object value) {
            JSONObject json = new JSONObject();
            json.put(key, value);
            client.attr(ATTRS).set(json);
    }

    /**
     * 登出通知
     * @param client
     */
    public void logout(Channel client) {
        if (getNickName(client) == null) {
            return;
        }
        for (Channel onlineUser : onlineUsers) {
            IMMessage request = new IMMessage(IMP.SYSTEM.getName(), sysTime(), onlineUsers.size(), getNickName(client) + "离开");
            String content = imEncoder.encode(request);
            onlineUser.writeAndFlush(new TextWebSocketFrame(content));
        }
        onlineUsers.remove(client);
    }

    public void sendMsg(Channel client, IMMessage msg) {
        sendMsg(client, imEncoder.encode(msg));
    }
    /**
     * 发送消息
     * @param client
     * @param msg
     */
    public void sendMsg(Channel client,String msg){
        IMMessage request = imDecoder.decode(msg);
        if(null == request){ return; }

        String addr = getAddress(client);

        if(request.getCmd().equals(IMP.LOGIN.getName())){
            client.attr(NICK_NAME).getAndSet(request.getSender());
            client.attr(IP_ADDR).getAndSet(addr);
            onlineUsers.add(client);

            for (Channel channel : onlineUsers) {
                if(channel != client){
                    request = new IMMessage(IMP.SYSTEM.getName(), sysTime(), onlineUsers.size(), getNickName(client) + "加入");
                }else{
                    request = new IMMessage(IMP.SYSTEM.getName(), sysTime(), onlineUsers.size(), "已与服务器建立连接！");
                }
                String content = imEncoder.encode(request);
                channel.writeAndFlush(new TextWebSocketFrame(content));
            }
        }else if(request.getCmd().equals(IMP.CHAT.getName())){
            for (Channel channel : onlineUsers) {
                if (channel == client) {
                    request.setSender("you");
                }else{
                    request.setSender(getNickName(client));
                }
                request.setTime(sysTime());
                String content = imEncoder.encode(request);
                channel.writeAndFlush(new TextWebSocketFrame(content));
            }
        }else if(request.getCmd().equals(IMP.FLOWER.getName())){
            JSONObject attrs = getAtrrs(client);
            long currTime = sysTime();
            if(null != attrs){
                long lastTime = attrs.getLongValue("lastFlowerTime");
                //60秒之内不允许重复刷鲜花
                int secends = 10;
                long sub = currTime - lastTime;
                if(sub < 1000 * secends){
                    request.setSender("you");
                    request.setCmd(IMP.SYSTEM.getName());
                    request.setContent("您送鲜花太频繁," + (secends - Math.round(sub / 1000)) + "秒后再试");
                    String content = imEncoder.encode(request);
                    client.writeAndFlush(new TextWebSocketFrame(content));
                    return;
                }
            }

            //正常送花
            for (Channel channel : onlineUsers) {
                if (channel == client) {
                    request.setSender("you");
                    request.setContent("你给大家送了一波鲜花雨");
                    setAttrs(client, "lastFlowerTime", currTime);
                }else{
                    request.setSender(getNickName(client));
                    request.setContent(getNickName(client) + "送来一波鲜花雨");
                }
                request.setTime(sysTime());

                String content = imEncoder.encode(request);
                channel.writeAndFlush(new TextWebSocketFrame(content));
            }
        }
    }

    /**
     * 获取当前时间
     * @return
     */
    private long sysTime() {
        return System.currentTimeMillis();
    }

}
