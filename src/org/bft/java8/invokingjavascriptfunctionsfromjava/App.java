package org.bft.java8.invokingjavascriptfunctionsfromjava;

import java.io.FileReader;
import java.util.List;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

public class App {

	public static void main(String[] args) {
		// For demo get scriptengine list
		ScriptEngineManager manager = new ScriptEngineManager();
		List<ScriptEngineFactory> factories = manager.getEngineFactories();
		for (ScriptEngineFactory factory : factories) {
			System.out.println("Name : " + factory.getEngineName());
			System.out.println("Version : " + factory.getEngineVersion());
			System.out.println("Language name : " + factory.getLanguageName());
			System.out.println("Language version : " + factory.getLanguageVersion());
			System.out.println("Extensions : " + factory.getExtensions());
			System.out.println("Mime types : " + factory.getMimeTypes());
			System.out.println("Names : " + factory.getNames()); 
			// nashorn, Nashorn, js, JS, JavaScript, javascript, ECMAScript, ecmascript
		}
		

		ScriptEngine se = new ScriptEngineManager().getEngineByName("ecmascript");
		
		System.out.println("\n=============Evaluating a script file===================\n");
		try {
			se.eval("print('Hello JavaScript...')");
			se.eval(new FileReader("src\\org\\bft\\java8\\invokingjavascriptfunctionsfromjava\\script.js"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n===============Script Variables=================\n");
		try {
			Bindings bindings = se.getBindings(ScriptContext.ENGINE_SCOPE);
			bindings.clear();
			bindings.put("compteur", 1); 
			
			se.eval("print(compteur)");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n===============Script context=================\n");
		try {
			Bindings bindings = se.getBindings(ScriptContext.ENGINE_SCOPE);
			bindings.clear();
			bindings.put("compteur", 1); 
			ScriptContext newContext = new SimpleScriptContext();
			// Let's call to the compteur variable in another context
			// -> ReferenceError will occcurs
			se.eval("print(compteur)", newContext);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n===============Invocable=================\n");
		try {
			Invocable i1 = (Invocable)se;
			Invocable i2 = (Invocable)se;

			i1.invokeFunction("fn1", "World");
			i2.invokeFunction("fn2", 3, 5);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	
	}

}
