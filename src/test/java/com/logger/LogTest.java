package com.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogTest {
	
//	private Logger logger = LoggerFactory.getLogger(LogTest.class);

	private static Logger logger = LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		logger.info("clearBarcode ## 清空条码开始。");
	}

}
