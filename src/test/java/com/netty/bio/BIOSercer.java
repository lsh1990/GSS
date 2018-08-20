package com.netty.bio;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class BIOSercer {

        ServerSocket serverSocket;
        //带参构造方法
        public BIOSercer(int port){
            try {
                serverSocket = new ServerSocket(port);
                System.out.println("BIO服务端启动，监听端口为：" + port);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void listener() throws IOException {
            //死循环进行监听
            while (true){
                //没有客户端连接会在此一直阻塞
                Socket client = serverSocket.accept();
                InputStream inputStream =  client.getInputStream();
                //创建缓存区
                byte[] buff = new byte[1024];
                int length = inputStream.read(buff);
                if (length > 0){
                    String msg = new String(buff, 0, length);
                    System.out.println("收到的数据为:" + msg);
                }
            }
        }

        public static void main(String[] args) throws IOException {
            new BIOSercer(8080).listener();
        }
}
