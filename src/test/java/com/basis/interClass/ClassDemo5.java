package com.basis.interClass;

public class ClassDemo5 {
	
	public Object demo01() {

		final int num = 1;
		// 局部内部类中要使用外面的局部变量,则变量必须采用final关键字
		
		class Inner1 implements Interface1 {

			@Override
			public int show() {
				return num + 1;
			}

		}
		return new Inner1();
	}

	public int demo02() {

		final int num = 1;

		class Inner1 implements Interface2 {

			@Override
			public int show() {
				return num * 1;
			}

		}
		int result = new Inner1().show();
		return result;
	}

	public static void main(String[] args) {
		ClassDemo5 test = new ClassDemo5();
//		Inner1 demo01 = test.demo01();
		System.out.println(test.demo01());
		System.out.println(test.demo02());
	}
}
