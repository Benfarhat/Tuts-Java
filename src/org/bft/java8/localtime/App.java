package org.bft.java8.localtime;

import java.time.LocalTime;
import java.time.ZoneId;

public class App {

	public static void main(String[] args) {
		LocalTime time = LocalTime.now();
		System.out.println("Current time: " + time);
		System.out.println("After 4 hours: " + time.plusHours(4));
		
		LocalTime specificTime = LocalTime.of(13,10,5,8);
		System.out.println("Specific time: " + specificTime);

		LocalTime timeMontreal = LocalTime.now(ZoneId.of("America/Montreal"));
		System.out.println("Time in Montreal is: " + timeMontreal);
		
		LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
		System.out.println("10000th second time: " + specificSecondTime);
		
		System.out.println("Midnight time: " + LocalTime.MIDNIGHT);
		System.out.println("Mid Day time: " + LocalTime.NOON);
		
	}

}
