package com.gss.uitls;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <P>Title: ppoiq</P>
 * <P>Description: 配置文件读取工具类</P>
 * <P>Copyright: Copyright(c) 2014</P>
 * <P>Company: yunkouan.com</P>
 * <P>Date:2014年11月25日-下午4:24:05</P>
 * @author lify
 * @version 1.0.0
 */
public class ResourceBundleUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ResourceBundleUtil.class);
	
    //读取system配置文件中的值
	private final static ResourceBundle system = ResourceBundle.getBundle("system");
	 
	public static String getSystemString(String key, String defaultValue){
		try {
			return system.getString(key);
		} catch (MissingResourceException e) {
			logger.debug("getSystemString方法加载配置文件key值：{}，时出现异常，异常信息{}，采用默认值：" + defaultValue, key, e);
			return defaultValue;
		}
	}
	
	public static long getSystemLong(String key, long defaultValue){
		try {
			return Long.valueOf(system.getString(key));
		} catch (MissingResourceException e) {
			logger.debug("getSystemLong方法加载配置文件key值：{}，时出现异常，异常信息{}，采用默认值:" + defaultValue, key, e);
			return defaultValue;
		}
	}
	
	public static int getSystemInt(String key, int defaultValue){
		try {
			return Integer.valueOf(system.getString(key));
		} catch (MissingResourceException e) {
			logger.debug("getSystemInt方法加载配置文件key值：{}，时出现异常，异常信息{}，采用默认值" + defaultValue, key, e);
			return defaultValue;
		}
	}
	
	public static String[] getSystemStringArray(String key){
		return system.getString(key).split(",");
	}
	
	public static double getSystemDouble(String key){
	    return Double.valueOf(system.getString(key));
	}
	
	/**
	 * 获得配置在环境变量中的系统变量
	 * @param key 系统变量的变量
	 * @param defaultValue 默认值，当读取系统变变量返回null的时候，使用该值
	 * @return 系统变量的值
	 */
	public static String getEnvConf(String key,String defaultValue){
		String value= System.getenv(key);
		if(value==null){
			return defaultValue;
		}else{
			return value;
		}
	}
}
