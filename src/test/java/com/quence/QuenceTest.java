package com.quence;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

public class QuenceTest {
	
	@Test
	public void name() throws InterruptedException {
		EdiModel ediModel = new EdiModel();
		LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>();
		linkedBlockingQueue.offer(ediModel);
		linkedBlockingQueue.put(ediModel);
		linkedBlockingQueue.take();
		System.out.println(linkedBlockingQueue.poll());
		
//		ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
		ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
		arrayBlockingQueue.put(ediModel);
		arrayBlockingQueue.take();
	}

}
