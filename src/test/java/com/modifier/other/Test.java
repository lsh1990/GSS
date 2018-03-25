package com.modifier.other;

import com.modifier.in.People;

public class Test extends People{
	
	public static void main(String[] args) {
		People people = new People();
		//add方法修饰符号为protected
		people.add();
	}
	
}
