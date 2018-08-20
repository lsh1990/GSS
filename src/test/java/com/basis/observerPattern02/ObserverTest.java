package com.basis.observerPattern02;

/**
 * @Description: 区别对待观察者测试
 * @author-lsh
 * @date 2018年3月20日 下午9:45:10
 */
public class ObserverTest {
	
	public static void main(String[] args) {
		ConcreteWeatherSubject subject = new ConcreteWeatherSubject();
		ConcreteObserver observer = new ConcreteObserver("老婆", "回家收衣服!");
		ConcreteObserver observer2 = new ConcreteObserver("老公", "回家看孩子!");
		subject.addObserver(observer);
		subject.addObserver(observer2);
//		subject.setWeatherContent("下雨");
		subject.setWeatherContent("下雪");
	}

}
