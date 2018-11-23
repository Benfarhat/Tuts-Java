package org.bft.java8.usestaticmethods;

public class Interface1Impl implements Interface1{

	public boolean isNull(String str) {
		System.out.println("Impl Null Check");
		return str == null ? true : false;
	}

}
