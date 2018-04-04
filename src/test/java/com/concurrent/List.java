package com.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description: 并发list和普通list比较
 * @author-lsh
 * @date 2018年4月4日 上午8:20:32
 */
public class List {
	
	public static void main(String[] args) {
		
		//普通list
		ArrayList<User> list = new ArrayList<>();
		//并发lsit,移除不会报错
//		CopyOnWriteArrayList<User> list = new CopyOnWriteArrayList<>();
		
		list.add(new User("张三", 18));
		list.add(new User("李四", 20));
		list.add(new User("王五", 21));
		System.out.println("原始大小:" + list.size());
		Iterator<User> users = list.iterator();
		
		while (users.hasNext()) {
			User user = users.next();
			if ("王五".equals(user.getName())) {
				//利用迭代器移除对象不会报错
				users.remove();
				//利用list移除对象会产生并发错误
				list.remove(user);
				System.out.println("移除后大小:" + list.size());
			}
			
		}
		
	}

}
