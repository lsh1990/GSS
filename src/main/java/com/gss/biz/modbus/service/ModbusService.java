package com.gss.biz.modbus.service;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.ip.IpParameters;

/**
 * @Description: modbus初始化连接
 * @author-lsh
 * @date 2018年5月17日 下午3:54:38
 */
public class ModbusService {
	

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private ModbusFactory modbusFactory = new ModbusFactory();
	protected ModbusMaster master;
	
	private String host;//ip地址
	private int port;//端口
	private IpParameters ipParameters;
	
	public ModbusService(String host, int port) {
		super();
		this.host = host;
		this.port = port;
		this.ipParameters = new IpParameters();
		ipParameters.setHost(host);
		ipParameters.setPort(port);
	}
	
	/**
	 * @Description: tcp连接
	 */
	public void connection() {
		try {
			master = modbusFactory.createTcpMaster(ipParameters, true);
			//设置超时时间
//    		master.setTimeout(500);
			master.init();
		} catch (ModbusInitException e) {
			logger.error("connection 设备：{}, 进行modbus连接异常，进行重连操作", 
					ipParameters.getHost() + ":" + ipParameters.getPort());
		}
	}
}
