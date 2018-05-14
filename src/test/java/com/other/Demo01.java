package com.other;

public class Demo01 {
	
	public static void main(String[] args) {
		String s1 = new String("dddddd");
		String s2 = s1;
		s2 = "fdsdsds";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}

}
