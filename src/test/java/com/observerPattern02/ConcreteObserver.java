package com.observerPattern02;

/**
 * @Description: 具体观察者
 * @author-lsh
 * @date 2018年3月20日 下午9:31:23
 */
public class ConcreteObserver implements Observer {
	//观察者名称
	private String observerName;
	//天气内容
	private String weatherContent;
	//提醒内容
	private String remindContent;

	
	public ConcreteObserver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConcreteObserver(String observerName, String remindContent) {
		super();
		this.observerName = observerName;
		this.remindContent = remindContent;
	}

	@Override
	public void update(WeatherSubject subject) {
		weatherContent = ((ConcreteWeatherSubject)subject).getWeatherContent();
		System.out.println(observerName + "收到信息开始" + remindContent);
	}

	@Override
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	@Override
	public String getObserverName() {
		return observerName;
	}

	public String getRemindContent() {
		return remindContent;
	}

	public void setRemindContent(String remindContent) {
		this.remindContent = remindContent;
	}

}
