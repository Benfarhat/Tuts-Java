package org.bft.java7.trywithresources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) throws FileNotFoundException, IOException {

	    String content1 = "First content",
	    content2 = "Second content",
	    fileName = "src/org/bft/java7/trywithresources/data.txt",
	    fileName2 = "src/org/bft/java7/trywithresources/data2.txt";
	  
	    
	    // Before Java 7
	    FileOutputStream outputStream = null;
	    try {
		    outputStream = new FileOutputStream(fileName);
		    byte[] strToBytes = content1.getBytes();
		    outputStream.write(strToBytes);
	    } catch(IOException e) {
	    	System.out.println(e.getMessage());
	    } finally {
	    	outputStream.close();
	    }
	    
	    // When the light has come :)
	    // The resource must implement the AutoClosable interface to work with try-with-resources
	    try (FileOutputStream outputStream2 = new FileOutputStream(fileName2);) {
	    	byte[] strToBytes2 = content2.getBytes();
	    	outputStream2.write(strToBytes2);
	    }
	}
}
