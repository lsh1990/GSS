package com.basis.example.abstractAndInterface;

public class Dog extends Animal{
	
	private String name;

	

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(String name) {
		super();
		this.name = name;
	}



	@Override
	public void jiao() {
		System.out.println(name + "汪汪");
	}
	

}
