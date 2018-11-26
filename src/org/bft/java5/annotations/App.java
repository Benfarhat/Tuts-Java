package org.bft.java5.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class App {

	public static void main(String[] args) {

		Demo myDemo = new Demo();
		AtomicInteger counter = new AtomicInteger(1);
		
		// Processing on class
		Class<? extends Demo> classe = myDemo.getClass(); 
		Annotation[] annotations = classe.getAnnotations();

		for (Annotation annotation : annotations)
		{
		    if (annotation instanceof Todo)
		    {
		    	Todo info_todo = (Todo) annotation;
		    	for (String description : info_todo.description()) {
			        System.out.println("Description " + counter.getAndIncrement() + " : " + description);
		    	}
		        System.out.println("Assignation : " + info_todo.assigneA());
		        System.out.println("Importance : " + info_todo.importance());
		        System.out.println("Date : " + info_todo.dateAssignation());
		    }
		}
		
		// Introspection / Processing on methods
		// we only need declaredMethods, no need to use getMethods whiich give inherited method (like wait, equals, toString)
	    for(Method m : classe.getDeclaredMethods()) {
	    	System.out.println("\n=======================");
	    	System.out.println("Method "+m.getName());
	    	System.out.println("=======================");
			annotations = m.getAnnotations();
			for (Annotation annotation : annotations)
			{
		    	Todo info_todo = (Todo) annotation;
		    	for (String description : info_todo.description()) {
			        System.out.println("\tDescription " + counter.getAndIncrement() + " : " + description);
		    	}
		        System.out.println("\tAssigned to : " + info_todo.assigneA());
		        System.out.println("\tImportance : " + info_todo.importance());
		        System.out.println("\tDate : " + info_todo.dateAssignation());
			}

	      }	
		

	}

}
