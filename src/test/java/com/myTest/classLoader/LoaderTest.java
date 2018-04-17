package com.myTest.classLoader;

/**
 * @author 类加载器
 *
 */
public class LoaderTest {
	
	public static void main(String[] args) {
		//classPath下
		LoaderTest.class.getClassLoader().getResourceAsStream("");
		
		//展示类加载器的树形结构
		ClassLoader classLoader = LoaderTest.class.getClassLoader();
		while (classLoader != null) {
			System.out.println(classLoader.getClass().getName());
			classLoader = classLoader.getParent();
		}
		System.out.println(classLoader);
	}

}
