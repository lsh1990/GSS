package com.gss.biz.modbus.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @Description: modbus内存实体
 * @author-lsh
 * @date 2018年5月17日 下午1:37:26
 */
public class MemoryModel {
	
	protected static Logger logger = LoggerFactory.getLogger(MemoryModel.class);
	
	//成员变量用static修饰，被类所共享，不依赖特定的实例
	
	//编号
	private static Integer climbingMachine = 0;
	
	//监控
	private static Integer monitorClimbingMachine = 0;
	
	//分拣
	private static Integer modbusCustomsSortingWait = 0;
	
	//真实触发
	private static Integer statusClimbBelt = 0;
	
	
	/*
	 * 提供数据设置和获取的方法
	 */
	
	
	/*********************如果枚举名称和内存实体名称不一致，需要自己手动实现匹配***************************/
	/**
	 * @Description: 根据枚举名称获取内存数据
	 * @param modbusNameEnum
	 * @return 
	 */
/*	public static Integer getValue(ModbusNameEnum modbusNameEnum) {
		switch (modbusNameEnum) {
		case CLIMBING_MACHINE:
			return getClimbingMachine();
		default:
			return null;
		}
	}*/
	
	
	/**
	 * @Description: 根据枚举设置内存数据
	 * @param modbusNameEnum
	 * @param value 
	 */
/*	public static void setValue(ModbusNameEnum modbusNameEnum, Integer value) {
		switch (modbusNameEnum) {
		case CLIMBING_MACHINE:
			setClimbingMachine(value);
			break;
		default:
			break;
		}
	}*/
	
	/*********************如果枚举名称和内存实体名称一致，可以用反射自己实现***************************/
	
	/**
	 * @Description: 获取内存中的数据
	 * @param modbusNameEnum
	 * @return 
	 */
	public static Integer getValue(ModbusNameEnum modbusNameEnum) {
		//获取modbus名称
		String modbusName = modbusNameEnum.getName();
		//获取方法名称
		String getMethodsStr = nameConversion(modbusName, "get");
		Method method = null;
		try {
			method = MemoryModel.class.getMethod(getMethodsStr);
			return (Integer) method.invoke(new MemoryModel());
		} catch (NoSuchMethodException | SecurityException e) {
			logger.error("getPLCValue ## getMethodsStr:{} get方法不存在!", getMethodsStr);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
			logger.error("getPLCValue ## getMethodsStr: {} get方法获取的数值异常!", getMethodsStr);
		}  
		return null;
	}
	
	
	/**
	 * @Description: 设置内存中的数据
	 * @param phototubeName
	 * @param value 
	 */
	public static void setValue(ModbusNameEnum modbusNameEnum, Integer value){
		//获取modbus名称
		String modbusName = modbusNameEnum.getName();
		String setMethodsStr = nameConversion(modbusName, "set");
		
		Method method = null;
		try {
			method = MemoryModel.class.getMethod(setMethodsStr, Integer.class);
			try {
				method.invoke(setMethodsStr, value);
				logger.info("setPLCValue ## setMethodsStr:{}, value:{}", setMethodsStr, value);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				logger.error("setPLCValue ## setMethodsStr: {} set方法设置的数值异常!", setMethodsStr);
			}
		} catch (NoSuchMethodException | SecurityException e) {
			logger.error("setPLCValue ## setMethodsStr:{} set方法不存在!", setMethodsStr);
		} 
	}
	
	
	
	/**
	 * @Description: 光电管名称大小写转换
	 * @param phototubeName
	 * @param type
	 * @return 
	 */
	public static String nameConversion(String phototubeName, String type){
		char mark = '_';
		if (phototubeName == null || "".equals(phototubeName.trim())) {
			logger.info("nameConversion ## 光电管名称为空");
		}
		//转换成小写
		String param = phototubeName.toLowerCase();
		//获取长度
		int len = param.length(); 
		//创建拼接字符串
        StringBuilder sb = new StringBuilder(len); 
        for (int i = 0; i < len; i++) {
        	char c = param.charAt(i);
        	if (c == mark) {
				if (++i < len) {
					//将分隔符后的第一个字母转换成大写
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else if (i == 0){
				//将第一个字母转换成大写
				sb.append(Character.toUpperCase(param.charAt(i)));
			} else {
				//小写字母拼接
				sb.append(c);
			}
		}
		return sb.insert(0, type).toString();
	}
	
	
	
	
	
	

	public static synchronized Integer getClimbingMachine() {
		return climbingMachine;
	}

	public static synchronized void setClimbingMachine(Integer climbingMachine) {
		MemoryModel.climbingMachine = climbingMachine;
	}

	public static synchronized Integer getMonitorClimbingMachine() {
		return monitorClimbingMachine;
	}

	public static synchronized void setMonitorClimbingMachine(Integer monitorClimbingMachine) {
		MemoryModel.monitorClimbingMachine = monitorClimbingMachine;
	}

	public static synchronized Integer getModbusCustomsSortingWait() {
		return modbusCustomsSortingWait;
	}

	public static synchronized void setModbusCustomsSortingWait(Integer modbusCustomsSortingWait) {
		MemoryModel.modbusCustomsSortingWait = modbusCustomsSortingWait;
	}

	public static synchronized Integer getStatusClimbBelt() {
		return statusClimbBelt;
	}

	public static synchronized void setStatusClimbBelt(Integer statusClimbBelt) {
		MemoryModel.statusClimbBelt = statusClimbBelt;
	}
	
	
	
	
	

}
