package com.basis.interClass;

public class ClassDemoBase {

	public static void main(String[] args) {
		OuterClass03 out = new OuterClass03();
//		Object method = out.method();
	}
	
	}
/*
 * 局部内部类
 * */
class OuterClass03 {
	
	int num = 3;

//	public Object method() {
//		// 类在局部位置上,只能访问被final修饰的局部变量
//		  int num = 9;
//
//		class Inner {
//
//			public void show() {
//				// num 必须设置为final类型
//				System.out.println("show...." + num);
//				System.out.println("show...." + OuterClass03.this.num);
//			}
//		}
//		// 如果 num 不加 final类型,则意味着返回的对象调用show的时候 show里面的x已经释放了
//		Inner inner = new Inner();
//		inner.show();
//		return inner;
//	}
}