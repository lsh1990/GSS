package com.thread;

/**
 * @Description: 继承与接口实现方式比较
 * 1.实现runable,避免了单继承局限性
 * 2.多个线程共享一个资源时，利用runnable
 * 3.线程的生命周期：
 * @author-lsh
 * @date 2018年3月18日 下午8:13:10
 */
public class ThreadTest {
	
	public static void main(String[] args) {
		//1.测试利用继承方式实现的线程
//		ThreadExtend t1 = new ThreadExtend("1号窗口");
//		ThreadExtend t2 = new ThreadExtend("2号窗口");
//		ThreadExtend t3 = new ThreadExtend("3号窗口");
//		t1.start();
//		t2.start();
//		t3.start();
		/**
		 * 以下方式可以避免,但是继承Thread后本身就有start方法了，这样写就多此一举了。
		 */
//		ThreadExtend thred = new ThreadExtend();
//		Thread t1 = new Thread(thred, "1号窗口");
//		Thread t2 = new Thread(thred, "2号窗口");
//		Thread t3 = new Thread(thred, "3号窗口");
//		t1.start();
//		t2.start();
//		t3.start();
		
		//2.测试利用接口方式实现线程
//		ThreadImplement thread = new ThreadImplement();
//		Thread t1 = new Thread(thread,"1号窗口");
//		Thread t2 = new Thread(thread,"2号窗口");
//		Thread t3 = new Thread(thread,"3号窗口");
//		t1.start();
//		t2.start();
//		t3.start();
	}

}
