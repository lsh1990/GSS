package com.gss.uitls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description: 创建JDBC连接
 * @author-lsh
 * @date 2018年4月14日 下午3:17:17
 */
public class JdbcUtils01 {
	
	/*
	 * 获取连接对象
	 */
	public static Connection getConnection(){
		
		try {
			//1:注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2:获得连接对象 
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day22_JDBC", "root", "root");
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
