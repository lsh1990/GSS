package com.interClass;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @Description: 内部类
 * @author-lsh
 * @date 2018年5月6日 下午6:48:59
 */
public class ClassDemo3 {
	
	public static void main(String[] args) {
		//利用内部类对文件名进行过滤
		String[] list = new File("E:\\pdf资料").list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
//				System.out.println("dir:" + dir);
//				System.out.println("name:" + name);
				return name.endsWith(".pdf");
			}
		});
		for (String name : list) {
			System.out.println(name);
		}
	}

}

