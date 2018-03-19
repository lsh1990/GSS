package com.observerPattern01;

/**
 * @Description: 观察者测试类
 * @author-lsh
 * @date 2018年3月19日 下午10:41:07
 */
public class ObserveTest {
	public static void main(String[] args) {
		//创建一个天气目标对象
		WeatherSubject weatherSubject = new WeatherSubject();
		//观察者
		ConcreteObserver observer1 = new ConcreteObserver();
		observer1.setObserverName("俺是第一个观察者");
		ConcreteObserver observer2 = new ConcreteObserver();
		observer2.setObserverName("俺是第二个观察者");
		
		//注册观察者
		weatherSubject.addObserver(observer1);
		weatherSubject.addObserver(observer2);
		
		//目标对象开始更新内容
		weatherSubject.setContent("大暴雪来袭!");
	}
}
