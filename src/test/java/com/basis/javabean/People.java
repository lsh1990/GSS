package com.basis.javabean;


/**
 * @Description: 内省、javaBean
 * @author-lsh
 * @date 2018年3月14日 下午8:15:55
 */
public class People {

	private String name;
	
	private String age;
	
	private String phon;
	
	
	public People(String name, String age, String phon) {
		super();
		this.name = name;
		this.age = age;
		this.phon = phon;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhon() {
		return phon;
	}
	public void setPhon(String phon) {
		this.phon = phon;
	}
	
	
}
