package com.thread.lock;

import static org.hamcrest.CoreMatchers.nullValue;

import java.awt.event.WindowListener;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @Description: 读写锁测试
 * 1.三个读线程、三个锁线程
 * @author-lsh
 * @date 2018年3月29日 下午8:31:15
 */
public class LockTest {
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
//					try {
//						while (true) {
//							queue.get();
//						}
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
			}).start();
		}
		
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
//					try {
//						while (true) {
//							queue.put(String.valueOf(Math.random()));
//						}
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			}).start();
		}
	}

}

class Queue{
	
	ReadWriteLock rwl = new ReentrantReadWriteLock();
	private Object data = null;
	
	public void get() throws InterruptedException {
		rwl.readLock().lock();
		System.out.println(Thread.currentThread().getName() + "be ready to read data!");
		Thread.sleep((long) (Math.random()*1000));
		System.out.println(Thread.currentThread().getName() + "have read data:" + data);
		rwl.readLock().unlock();
	}
	
	public void put(String data) throws InterruptedException {
		rwl.writeLock().lock();
		System.out.println(Thread.currentThread().getName() + "be ready to write data!");
		Thread.sleep((long) (Math.random()*1000));
		this.data = data;
		System.out.println(Thread.currentThread().getName() + "have write data:" + data);
		rwl.writeLock().unlock();
	}
	
}

