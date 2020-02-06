package com.scp.java.endtoend;

public class Demo {

	static public void calcv1(int []nums) {
		System.out.println("Array..1.2");
	}
	
	static public void calcv2(int a,int b) {
		System.out.println("normal");
	}
	

	static public void calcv3(int 	...nums) {//varargs-- zero or more
		System.out.println("varargs...1.5");
	}


	public static void main(String[] args) {
		int v1[] = {10,20,3,4,5};
		calcv3(1);
	}
	
}
