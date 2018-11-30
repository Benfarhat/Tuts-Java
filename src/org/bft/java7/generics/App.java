package org.bft.java7.generics;

import java.util.ArrayList;
import java.util.List;

import org.bft.java8.foreach.Product;

class MyClass<T> {
    // T stands for "Type"
    private T t;

    /**
	 * @param t
	 */
	public MyClass(T t) {
		super();
		this.t = t;
	}
	public void set(T t) { this.t = t; }
    public T get() { return t; }
}

class MyClassExt<T> extends MyClass<T>{
    // T stands for "Type"
    private T t;

    /**
	 * @param t
	 */
	public MyClassExt(T t) {
		super(t);
		this.t = t;
	}
	public void set(T t) { this.t = t; }
    public T get() { return t; }
}

class Pair<K, V>{
	private K key;
	private V value;
	/**
	 * @param key
	 * @param value
	 */
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pair [key=" + key + ", value=" + value + "]";
	}
	
}

class SubProduct extends Product{
	private String id;
	private String name;
	private long price;
	private int quantity;
	private String manufacturer;

	public SubProduct() {
	}

	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param quantity
	 * @param manufacturer
	 */
	public SubProduct(String id, String name, long price, int quantity, String manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.manufacturer = manufacturer;
	}
	@Override
	public String toString() {
		return "SubProduct [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", manufacturer=" + manufacturer + "]";
	}
}


class NoSubProduct{
	private String id;
	private String name;
	private long price;
	private int quantity;
	private String manufacturer;

	public NoSubProduct() {
	}

	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param quantity
	 * @param manufacturer
	 */
	public NoSubProduct(String id, String name, long price, int quantity, String manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.manufacturer = manufacturer;
	}
	@Override
	public String toString() {
		return "SubProduct [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", manufacturer=" + manufacturer + "]";
	}
}

public class App {

	public static void main(String[] args) {

		// No more casts (java 5)
		
		List list1 = new ArrayList();
		list1.add("hello");
		String s1 = (String) list1.get(0);
		System.out.println(s1);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("hello");
		String s2 = list2.get(0);
		System.out.println(s2);
		
		// Using Diamond Operator (java 7)
		
		List<String> list3 = new ArrayList<>();
		list3.add("hello");
		String s3 = list3.get(0);
		System.out.println(s3);
		
		// Using Generic class
		
		MyClass<String> mc1 = new MyClass<String>("hello");
		System.out.println(mc1.get());		
		MyClass<Integer> mc2 = new MyClass<Integer>(123);
		System.out.println(mc2.get());		
		MyClass<Boolean> mc3 = new MyClass<Boolean>(true);
		System.out.println(mc3.get());
		
		Pair<Integer, String> p1 = new Pair<>(1, "JavaEE");
		Pair<Integer, String> p2 = new Pair<>(2, "Spring");
		Pair<Integer, String> p3 = new Pair<>(1, "JavaEE");
		
		System.out.println("Comparing " + p1 + " and " + p2);
		System.out.println(compare(p1,p2));	
		
		System.out.println("Comparing " + p1 + " and " + p3);
		System.out.println(compare(p1,p3));
		
		displayProduct(new Product("product P1", "Lorem", 1000, 2, "Ipsum"));
		displayProduct(new SubProduct("subproduct p1", "Lorem", 1000, 2, "Ipsum"));
		displayProduct(new NoSubProduct("nosubproduct p1", "Lorem", 1000, 2, "Ipsum"));
	}
	
	// Generic Methods
	
	public static <K,V>boolean compare(Pair<K,V> p1, Pair<K, V> p2){
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}	
	
	// Bounded type parameters
	
	public static <U extends MyClass<U>>void display(U inst){
		System.out.println(inst);;
	}

	public static <U extends Product> void displayProduct(U p) {
		System.out.println(p);
	}
	
	public static void displayProduct(Object p) {
		System.out.println("Not implemented by the first displayProduct method (Parameter not a Product or Product children object)");
	}
}
