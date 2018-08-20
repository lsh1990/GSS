package com.basis.modifier.in;

public class People {
	
	private String name;
	static String age;
	
	//不加任何修饰符，本类和同包可见
	 String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	protected static void add() {
		
	}
	
}
