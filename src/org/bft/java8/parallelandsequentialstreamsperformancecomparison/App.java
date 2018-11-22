package org.bft.java8.parallelandsequentialstreamsperformancecomparison;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {

		List<Product> products = new ArrayList<Product>();
		products.add(new Product("p1", "mobile 1", 1000, 2, "Manufacturer 1"));
		products.add(new Product("p2", "mobile 2", 800, 4, "Manufacturer 2"));
		products.add(new Product("p3", "mobile 3", 900, 5, "Manufacturer 1"));
		products.add(new Product("p4", "laptop 1", 950, 7, "Manufacturer 2"));
		products.add(new Product("p5", "laptop 2", 1025, 8, "Manufacturer 2"));
		products.add(new Product("p6", "laptop 3", 1005, 9, "Manufacturer 1"));
		
		// Sequential
		long t1 = System.currentTimeMillis();
		System.out.println("Sequential Stream count: " +
				products.stream().filter(e -> ((Product) e).getPrice() > 900).count()
				);
		long t2 = System.currentTimeMillis();
		System.out.println("Sequential stream time taken: " + (t2 - t1) + "ms");
		
		// Parallel
		t1 = System.currentTimeMillis();
		System.out.println("Parallel Stream count: " +
				products.parallelStream().filter(e -> ((Product) e).getPrice() > 900).count()
				);
		t2 = System.currentTimeMillis();
		System.out.println("Parallel stream time taken: " + (t2 - t1) + "ms");
		
		System.out.println("Another comparison ----------");
		
		long parallelTime = 0;
		long sequentialTime = 0;
		long time;
		BigDecimal sum;
		int occurence = 5;
		
		for (int i = 0; i <= occurence; i++) {
			time = System.currentTimeMillis();
			sum = Stream.generate(() -> new BigDecimal(Math.random() * 10000)).limit(1000000).parallel().map(b -> b.multiply(BigDecimal.TEN)).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
			
			if (i > 0) {
				parallelTime += (System.currentTimeMillis() - time);
			}

			sum = Stream.generate(() -> new BigDecimal(Math.random() * 10000)).limit(1000000).sequential().map(b -> b.multiply(BigDecimal.TEN)).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
			
			if (i > 0) {
				sequentialTime += (System.currentTimeMillis() - time);
			}
			
			
		}
		
		System.out.println("Average time for parallel calc: " + (parallelTime / occurence) + "ms");
		System.out.println("Average time for sequential calc: " + (sequentialTime / occurence) + "ms");

	}

}
