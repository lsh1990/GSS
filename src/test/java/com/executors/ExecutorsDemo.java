package com.executors;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.IIOByteBuffer;

import org.apache.tomcat.jni.Time;

/**
 * @Description: 线程池
 * @author-lsh
 * @date 2018年6月25日 下午8:27:16
 */
public class ExecutorsDemo {

	
	public static void main(String[] args) {
		
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(100);
		for (int i = 0; i <100; i++) {
			System.out.println(i);
			pool.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, 2, 10, TimeUnit.SECONDS);
		}
		
//		pool.scheduleWithFixedDelay(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
//					Thread.sleep(10000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}, 2, 10, TimeUnit.SECONDS);
		}
	}


