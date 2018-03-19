package com.javabean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 利用
 * @author-lsh
 * @date 2018年3月14日 下午8:21:53
 */
public class Reflect {
	
	@org.junit.Test
	public void Test() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		People people = new People("1", "2", "3");
		String proName = "name";
		//反射设置参数
		setValue(people, proName);
		//反射获取数据
		getValue(people, proName);
	}

	/**
	 * @Description: 利用反射获取数据
	 * @param people
	 * @param proName
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException 
	 */
	private void getValue(People people, String proName)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor descriptor = new PropertyDescriptor(proName, People.class);
		Method readMethod = descriptor.getReadMethod();
		Object invoke = readMethod.invoke(people);
		System.out.println(invoke);
	}
	
	/**
	 * @Description: 设置属性
	 * @param people
	 * @param proName
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException 
	 */
	private void setValue(People people, String proName)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor descriptor = new PropertyDescriptor(proName, People.class);
		Method writeMethod = descriptor.getWriteMethod();
		writeMethod.invoke(people, "8");
		System.err.println(people.getName());
	}
	
	
}
