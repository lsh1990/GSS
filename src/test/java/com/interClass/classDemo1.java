package com.interClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.interClass.OutClass.interClass;

/**
 * @Description: 1.成员内部类
 * @author-lsh
 * @date 2018年5月6日 下午3:09:45
 */
public class classDemo1 {
	
//	public static void main(String[] args) {
//		interClass interClass = new OutClass().new interClass();
//		interClass.show();
//	}
	
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<>();
		Iterator<String> iterator = arrayList.iterator();
		Iterator<String> iterator2 = linkedList.iterator();
	}
	
	
}

/**
 * @Description: 外部类
 * @author-lsh
 * @date 2018年5月6日 下午3:19:28
 */
class OutClass {
	
	private int num = 5;
	/**
	 * @Description: 内部类
	 * @author-lsh
	 * @date 2018年5月6日 下午3:20:21
	 */
	class interClass {
		
		private int num = 4;
		
		 void show() {
			int num = 3;
			System.out.println("num:" + num ); //num:3
			System.out.println("num:" + this.num ); //num:4
			System.out.println("num:" + OutClass.this.num);//num:5
		}
	}
	
}