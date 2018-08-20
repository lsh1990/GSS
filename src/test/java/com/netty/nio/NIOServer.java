package com.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class NIOServer
{
    /**
     * 端口
     */
    private int port;
    /**
     * 地址
     */
    private InetSocketAddress address;
    /**
     * 选择器
     */
    private Selector selector;


    public static void main(String[] args) {
        new NIOServer(8080).listen();
    }

    public NIOServer(int port){
        try {
            this.port = port;
            InetSocketAddress socketAddress = new InetSocketAddress(port);
            //打开通道
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(socketAddress);
            //默认为阻塞，手动设置为非阻塞
            channel.configureBlocking(false);
            //打开选择器
            selector = Selector.open();
            //开始处理（事件）
            channel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器准备就绪，监听端口是：" + this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

    }


    public void listen(){
        while (true){
            try {
                //获取等待的数量
                int wait = this.selector.select();
                if (wait == 0){
                    continue;
                }
                Set<SelectionKey> keys = this.selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = keys.iterator();
                while (keyIterator.hasNext()){
                    SelectionKey key = keyIterator.next();
                    //数据处理
                    process(key);
                    keyIterator.remove();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        }

    /**
     * 数据业务处理
     * @param key
     */
    private void process(SelectionKey key) throws IOException {
        //分配缓冲区-创建一定数量的byte数组
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //接收状态
        if (key.isAcceptable()) {
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            SocketChannel client = channel.accept();
            //设置非阻塞
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            SocketChannel client =(SocketChannel) key.channel();
            int length = client.read(buffer);
            if (length > 0) {
                //固定数据
                buffer.flip();
                String content = new String(buffer.array(), 0, length);
                System.out.println("服务端读取到的内容为:" + content);
                client.register(selector, SelectionKey.OP_WRITE);
            }
            buffer.clear();
        } else if (key.isWritable()) {
            SocketChannel client =(SocketChannel) key.channel();
            client.write(ByteBuffer.wrap("hello word".getBytes()));
            client.close();
        }
    }
}
