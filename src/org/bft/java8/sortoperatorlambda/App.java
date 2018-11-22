package org.bft.java8.sortoperatorlambda;

import java.util.ArrayList;
import java.util.List;

import org.bft.java8.likeoperatorlambda.Product;

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
		System.out.println("Ascending order");
		System.out.println("************");
		
		products.stream()
		.sorted( (p1, p2) -> (int) (((Product) p1).getPrice() - ((Product) p2).getPrice()) )
		.forEach(x -> {System.out.println(x);});


		System.out.println("************");
		System.out.println("Descending order");
		System.out.println("************");
		
		products.stream()
		.sorted( (p1, p2) -> (int) (((Product) p2).getPrice() - ((Product) p1).getPrice()) )
		.forEach(x -> {System.out.println(x);});

		


	}

}
