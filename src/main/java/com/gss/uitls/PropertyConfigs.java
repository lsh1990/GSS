package com.gss.uitls;


/**
 * @Description: 数据库连接配置文件
 * @author-lsh
 * @date 2018年4月17日 下午10:57:52
 */
public class PropertyConfigs {
	
	public static class dbConfig {
		//jdbc驱动
    	public static final String JDBC_DRIVER = Constant.DB.getString("jdbc.driver", "");
    	//数据库连接地址
    	public static final String JDBC_URL = Constant.DB.getString("jdbc.url", "");
    	//数据库用户名
    	public static final String JDBC_USER = Constant.DB.getString("jdbc.user", "");
    	//数据库密码
    	public static final String JDBC_PASSWORD = Constant.DB.getString("jdbc.password", "");
	}
	
}
