package org.bft.java8.parralelstreamstoreadfileandtotallywordcounts;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class App {

	public static void main(String[] args) throws Exception {
		textWordCount("src/org/bft/java8/parralelstreamstoreadfileandtotallywordcounts/data.txt");
	}
	
	private static void textWordCount(String fileName) throws Exception {
		long start = Instant.now().toEpochMilli();
		int limitWord = 20;
		ConcurrentHashMap wordCounts = new ConcurrentHashMap<>();
		System.out.println("Reading " + fileName + " ...");
		
		Path filePath = Paths.get(fileName);
		Files.readAllLines(filePath)
			.parallelStream()
			.map(line -> line.split("\\s+"))
			.flatMap(Arrays::stream)
			.parallel()
			.filter(w -> w.matches("\\w+"))
			.map(String::toLowerCase)
			.forEach(word -> {
				if (!wordCounts.containsKey(word))
					wordCounts.put(word, new LongAdder());
				((LongAdder) wordCounts.get(word)).increment();
			});
		
		wordCounts
			.keySet()
			.stream()
			.map(key -> String.format("%-10d %s", ((LongAdder) wordCounts.get(key)).intValue(), key))
			.sorted((prev, next) -> Integer.compare(
					Integer.parseInt( ((String) next).split("\\s+")[0] ), 
					Integer.parseInt( ((String) prev).split("\\s+")[0] )
					))
			.limit(limitWord)
			.forEach(t -> System.out.println("\t" + t));
		long end = Instant.now().toEpochMilli();
		System.out.println(String.format("\tCompleted in %d milliseconds", (end - start)));
					
	}
}

