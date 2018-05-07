package com.interClass;

import com.interClass.OutClass2.interClass;

/**
 * @Description: 局部内部类
 * @author-lsh
 * @date 2018年5月6日 下午8:13:30
 */
public class ClassDemo4 {
	
	public static void main(String[] args) {
		OutClass4 outClass4 = new OutClass4();
		Object method = outClass4.method();
	}

}

class OutClass4 {
	
	private int mum = 5;

	public int  method() {
		//类在局部位置上，只能访问被fianl修饰的局部变量
		int num = 4;

		class InterClass implements Interface1{

			@Override
			public int show() {
				System.out.println("num:" + num);
				System.out.println("num:" + OutClass4.this.mum);
				return num + 1;
			}
		}
		//如果num不加final类型，则意味着返回的对象调用show的时候show里面的x已经释放了。
		InterClass interClass = new InterClass();
		return interClass.show();
	}
}
