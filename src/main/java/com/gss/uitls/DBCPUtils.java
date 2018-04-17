package com.gss.uitls;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.gss.uitls.PropertyConfigs.dbConfig;

/**
 * @Description: DBCP工具
 * @author-lsh
 * @date 2018年4月17日 下午8:44:31
 */
public class DBCPUtils {
	
	//创建连接池对象
	private static BasicDataSource dataSource = new BasicDataSource();
	
	//数据库参数
	public static String driver = dbConfig.JDBC_DRIVER;
	public static String url = dbConfig.JDBC_URL;
	public static String user = dbConfig.JDBC_USER;
	public static String password = dbConfig.JDBC_PASSWORD;
	
	 //将 配置连接池的信息加载到 连接池中
	 //通过静态代码快,完成 连接池 对象的信息配置
	static {
		//指定驱动器名称
		dataSource.setDriverClassName(driver);
		 //指定数据库地址 
		 dataSource.setUrl(url);
		 //指定用户名
		 dataSource.setUsername(user);
		 //指定密码
		 dataSource.setPassword(password);
	}
	
	 /*
	  * 提供 获取连接池对象的 操作 
	  */
	 public static DataSource getDataSource(){
		 
		 return dataSource;
	 }
}
