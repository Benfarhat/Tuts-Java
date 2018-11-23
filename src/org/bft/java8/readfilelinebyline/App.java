package org.bft.java8.readfilelinebyline;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class App {

	public static void main(String[] args) throws Exception {
		
		try {
			String fileName = "src/org/bft/java8/readfilelinebyline/data.txt";
			Path filePath = Paths.get(fileName);
			
			// First way
			List<String> lines = Files.readAllLines(filePath);
			int nb = 1;
			for(String line : lines) {
				System.out.println("Line " + nb++ + ": " + line);
			}
			
			// Another one
			final AtomicInteger count = new AtomicInteger();
			Files.readAllLines(filePath)
			.stream()
			.forEach(line -> {
				System.out.println(count.getAndIncrement() + ": " +  line);
			});
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

