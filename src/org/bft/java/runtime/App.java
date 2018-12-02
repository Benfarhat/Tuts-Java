package org.bft.java.runtime;

class People {
	String firstName, lastName;
	int yearBirth;
	public People(String firstName, String lastName, int yearBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBirth = yearBirth;
	}
}
public class App {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime(); 

		People ja = new People("John", "Doe", 1970);
		People jb = new People("Jane", "Doe", 1980);
		
		System.out.println ("Processors : " + r.availableProcessors());
		System.out.println ("Total : " + r.totalMemory());
		System.out.println ("Max : " + r.maxMemory());
		System.out.println ("Free : " + r.freeMemory());
		 
		ja = null;
		jb = null;
	
		r.gc(); 
		System.out.println ("Free : " + r.freeMemory());		 

	}
	
	
}

