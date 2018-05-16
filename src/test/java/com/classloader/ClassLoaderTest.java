package com.classloader;

/**
 * @Description: 
 * @author-lsh
 * @date 2018年5月16日 下午3:03:11
 */
public class ClassLoaderTest {
	
	public static void main(String[] args) {
		son son = new son();
	}
}
class parent {
	
	private int c = initc();
	static {
		System.out.println("1--" + "父类静态代码块");
	}
	int initc() {
		System.out.println("2--" + "父类初始化成员变量");
		this.c = 12;
		return c;
	}
	public parent() {
		System.out.println("3 --" + "父类构造方法");
	}
}

class son extends parent {
	
	private int sc = initc2();
	static {
		System.out.println("4--" + "子类静态代码块");
	}
	int initc2() {
		System.out.println("5--" + "子类初始化成员变量");
		this.sc = 12;
		return sc;
	}
	public son() {
		System.out.println("6--" + "子类构造方法");
	}
}



