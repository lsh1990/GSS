package com.concurrent;

/**
 * @Description: 测试user
 * @author-lsh
 * @date 2018年4月4日 上午8:21:11
 */
public class User {
	
	private String name;
	
	private int age;
	
	
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
