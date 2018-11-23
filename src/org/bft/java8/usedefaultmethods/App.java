package org.bft.java8.usedefaultmethods;

public class App {

	public static void main(String[] args) {
		Interface1 interface1 = new Demo();
		interface1.method1("ABC");
		interface1.log("My log 1");
		
		Interface2 interface2 = new Demo();
		interface2.method2();
		interface2.log("My log 2");
	}

}
