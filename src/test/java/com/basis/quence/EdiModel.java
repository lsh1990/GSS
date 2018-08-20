package com.basis.quence;

public class EdiModel {
	
	private String barcode;
	private String name;
	private String age;
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
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
	@Override
	public String toString() {
		return "EdiModel [barcode=" + barcode + ", name=" + name + ", age=" + age + "]";
	}

}
