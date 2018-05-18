package com.gss.biz.modbus.model;

/**
 * @Description: modbus地址名称枚举
 * @author-lsh
 * @date 2018年5月17日 下午1:39:39
 */
public enum ModbusNameEnum implements EnumCode{
	
	//编号地址
	CLIMBING_MACHINE(1, "CLIMBING_MACHINE"),
	
	//监控地址
	MONITOR_CLIMBING_MACHINE(2, "MONITOR_CLIMBING_MACHINE"),
	
	//分拣地址
	MODBUS_CUSTOMS_SORTING_WAIT(3, "MODBUS_CUSTOMS_SORTING_WAIT"),
	
	//真实触发
	STATUS_CLIMB_BELT(4, "STATUS_CLIMB_BELT");
	
	
	private int type;
	
	private String name;
	
	private int curr;

	private ModbusNameEnum(int type) {
		this.type = type;
	}

	
	private ModbusNameEnum(int type, String name) {
		this.type = type;
		this.name = name;
	}


	@Override
	public int getNumber() {
		return type;
	}

	

	public synchronized int getCurr() {
		return curr;
	}


	public synchronized void setCurr(int curr) {
		this.curr = curr;
	}


	@Override
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		STATUS_CLIMB_BELT.setCurr(1);
	}

	
	
}
