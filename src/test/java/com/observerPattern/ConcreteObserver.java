package com.observerPattern;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description: 具体观察者
 * @author-lsh
 * @date 2018年3月19日 下午10:21:39
 */
public class ConcreteObserver implements Observer {
	//观察者变量名称
	private String observerName;

	@Override
	public void update(Observable o, Object arg) {
		//推的方式
		System.out.println(observerName + "收到消息，目标推送过来的信息:" + arg);
		//拉的方式
//		System.out.println(observerName + "收到消息，拉取的信息:" + ((WeatherSubject)o).getContent());
	}

	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

}
