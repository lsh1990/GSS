package com.basis.finallyTest;

/**
 * @Description: finally测试
 * @author-lsh
 * @date 2018年4月4日 上午8:57:20
 */
public class FinallyTest {

	public static void main(String[] args) {
		System.out.println(add());
	}
	
	
	private static  int add() {
 		int x = 1;
		try {
			//终止java虚拟机
//			System.exit(0);
			return x;
		} catch (Exception e) {
			System.out.println("catch已经执行!");
		} finally {
//			++x;
			++x;
			System.out.println("finally已经执行!");
			//返回结果为2
//			return x;
		}
		return 0;
	}
}
