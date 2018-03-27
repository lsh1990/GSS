package com.thread;

/**
 * @Description: 
 * 1.子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次，请写出程序。
 * @author-lsh
 * @date 2018年3月27日 上午6:52:48
 */
public class TraditionalThreadCommunication {
	
	
	public static void main(String[] args) {
		TraditionalThreadCommunication threadCommunication = new TraditionalThreadCommunication();
		threadCommunication.init();
	}
	
	private void init() {
		Business business = new Business();
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					business.son();
					
				}
				
			}
		});
		
		thread.start();
		
		for (int i = 0; i < 50; i++) {
			business.main();
		}
	}

}


/**
 * @Description: 内部类抽取方法
 * @author-lsh
 * @date 2018年3月27日 上午6:57:35
 */
class Business {
	
	boolean mark = false;
	//1.创建两个线程，分别执行自己的动作互不印象
	
	public synchronized void son() {
		Thread sonThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (mark) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				for (int i = 0; i <= 10; i++) {
					System.out.println("son:" + i);
				}
				
				mark = true;
				this.notify();
			}
		});
		sonThread.start();
	}
	
	public synchronized void main() {
		Thread father = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!mark) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int i = 0; i <= 100; i++) {
					System.out.println("father:" + i);
				}
				mark = false;
				this.notify();
				
			}
		});
		father.start();
	}
	
}
