package com.basis.thread;

public class ThreadTest4 {
	public static void main(String[] args) {
		Hellow hellow = new Hellow();
		new Thread(hellow).run();
//		hellow.run();
	}

}


class Hellow implements Runnable{

	@Override
	public void run() {
		System.out.println("4444444444");
		
	}
	
}