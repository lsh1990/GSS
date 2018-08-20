package com.netty.nio.chatroom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName NIOClient
 * @Description: NIO客户端
 * @Author lsh
 * @Date 2018/8/13 21:56
 * @Version
 */
public class NIOClient {

    /**
     * 连接服务器地址信息
     */
    private final InetSocketAddress socketAddress = new InetSocketAddress("localhost", 8080);
    /**
     * 选择器
     */
    private Selector selector = null;
    /**
     * 通道
     */
    private SocketChannel channel = null;
    /**
     * 昵称
     */
    private String nickName = "";
    private Charset charset = Charset.forName("UTF-8");
    private static String USER_EXIST = "系统提示，该昵称已经存在，请换一个昵称！";
    private static String USER_CONTENT_SPILIT = "#@#";

    public NIOClient() throws IOException {
        //连接远程主机
        channel = SocketChannel.open(socketAddress);
        //设置为同步非阻塞
        channel.configureBlocking(false);
        //打开选择器
        selector = Selector.open();
        //注册事件
        channel.register(selector, SelectionKey.OP_READ);
    }

    /**
     * 写入数据
     */
    private class Writer extends Thread {
        @Override
        public void run() {
            //从键盘读取数据输入到服务端
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if ("".equals(line)) {
                    continue;
                }
                if ("".equals(nickName)) {
                    nickName = line;
                    line = nickName + USER_CONTENT_SPILIT;
                } else {
                    line = nickName + USER_CONTENT_SPILIT + line;
                }
                try {
                    channel.write(charset.encode(line));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //scanner.close();
            }
        }

    }

    private class Reader extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    int count = selector.select();
                    if (count == 0) {
                        continue;
                    }
                    //获取可用通道集合
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> keyIterator = keys.iterator();
                    while (keyIterator.hasNext()) {
                        SelectionKey key = keyIterator.next();

                        //业务处理
                        process(key);
                        keyIterator.remove();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        /**
         * 业务处理
         * @param key
         */
        private void process(SelectionKey key) throws IOException {
            if (key.isReadable()) {
                //使用 NIO 读取 Channel中的数据，这个和全局变量client是一样的，因为只注册了一个SocketChannel
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer buff = ByteBuffer.allocate(1024);
                String content = "";
                while (sc.read(buff) > 0) {
                buff.flip();
                content += charset.decode(buff);
                }
                //若系统发送通知，名字已存在，则需要换个昵称
                if (USER_EXIST.equals(content)) {
                    nickName = "";
                }
                System.out.println(content);
                key.interestOps(SelectionKey.OP_READ);
            }
        }
    }

    public void session() {
        //读取服务器数据
        new Reader().start();
        //写数据到服务器
        new Writer().start();
    }

    public static void main(String[] args) throws IOException {
        new NIOClient().session();
    }
}
