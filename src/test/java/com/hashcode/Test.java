package com.hashcode;

/**
 * @Description: hashCode与equal比较
 * @author-lsh
 * @date 2018年3月21日 下午8:22:00
 */
public class Test {
	
	public static void main(String[] args) {
		Company one = new Company("张三", 18);
		Company two = new Company("李四", 20);
		Company three = new Company();
		three.setName("张三");
		three.setAge(18);
		
//		System.out.println(one.equals(three) ? true : false);
//		System.out.println(one.equals(two) ? true : false);
//		System.out.println(one.hashCode());
//		System.out.println(three.hashCode());
		System.out.println(1 << 4);
	}

	private static char[] Integer(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
