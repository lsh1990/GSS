package com.basis.myTest.observerPattern01;

import java.util.Observable;

/**
 * @Description: 天气目标类
 * @author-lsh
 * @date 2018年3月19日 下午8:42:08
 */
public class WeatherSubject extends Observable {
	
	//天气情况的内容
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		//天气情况变化,通知所有的观察者
		//在用java中的Observer模式时候，下面这句话不可少
		this.setChanged();
		//主动通知,选用推的方式
		this.notifyObservers(content);
		//主动通知，选用拉的模式
//		this.notifyObservers();
	}
	
	

}
