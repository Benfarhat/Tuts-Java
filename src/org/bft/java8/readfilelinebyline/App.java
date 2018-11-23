package org.bft.java8.readfilelinebyline;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) throws Exception {
		
		try {
			String fileName = "src/org/bft/java8/readfilelinebyline/data.txt";
			Path filePath = Paths.get(fileName);
			
			// First way
			List<String> lines = Files.readAllLines(filePath);
			int nb = 1;
			for(String line : lines) {
				System.out.println("A Line " + nb++ + ": " + line);
			}
			
			// Another one
			final AtomicInteger count = new AtomicInteger();
			Files.readAllLines(filePath)
			.stream()
			.forEach(line -> {
				System.out.println("B Line " + count.getAndIncrement() + ": " +  line);
			});
			
			// Third way
			count.set(0);
			Stream stream = Files.lines(filePath);
			
			stream.forEach(line -> {
				System.out.println("C Line " + count.getAndIncrement() + ": " +  line);
			});
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

