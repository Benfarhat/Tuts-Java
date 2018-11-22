package org.bft.java8.countlambda;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		List<Product> products = new ArrayList<Product>();
		products.add(new Product("p1", "mobile 1", 1000, 2, "Manufacturer 1"));
		products.add(new Product("p2", "mobile 2", 800, 4, "Manufacturer 2"));
		products.add(new Product("p3", "mobile 3", 900, 5, "Manufacturer 1"));
		products.add(new Product("p4", "laptop 1", 950, 7, "Manufacturer 2"));
		products.add(new Product("p5", "laptop 2", 1025, 8, "Manufacturer 2"));
		products.add(new Product("p6", "laptop 3", 1005, 9, "Manufacturer 1"));
		

		System.out.println("*************");
		System.out.println("*   count   *");
		System.out.println("*************\n");
		
		long res = products.stream()
		.filter(x -> ((Product) x).getPrice()> 1000)
		.count();
		System.out.println("\t" + res);
	

	}

}
