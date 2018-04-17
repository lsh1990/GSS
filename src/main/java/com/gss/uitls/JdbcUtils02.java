package com.gss.uitls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 利用配置文件设置连接参数
 * @author-lsh
 * @date 2018年4月14日 下午9:37:37
 */
@Slf4j
public class JdbcUtils02 {
	//数据库参数
	public static String driver = null;
	public static String url = null;
	public static String user = null;
	public static String password = null;
	
	static {
		try {
			//1.创建properties集合
			Properties prop = new Properties();
			//2.读取配置文件中的数据
			prop.load(new FileInputStream("db.properties"));
			//3.获取集合中的数据
			driver = prop.getProperty("jdbc.driver");
			url = prop.getProperty("jdbc.url");
			user = prop.getProperty("jdbc.user");
			password = prop.getProperty("jdbc.password");
		} catch (FileNotFoundException e) {
			System.err.println("文件不存在");
		} catch (IOException e) {
			System.err.println("读取失败");
		}
	}
	
	/*
	 * 获取连接对象
	 */
	public static Connection getConnection(){
		
		try {
			//1:注册驱动
			Class.forName(driver);
			//2:获得连接对象 
			Connection connection = DriverManager.getConnection(url, user, password);
		    return connection;
		} catch (ClassNotFoundException e) {
			System.err.println("MYSQL注册驱动失败,请检查路径名");
		} catch (SQLException e) {
            System.err.println("连接数据库时,产生错误,请检查数据库连接地址或用户名密码错误");
		}
		return null;
	}
	
	/*
	 * 释放资源  
	 */
	public static void release(ResultSet rs , Statement sta ,Connection conn){
		try {
			rs.close();
		} catch (SQLException e) {
			System.err.println("结果集对象 释放失败");
		}
	  	  try {
			sta.close();
		} catch (SQLException e) {
			System.err.println("SQL语句执行者资源 释放失败");
		}
	  	  try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("连接对象 资源 释放失败");
		}
	}
}
