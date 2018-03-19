package com.quence;

import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

public class QuenceTest {
	
	@Test
	public void name() {
		EdiModel ediModel = new EdiModel();
		LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>();
		linkedBlockingQueue.offer(ediModel);
		System.out.println(linkedBlockingQueue.poll());
	}

}
