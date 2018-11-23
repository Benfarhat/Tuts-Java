package org.bft.java8.usedefaultmethods;

public interface Interface2 {
	void method2();
	
	default void log(String str) {
		System.out.println("Interface0 logging::" + str);
	}

}

