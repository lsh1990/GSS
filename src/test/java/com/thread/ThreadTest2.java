package com.thread;

/**
 * @Description: 创建线程的两种方式
 * @author-lsh
 * @date 2018年3月26日 上午7:20:38
 */
public class ThreadTest2 {
	
	public static void main(String[] args) {
		//第一种方式
//		Thread thread = new Thread() {
//			@Override
//			public void run() {
//				while (true) {
//					try {
//						Thread.sleep(10000);
//						System.out.println("1:" + Thread.currentThread().getName());
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		thread.start();
		
		
		//第二种方式 此种方式体现了面向对象
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10000);
						System.out.println("2:" + Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

}
