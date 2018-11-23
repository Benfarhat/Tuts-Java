package org.bft.java8.localdate;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class App {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println("Current Date: " + today);

		System.out.println("After 1 month : " + today.plusMonths(1));
		System.out.println("After 100 days : " + today.plusDays(100));
		
		System.out.println("The period between 1983/01/01 (ARPANET switch from NCP to TCP/IP): " + (LocalDate.of(1983, 1, 1)).until(today));
		
		LocalDate firstDay_2019 = LocalDate.of(2019, Month.JANUARY, 1);
		System.out.println("First date of 2019: " + firstDay_2019);
		
		LocalDate todayMontreal = LocalDate.now(ZoneId.of("America/Montreal"));
		System.out.println("Current date in montreal: " + todayMontreal);
		
		LocalDate todayJapan = LocalDate.now(ZoneId.of("Japan"));
		System.out.println("Current date in japan: " + todayJapan);
		
		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println("365th day from base date: " + dateFromBase);
		
		LocalDate hundredDay2019 = LocalDate.ofYearDay(2019, 100);
		System.out.println("100th day of 2019: " + hundredDay2019);
		
		System.out.println("Day of the week is : " + hundredDay2019.getDayOfWeek());
		
	}

}
