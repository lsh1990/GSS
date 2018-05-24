package com.gss.uitls;

/**
 * @Description: 传输器配置
 * @author-lsh
 * @date 2018年5月3日 下午4:57:47
 */
public class TransmitterPropertyConfigs {
	
	/**
	 * @Description: 公用配置
	 * @author-lsh
	 * @date 2018年5月3日 下午5:03:35
	 */
	public static class CommonConfig {
		
		public static final String TRANS_SRC = Constant.TRANSPORT_BUNDLE.getString("trans.src", "");
		
	}
	
	/**
	 * @Description: activemq 方式传输配置
	 * @author-lsh
	 * @date 2018年5月4日 下午4:56:34
	 */
	public static class ActiveMQConfig {
		//数据接收队列
    	public static final String RECEIVE_QUEUE = Constant.TRANSPORT_BUNDLE.getString("activemq.edi.receive.queue");

    	//数据接收队列
    	public static final String RECEIPT_QUEUE = Constant.TRANSPORT_BUNDLE.getString("activemq.edi.receipt.queue");
    	
    	//activemq中文件名
    	public static final String FILENAME_PROPERTY = Constant.TRANSPORT_BUNDLE.getString("activemq.edi.filename.property");
    	
    	//用户名
    	public static final String USERNAME = Constant.TRANSPORT_BUNDLE.getString("activemq.edi.username");
    	
    	//密码
    	public static final String PASSWORD = Constant.TRANSPORT_BUNDLE.getString("activemq.edi.password");
    	
    	//密码
    	public static final String PORT = Constant.TRANSPORT_BUNDLE.getString("activemq.edi.port", "61616");
    	
    	//brokerURL
    	public static final String BROKER_URL = Constant.TRANSPORT_BUNDLE.getString("activemq.edi.brokerurl");
	}
	
	
	public static class FilePath { 
		public static final String RECEIVE_PATH = Constant.TRANSPORT_BUNDLE.getString("local.receive.path");
	}
	
	

}
