package com.netty.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * BIO客户端
 */
public class BIOClient {

    public static void main(String[] args) {
        int count = 5;
        //初始化用于创建count个线程
        final CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(){
                @Override
                public void run(){
                    try {
                        //阻塞直到count减到0
                        latch.await();
                        //创建客户端
                        Socket client = new Socket("localhost", 8080);
                        //获取输出流
                        OutputStream outputStream = client.getOutputStream();
                        String name = UUID.randomUUID().toString();
                        System.out.println("当前线程：" + Thread.currentThread().getName() + "写入数据为:" + name);
                        outputStream.write(name.getBytes());
                        outputStream.close();
                        client.close();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }.start();
            latch.countDown();
        }

    }

}
