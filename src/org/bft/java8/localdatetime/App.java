package org.bft.java8.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class App {

	public static void main(String[] args) {
		LocalDateTime today = LocalDateTime.now();
		System.out.println("Current Datetime: " + today);
		
		today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("Current Datetime: " + today);
		
		LocalDateTime specificDate = LocalDateTime.of(2019, Month.JANUARY, 1, 9, 30, 30);
		System.out.println("Specific Date: " + specificDate);
		
		LocalDateTime todayMontreal = LocalDateTime.now(ZoneId.of("America/Montreal"));
		System.out.println("Montreal date: " + todayMontreal);
		
		LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(100000, 0, ZoneOffset.UTC);
		System.out.println("100000th second time from 01/01/1970: " + dateFromBase);

		System.out.println("Year from 1983/01/01 (ARPANET switch from NCP to TCP/IP): " + (LocalDateTime.of(1983, 1, 1, 0, 0, 0)).until(today, ChronoUnit.YEARS));

	
		
	}

}
