package com.basis.thread;

/**
 * @Description: 利用继承方式实现线程
 * 1.模拟卖票,三个售票窗口，有5张车票
 * @author-lsh
 * @date 2018年3月18日 下午6:08:23
 */
public class ThreadExtend extends Thread{
	
	private int ticketsCount = 5;//5张火车票
	private String name;//线程名称
	
	public ThreadExtend(String name) {
		super();
		this.name = name;
	}

	/**
	 * @Description： 执行卖票逻辑
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (true) {
			if (ticketsCount > 0) {
				System.out.println(name + "开始卖票。");
				ticketsCount--;
				System.out.println(name + "结束卖票,剩余张数:" + ticketsCount);
			} else {
				break;
			}
		}
	}
}
