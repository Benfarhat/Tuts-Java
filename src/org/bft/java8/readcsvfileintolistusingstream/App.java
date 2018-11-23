package org.bft.java8.readcsvfileintolistusingstream;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		try {

			String fileName = "src/org/bft/java8/readcsvfileintolistusingstream/people.csv";
			Path filePath = Paths.get(fileName);
			Stream stream = Files.lines(filePath);
			
			List<People> peoples = new ArrayList<People>();
			
			peoples = (List<People>) stream
					.filter(line -> ((String) line).contains("@"))
					.map(line -> {
						String []result = ((String) line).split(",");
						return new People(result[0],result[1],result[2],Integer.parseInt(result[3]),result[4],result[5],result[6]);
					})
					.collect(Collectors.toList());
			
			System.out.println("People list");
			for(People people : peoples) {
				System.out.println(people);
				System.out.println("Avatar: " + people.getAvatar());
			}
			
			stream.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
