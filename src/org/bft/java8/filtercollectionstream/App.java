package org.bft.java8.filtercollectionstream;

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
		System.out.println("P1 and P3");
		System.out.println("************");
		
		products.stream()
		.filter(x -> ((Product) x).getId().equalsIgnoreCase("p1") || ((Product) x).getId().equalsIgnoreCase("p3") )
		.forEach(x -> {System.out.println(x);});
		

		System.out.println("************");
		System.out.println("Price between 910 and 1001");
		System.out.println("************");
			
		products.stream()
		.filter(x -> ((Product) x).getPrice() > 910 && ((Product) x).getPrice() < 1001 )
		.forEach(x -> {System.out.println(x);});
	
	

	}

}
