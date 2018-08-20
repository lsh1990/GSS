package com.basis.genericityTest;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class Test {
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		ArrayList<Integer> collection1 = new ArrayList<Integer>();
		//添加不进去
		//collection1.add("abc");
		//java编译完后就没有了泛型，利用反射添加进去
		collection1.getClass().getMethod("add", Object.class).invoke(collection1, "你好");
		System.out.println(collection1.get(0));
		printCollection(collection1);
	}
	
	/**
	 * @Description: TODO
	 * 1.Collection<Object>与printCollection(collection1);不能传入，类型不匹配
	 * @param collection 
	 */
	public static void printCollection(Collection<?> collection) {
		for (Object object : collection) {
			System.out.println(object);
		}
	}
	
	//*******************泛型应用1****************
	//泛型语法的定义
	@org.junit.Test
	public void tsst1() {
		//调用泛型时会将int类型，自动装箱，变成Integer
		Integer add = add(1,5);
		Number add1 = add(1, 1.1);
		Object add2 = add(2, "1");
	}
	
	/**
	 * @Description: 定义一种类型，紧挨着返回值，表明新声明了一种类型
	 * @param x
	 * @param y
	 * @return 
	 */
	private <T> T add(T x, T y) {
		return null;
	}
	
	//*******************泛型应用2****************
	//交换数组中两个元素的位置
	@org.junit.Test
	public void test3() {
		//定义数组的三种方式
		//1:
//		String [] a = new String[5];
//		a[0] = "1";
//		a[1] = "2";
//		a[2] = "3";
		//2:
//		String[] a = new String[] {"1", "2", "3"};
		//3:
		String[] a = {"1", "2", "3"};
		swap(a, 1, 2);
		System.out.println(Arrays.toString(a));
		//泛型对应的实际类型只能是对象类型，引用类型，不能是基本类型。
		//此处不会自动装箱，因为数组，本身就是对象
//		swap(new int[]{1,2,3}, 1, 2);
		swap(new Integer[]{1,2,3}, 1, 2);
	}
	
	private <T> void swap(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
	
}
