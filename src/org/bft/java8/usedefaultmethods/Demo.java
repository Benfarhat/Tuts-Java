package org.bft.java8.usedefaultmethods;

public class Demo implements Interface1, Interface2{


	@Override
	public void method2() {
		System.out.println("Method 2 of Interface2");
		
	}

	@Override
	public void method1(String str) {
		System.out.println("Method 1 of Interface1");
	}
	
	@Override
	public void log(String str) {
		System.out.println("Demo logging:: " + str);
		Interface1.super.log(str);
	}

}
