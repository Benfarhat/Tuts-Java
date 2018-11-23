package org.bft.java8.writetofilewithfileswriteorbufferedwriter;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) throws Exception {
		
		String fileName1 = "src/org/bft/java8/writetofilewithfileswriteorbufferedwriter/data-fileswrite-" + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE) + ".txt";
		String fileName2 = "src/org/bft/java8/writetofilewithfileswriteorbufferedwriter/data-bufferedwriter-" + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE) + ".txt";
		// generate content
		Stream<String> stream = Stream.generate(() -> 
			Double.toString(Math.random() * 1000)
		).limit(30);
		String content = stream.collect(Collectors.joining("\n"));
		
		// With Files.write
		try {
			Files.write(Paths.get(fileName1), content.getBytes(), StandardOpenOption.CREATE);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
		// With Bufferedwriter
		try {
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName2));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

