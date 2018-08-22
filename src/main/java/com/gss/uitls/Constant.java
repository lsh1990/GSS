package com.gss.uitls;

import java.io.File;
import java.util.ResourceBundle;

import com.yunkou.common.util.ResourceBundleUtil;

/**
 * @Description: 系统常量类
 * @author-lsh
 * @date 2018年4月17日 下午8:49:42
 */
public class Constant {
	
	/**
	 * db : 
	 */
	public static final ResourceBundle db = ResourceBundle.getBundle("db");
	public static final ResourceBundleUtil DB = new ResourceBundleUtil(db);
	
	/**
	 * transport.properties
	 */
	public final static ResourceBundle transport = ResourceBundle.getBundle("transport");
	public final static ResourceBundleUtil TRANSPORT_BUNDLE = new ResourceBundleUtil(transport);
	
	/**
	 * @Description: 系统支持的数据传输方式
	 * @author-lsh
	 * @date 2018年5月4日 下午4:49:22
	 */
	public static class DataTransmitter {
		public static final String HTTP = "http";
    	public static final String MSMQ = "msmq";
    	public static final String SHAREDLOCAL = "sharedlocal";
    	public static final String FTP = "ftp";
    	public static final String DB = "db";
    	public static final String WEBSERVICE = "ws";
    	public static final String MIX = "mix";
    	public static final String UNNEED = "unneed";
    	public static final String ACTIVEMQ = "activemq";
    	public static final String IBMMQ = "ibmmq";
    	public static final String NJSDK = "njsdk";
	}
	
	
	
	

	/**
	 * The extension separator character.
	 */
	public static final String XML_FILE_POSTFIX_SEPARATOR = ".xml";
	/**
	 * The extension separator character.
	 */
	public static final String JSON_FILE_POSTFIX_SEPARATOR = ".json";
	
	
	/**
	 * @Description: 文件符号
	 * @author-lsh
	 * @date 2018年5月24日 上午7:23:59
	 */
	public static class FileSymbol {
		
		public static final String EXTENSION_SEPARATOR = ".";
		
		public static final char UNIX_SEPARATOR = '/';
		/**
		 * 文件名连接符号
		 */
		public static final char LINK_SEPARATOR = '_';

		public static final char WINDOWS_SEPARATOR = '\\';
		/**
		 * 波浪分隔符
		 */
		public static final char TILDE_SYMBOL_SEPARATOR = '~';
		/**
		 * 井号分隔符
		 */
		public static final char POUND_SYMBOL_SEPARATOR = '#';
		/**
		 * 空串
		 */
		public static final String EMPTY_STRING = "";
		/**
		 * 引号
		 */
		public static final char QUOTATION_SYMBOL_SEPARATOR = '\'';
		
		public static final char SYSTEM_SEPARATOR = File.separatorChar;
		/**
		 * 统一字符编码
		 */
		public static final String CHARSET_NAME = "utf-8";
		
	}

	
	
}
