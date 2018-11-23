package org.bft.java8.recursivelyworkingdirectory;

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
import java.util.concurrent.atomic.AtomicInteger;

public class App {

	public static void main(String[] args) {
		try {
			String path = ".\\src";
			Path startDir = Paths.get(path);
			String pattern = "*.{java,txt,xml}";
			FileSystem filesystem = FileSystems.getDefault();
			// @see What is a glob: https://docs.oracle.com/javase/tutorial/essential/io/fileOps.html#glob
			PathMatcher pathMatcher = filesystem.getPathMatcher("glob:" + pattern);
			FileVisitor fileVisitor = new SimpleFileVisitor() {
				AtomicInteger counter = new AtomicInteger(1);
				@Override
				public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
					System.out.println("\n" + dir + " :");
					return FileVisitResult.CONTINUE;
				}
				@Override
				public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
					Path name = ((Path) file).getFileName();
					if (pathMatcher.matches(name)) {
						System.out.println("\t" + counter.getAndIncrement() + ": " + name + "\t" + attrs.size() + "\t" + attrs.creationTime());
					}
					return FileVisitResult.CONTINUE;
				}
			};
			Files.walkFileTree(startDir, fileVisitor);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
