package com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateValidation {
	LocalDateTime date ; 


	static LocalDateTime currentDate() {
		return LocalDateTime.now();
	}


	public static boolean isValidDate(String next) {
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate userDate = LocalDate.parse(next, format);
		 LocalDate currentDate = LocalDate.now();
		return userDate.isBefore(currentDate);
	}
	
}
