package com.observerPattern02;

import java.util.Observer;

/**
 * @Description: 具体目标对象
 * @author-lsh
 * @date 2018年3月20日 上午7:26:47
 */
public class ConcreteWeatherSubject extends WeatherSubject {
	//天气内容
	private String weatherContent;

	@Override
	protected void notifyObservers() {
		//循环所有观察者
		for (Observer observer : obs) {
			
		}
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		this.notifyObservers();
	}
	

}
