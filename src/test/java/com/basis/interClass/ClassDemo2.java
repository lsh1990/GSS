package com.basis.interClass;

import com.basis.interClass.OutClass2.interClass;

/**
 * @Description: 静态内部类
 * @author-lsh
 * @date 2018年5月6日 下午3:31:57
 */
public class ClassDemo2 {
	public static void main(String[] args) {
		//
		interClass interClass = new OutClass2.interClass();
		interClass.show();
		OutClass2.interClass.show2();
	}
}

class OutClass2 {
	
	private int num = 5;
	
	//内部类如果有static方法，则本身必须声明为static方式
	 static class interClass {
		 
		//原则 静态类中的所有成员必须是静态的。
		private int num = 4;
		
		void show() {
			int num = 3;
			System.out.println("show num:" + num);//num:3
			System.out.println("show num:" + this.num);//num:4
			System.out.println("show num:" + new OutClass2().num);//num:5
		}
		
		static void show2() {
			//静态方法没有this
//			System.out.println("show num:" + this.num);
			System.out.println("num:" + new OutClass2().num);//num:5
		}
	}
}