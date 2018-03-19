package com.classLoader;

/**
 * @author 类加载器
 *
 */
public class LoaderTest {
	
	public static void main(String[] args) {
		//classPath下
		LoaderTest.class.getClassLoader().getResourceAsStream("");
	}

}
