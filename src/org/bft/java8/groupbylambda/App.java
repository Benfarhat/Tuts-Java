package org.bft.java8.groupbylambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
		System.out.println("* Group by  *");
		System.out.println("*************\n");
		
		
		Map<String, Long> group = products.stream()
				.collect(Collectors.groupingBy(Product::getManufacturer, Collectors.counting()));
		
		System.out.println(group);

		System.out.println("*************");
		System.out.println("* Details  *");
		System.out.println("*************\n");	
		
		for(Entry<String, Long> entry : group.entrySet()) {
			
			System.out.println("key: " + entry.getKey());
			System.out.println("value : " + entry.getValue());

		}
		

		System.out.println("*************");
		System.out.println("* Group by & Summing quantity  *");
		System.out.println("*************\n");
		
		
		Map<String, Integer> groupSumming = products.stream()
				.collect(Collectors.groupingBy(Product::getManufacturer, Collectors.summingInt(Product::getQuantity)));
		
		System.out.println(groupSumming);

		System.out.println("*************");
		System.out.println("* Details  *");
		System.out.println("*************\n");	
		
		for(Entry<String, Integer> entry : groupSumming.entrySet()) {
			
			System.out.println("key: " + entry.getKey());
			System.out.println("value : " + entry.getValue());

		}
		
			

	}

}
