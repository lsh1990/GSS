package com.stringDemo;

/**
 * @Description: 
 * @author-lsh
 * @date 2018年5月9日 下午9:57:35
 */
public class StringTest {
	public static void main(String[] args) {
		
//		// 比较地址
//		String s1 = new String("AAA");
//		String s2 = new String("AAA");
//		System.out.println(s1 == s2);
		
//		String s3 = "AAA";
//		String s4 = "AAA";
//		System.out.println(s3 == s4);
//		System.out.println(s3.equals(s4));
		
		// 字符串是不可变的,每次的修改本质上都是创建了一个副本
//		String s5 = "AAA";
//		String s6 = s5;
//		s6 = s6 + "BBB";
//		System.out.println(s5 == s6);
//		System.out.println(s5.equals(s6));
		
		
		// 如果遇到字符串的频繁相加如何处理,StringBuffer来处理
		StringBuffer s7 = new StringBuffer("AAA");
		StringBuffer s8 = s7;
		s8.append("BBB");
		System.out.println(s7 == s8);
		System.out.println(s7.equals(s8));
		
		
	}

}
