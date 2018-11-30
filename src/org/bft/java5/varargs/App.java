package org.bft.java5.varargs;

public class App {
	static void display1(Object... values){
		System.out.println("display1 method invoked:");
		for(Object val :values){
			System.out.println("\t" + val);
		}
	}	
	static void display2(int num, Object... values){
		System.out.println("display2 method invoked:");
		System.out.println("\t" + num);
		for(Object val :values){
			System.out.println("\t" + val);
		}
	}
	/*
	void method(String... a, int... b){}//Compile time error  
	void method(int... a, String b){}//Compile time error
	*/
	public static void main(String[] args) {
		display1();
		display1("Lorem");
		display1("Lorem", "Ipsum", 2, true);

		display2(1);
		display2(2, "Lorem");
		display2(3, "Lorem", "Ipsum", 2, true);
	}
	
	
}
