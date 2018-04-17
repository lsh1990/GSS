package com.thread;

/**
 * @Description: 锁测试 
 * 1.锁互斥测试
 * 2.打印两个字符串
 * @author-lsh
 * @date 2018年3月28日 下午9:14:48
 */
public class LockTest {
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
						outPrint("lishihe");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
						outPrint("guoshuangshuang");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}

	private static void outPrint(String name) {
		//互斥要用同一个对象
		synchronized (LockTest.class) {
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}
