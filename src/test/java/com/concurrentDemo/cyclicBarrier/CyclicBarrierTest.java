package com.concurrentDemo.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
	
	
	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(3);
		
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.submit(new Thread(new Runner(barrier, "小姚明")));
		pool.submit(new Thread(new Runner(barrier, "周星驰")));
		pool.shutdown();
		
	}

}

class Runner implements Runnable {
	
	private CyclicBarrier barrier;
	private String name;
	
	public Runner(CyclicBarrier barrier, String name) {
		super();
		this.barrier = barrier;
		this.name = name;
	}


	@Override
	public void run() {
		try {
			System.out.println((new Random()).nextInt(8));
			Thread.sleep(1000 * (new Random()).nextInt(8));
			System.out.println(name + "准备好了.......");
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(name + "起跑!");
	}
	
}
