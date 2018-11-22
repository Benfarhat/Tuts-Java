package org.bft.java8.limitoperatorlambda;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		List products = new ArrayList();
		products.add(new Product("p1", "mobile 1", 1000, 2, "Manufacturer 1"));
		products.add(new Product("p2", "mobile 2", 800, 4, "Manufacturer 2"));
		products.add(new Product("p3", "mobile 3", 900, 5, "Manufacturer 1"));
		products.add(new Product("p4", "laptop 1", 950, 7, "Manufacturer 2"));
		products.add(new Product("p5", "laptop 2", 1025, 8, "Manufacturer 2"));
		products.add(new Product("p6", "laptop 3", 1005, 9, "Manufacturer 1"));
		
		System.out.println("************");
		System.out.println("limit 2");
		System.out.println("************");
		
		products.stream()
		.limit(2)
		.forEach(x -> {System.out.println(x);});

		System.out.println("************");
		System.out.println("limit 5");
		System.out.println("************");
		
		products.stream()
		.limit(5)
		.forEach(x -> {System.out.println(x);});
		


	}

}
