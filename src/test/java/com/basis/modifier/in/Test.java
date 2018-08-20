package com.basis.modifier.in;

/**
 * @Description: 测试修饰符号
 * 
 * @author-lsh
 * @date 2018年3月22日 上午7:16:38
 */
public class Test {
	
	private String name;

	public static void main(String[] args) {
		People people = new People();
		people.setName("张三");
		people.getName();
	}
}
