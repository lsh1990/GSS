package com.basis.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @Description: map的区别
 * 1.
 * @author-lsh
 * @date 2018年3月24日 下午4:12:40
 */
public class MapTest {
	
	public static void main(String[] args) {
		
		HashMap<Object, Object> hashMap = new HashMap<>();
		
		/************测试1*****************/
		//判断是否有此key，用此种方法。如果用get方法，没有此key返回null,如果value为null也返回null
//		hashMap.put(123, null);
//		System.out.println(hashMap.containsKey(123));
//		System.out.println(hashMap.get(123));
//		System.out.println(hashMap.get(321));
		/*********************************/
		/************测试2*****************/
		//key唯一、可以是null,value可以重复
//		hashMap.put(11, 11);
//		hashMap.put(11, 11);
//		hashMap.put(12, 11);
//		hashMap.put(null, 11);
//		hashMap.put(null, 12);
//		System.out.println(hashMap.size());
		/*****************************/
		
		Hashtable<Object, Object> hashtable = new Hashtable<>();
		/************测试3*****************/
		//key不能为null
//		hashtable.put(null, 1);
		/*****************************/
		
		HashSet<Object> hashSet = new HashSet<>();
		/************测试4*****************/
		//set集合内部也是通过map实现的
//		hashSet.add(11);
//		hashSet.add(11);
//		System.out.println(hashSet.size());
		
		/************测试5*****************/
		//模拟内存泄露
		Company c1 = new Company("张三", "2");
		Company c2 = new Company("张六", "2");
		Company c3 = new Company("王六", "2");
		
		hashSet.add(c1);
		hashSet.add(c2);
		hashSet.add(c3);
		
		//不重写hashCode,可以移除
		//重写不能移除
		c1.setAge("王五");
		hashSet.remove(c1);
//		hashSet.remove(c2);
		
		System.out.println(hashSet.size());
		System.out.println(c1.equals(c2));
		
	}
}
