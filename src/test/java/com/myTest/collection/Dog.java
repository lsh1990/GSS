package com.myTest.collection;

public class Dog implements Comparable<Dog>{
	
	private int size;
	
	/**
	 * true:升序   false:降序
	 * 排序方式对所有对象都是保持一致 ,使用static来保持一致
	 * 所有对象独享的,定义为静态变量
	 * 每个对象独享的,定义为普通变量
	 */
	private static boolean desc = false;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Dog(int size) {
		super();
		this.size = size;
	}

	@Override
	public int compareTo(Dog o) {
		if (desc) {
			return size - o.size;//o.size 最大值
		} 
		return o.size - size;
	}
	
	@Override
	public String toString() {
		return "Dog [size=" + size + "]";
	}
}
