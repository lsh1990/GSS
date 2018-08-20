package com.basis.observerPattern02;

/**
 * @Description: 观察者接口
 * @author-lsh
 * @date 2018年3月20日 上午7:20:56
 */
public interface Observer {
	
	/**
	 * @Description: 更新方法，目标变化时通知观察者
	 * @param subject 
	 */
	public void update(WeatherSubject subject);
	
	/**
	 * @Description: 设置观察者名称
	 * @param observerName 
	 */
	public void setObserverName(String observerName);
	
	/**
	 * @Description: 获取观察者名称
	 */
	public String getObserverName();
}
