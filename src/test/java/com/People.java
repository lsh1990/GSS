package com;

class A {
	  private int value = 1;

	  public void setValue(int value) {
	    this.value = value;
	  }

	  public int getValue() {
	    return value;
	  }

	  public void getObject() {
	    System.out.println(this.getClass());
	  }
	}

	class B extends A {
	  private int value = 2;

	  public void setValue(int value) {
	    this.value = value;
	  }

	  public int getValue() {
	    return value;
	  }
	}

	public class People {

	  public static void main(String[] args) {
	    A a = new B();
	    a.getObject();

	    a.setValue(5);
	    System.out.println(a.getValue());
	  }
	}
