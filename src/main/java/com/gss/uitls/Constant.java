package com.gss.uitls;

import java.util.ResourceBundle;

import com.yunkou.common.util.ResourceBundleUtil;

/**
 * @Description: 系统常量类
 * @author-lsh
 * @date 2018年4月17日 下午8:49:42
 */
public class Constant {
	
	/**
	 * @Fields db : 
	 */
	public static final ResourceBundle db = ResourceBundle.getBundle("db");
	public static final ResourceBundleUtil DB = new ResourceBundleUtil(db);
	
}
