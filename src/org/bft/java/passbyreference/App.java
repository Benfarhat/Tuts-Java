package org.bft.java.passbyreference;

import java.awt.Point;

public class App {
	static int value = 0;
	static Point p = new Point(4, 6); 
	public static void main(String[] args) {
		// Pass by value (by default primitive are passed by value)
		System.out.println("Pass parameter by value");
		System.out.println("=======================");
		System.out.println("Value before process: " + value);
		process(value);
		System.out.println("Value after process: " + value);
		
		// Force parameter pass by value (by default primitive are passed by value)
		System.out.println("\nForce parameter pass by value");
		System.out.println("=============================");
		System.out.println("Value before process: " + value);
		processForceByReference(value);
		System.out.println("Value after process: " + value);

		// Pass by reference (by default object are passed by reference)
		System.out.println("\nPass parameter by reference");
		System.out.println("===========================");
		System.out.println("Point x,y values before process: " + p.toString());
		process(p);
		System.out.println("Point x,y values after process: " + p.toString());
	}
	
	static void process(int value) {
		value++;
		System.out.println("Value inside process: " + value);
	}
	
	static void processForceByReference(int $value) {
		value++;
		System.out.println("Value inside process: " + value);
	}
	
	static void process(Point p) {
		p.setLocation(2, 3);
		System.out.println("Point x,y values inside process: " + p.toString());
	}
}

