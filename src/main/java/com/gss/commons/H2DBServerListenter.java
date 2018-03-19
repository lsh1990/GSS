package com.gss.commons;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.h2.tools.Server;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.gss.uitls.H2DBUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: H2数据库连接线程
 * @author-lsh
 * @date 2018年3月15日 下午5:23:55
 */
@Slf4j
public class H2DBServerListenter implements ApplicationListener{
	
	//H2数据库服务器启动实例
	private Server server;

	/**
	 * @Description： Web应用初始化时启动H2数据库
	 * @param arg0
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
//	@Override
//	public void contextInitialized(ServletContextEvent arg0) {
//		//创建数据库
//		try {
//			H2DBUtils.create();
//			log.info("H2DBServerListener.contextInitialized ## 启动h2数据库服务........");
//			Server.createTcpServer().start();
//			log.info("H2DBServerListener.contextInitialized ## 启动h2数据库服务成功........");
//		} catch (SQLException e) {
//			log.info("H2DBServerListener.contextInitialized ## 启动h2数据库服务异常........", e);
//		}
//	}
	
	
	/**
	 * @Description： Web应用销毁时停止H2数据库
	 * @param arg0
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
//	@Override
//	public void contextDestroyed(ServletContextEvent arg0) {
//		if (this.server != null) {
//			//停止H2数据库
//			this.server.stop();
//			this.server = null;
//		}
//	}


	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		//创建数据库
		try {
			H2DBUtils.create();
			log.info("H2DBServerListener.contextInitialized ## 启动h2数据库服务........");
			Server.createTcpServer().start();
			log.info("H2DBServerListener.contextInitialized ## 启动h2数据库服务成功........");
		} catch (SQLException e) {
			log.info("H2DBServerListener.contextInitialized ## 启动h2数据库服务异常........", e);
		}
		
	}

	
	
}
