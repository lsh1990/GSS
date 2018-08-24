package com.gss.biz.netty.chart.processor;

/**
 * @ClassName IMP
 * @Description: 自定义协议
 * @Author lsh
 * @Date 2018/8/24 7:26
 * @Version
 */
public enum IMP {
    /** 系统消息 */
    SYSTEM("SYSTEM"),
    /** 登录指令 */
    LOGIN("LOGIN"),
    /** 登出指令 */
    LOGOUT("LOGOUT"),
    /** 聊天消息 */
    CHAT("CHAT"),
    /** 送鲜花 */
    FLOWER("FLOWER");

    private String name;

    IMP(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.name;
    }
    public static boolean isIMP(String content){
        return content.matches("^\\[(SYSTEM|LOGIN|LOGIN|CHAT)\\]");
    }
}
