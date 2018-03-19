package com.thread;

/**
 * @Description: 利用接口实现线程
 * @author-lsh
 * @date 2018年3月18日 下午7:12:09
 */
public class ThreadImplement implements Runnable{
	
	private int ticketCount = 5;
	@Override
	public void run() {
		while (true) {
			if (ticketCount > 0) {
				System.out.println(Thread.currentThread().getName() + "开始卖票.");
				ticketCount--;
				System.out.println(Thread.currentThread().getName() + "结束卖票，还剩张数:" + ticketCount);
			} else {
				break;
			}
		}
	}

}
