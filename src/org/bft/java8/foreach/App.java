package org.bft.java8.foreach;

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
		
		System.out.println("Product List");
		System.out.println("************");
		
		products.forEach(product -> {
			System.out.println(product);
			System.out.println("==========================");
		});

	}

}
