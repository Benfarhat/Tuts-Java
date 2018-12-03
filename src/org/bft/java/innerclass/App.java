package org.bft.java.innerclass;

class OuterClass {
	private int val1 = 1;
	private int val2 = 2;
	static int staticvalue = 5;
	class InnerClass {
		private int val2 = 3;
		
		public void printValues() {
			System.out.println("Outer val1 : " + val1);
			System.out.println("Outer val2 : " + OuterClass.this.val2);
			System.out.println("Inner val1 : " + val2);
			System.out.println("Inner val1 : " + this.val2);
		}
	}
	
	public void printFromInnerClass() {
		final int val1 = 6;
		class MethodLocalInnerClass {
			public void print() {
				System.out.println("\nOuter prvate val1: " + val1);
				System.out.println("Inner final val1 in method: " + val1);
			}
		}
		MethodLocalInnerClass mlic = new MethodLocalInnerClass();
		mlic.print();
	}	
	
	static public void printFromStaticInnerClass() {
		StaticInnerClass sic = new StaticInnerClass();
		sic.printFromStaticInnerClass();
	}
	
	static class StaticInnerClass{
		void printFromStaticInnerClass() {
			System.out.println("\nFrom static Inner Class : " + staticvalue);
		}
	}
}

public class App {
	public static void main(String[] args) {
		// Inner class
		OuterClass.InnerClass demo1 = new OuterClass().new InnerClass();
		demo1.printValues();

		OuterClass demo2 = new OuterClass();
		demo2.printFromInnerClass();
		
		OuterClass.StaticInnerClass demo3 = new OuterClass.StaticInnerClass();
		demo3.printFromStaticInnerClass();
		
		OuterClass.printFromStaticInnerClass();
		
	}
}