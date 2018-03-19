package com.observerPattern02;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @Description: 区别对待观察者模式
 * 1.创建一个集合，用于存放观察者
 * 2.创建add,remove方法用于移除观察者
 * 3.创建抽象方法notify
 * @author-lsh
 * @date 2018年3月20日 上午7:05:52
 */
public abstract class WeatherSubject {
	//定义一个集合,用于存放观察者
	public List<Observer> obs = new ArrayList<>();
	
	/**
	 * @Description: 添加观察者
	 * @param observer 
	 */
	public void addObserver(Observer observer) {
		obs.add(observer);
	}
	
	/**
	 * @Description: 移除观察者
	 * @param observer 
	 */
	private void deleteObserver(Observer observer) {
		obs.remove(observer);
	}
	
	/**
	 * @Description: 通知观察者，因是区别对待，所以这里就不具体实现
	 */
	protected abstract void notifyObservers();
}
