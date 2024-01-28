package com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateValidation {
	LocalDateTime date;
	static LocalDateTime currentDate() {
		return LocalDateTime.now();
	}

	public static boolean isValidDate(String date) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate currentDate = LocalDate.now();
			LocalDate userDate = LocalDate.parse(date, format);
			if (userDate.isEqual(currentDate) || userDate.isAfter(currentDate)) {
				return true;
			} 
			return false;
		}

	

	public  boolean isValidDateTime(String date, String time) {
		LocalDateTime userInput = LocalDateTime.parse(date + " " + time,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		return currentDate().isAfter(userInput);
	}


		public static  boolean getDateOfBirth(String date) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate currentDate = LocalDate.now();
				LocalDate userDate = LocalDate.parse(date, format);
				if (userDate.isBefore(currentDate)) {
					return true;
				} 
				return false;
			}
	    public static LocalDate dateFormat(String date) {
	    	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    	LocalDate userDate = LocalDate.parse(date, format);
	    	return userDate;
	    }

}
