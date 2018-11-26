package org.bft.java5.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Inherited
@Documented
// @target : ANNOTATION_TYPE / CONSTRUCTOR / LOCAL_VARIABLE / FIELD / METHOD / PACKAGE / PARAMETER / TYPE
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
// @Retention : SOURCE / CLASS / RUNTIME
@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
	public enum Importance {
		MINEURE, IMPORTANT, MAJEUR, CRITIQUE
	};
	Importance importance() default Importance.MINEURE;
	String[] description();
	String assigneA();
	String dateAssignation();
}


@Todo(importance = Todo.Importance.CRITIQUE, 
description = {"L'audit préconise la réecriture des tests unitaires", "Utiliser des mocks", "Ajouter les statistiques de couverture de code"}, 
assigneA = "lead dev", 
dateAssignation = "26/11/2018")
public class Demo {
	

	@Todo(importance = Todo.Importance.MINEURE, 
	description = {"description 1", "description 2", "description 3"}, 
	assigneA = "Mehdi", 
	dateAssignation = "26/11/2018")
	public void firstMethod() {
		// ...
	}

	@Todo(importance = Todo.Importance.CRITIQUE, 
	description = {"description 4", "description 5", "description 6"}, 
	assigneA = "Elyes", 
	dateAssignation = "26/11/2018")
	public void secondMethod() {
		// ...
	}
	
	@Todo(importance = Todo.Importance.IMPORTANT, 
	description = {"description 7", "description 8", "description 9"}, 
	assigneA = "Dorra", 
	dateAssignation = "26/11/2018")	
	public void anotherMethod() {
		// ...
	}	
	
	@Todo(importance = Todo.Importance.MAJEUR, 
	description = {"description 10", "description 11", "description 12"}, 
	assigneA = "Maya", 
	dateAssignation = "26/11/2018")	
	public void andTheLastOne() {
		// ...
	}

}
