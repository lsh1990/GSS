package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest{
	
	public static void main(String[] args) {
		
		WorkImpl workImpl = new WorkImpl();
		Work instance = (Work) Proxy.newProxyInstance(
				WorkImpl.class.getClassLoader(), //与目标对象有相同类加载器
				WorkImpl.class.getInterfaces(), //与目标对象有相同接口  动态生成代理对象就是接口类型
				new InvocationHandler() {	
			//invoke当代理对象在调用方法时就执行
			//proxy：代理对象，尽可能不用
			//method：目标的对象的方法
			//args：参数数组：使用代理对象调用方法时 传递的参数
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object invoke = method.invoke(workImpl, args);
				return invoke;
			}
		});
		
		System.out.println(instance.zidonghua("李昊"));
	}
	
}

class WorkImpl implements Work{

	@Override
	public void java() {
		System.out.println("我是java工程师!");
	}

	@Override
	public void php() {
		System.out.println("我是php工程师!");
		
	}

	@Override
	public String zidonghua(String name) {
		String info = "我的名字是:" + name + ",我是一名自动化工程师!";
		return info;
	}
}