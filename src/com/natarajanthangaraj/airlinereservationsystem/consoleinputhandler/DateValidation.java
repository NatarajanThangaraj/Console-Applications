package com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateValidation {
	LocalDateTime date;

	static LocalDateTime currentDate() {
		return LocalDateTime.now();
	}

	public  String isValidDateTime(String date) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate currentDate = LocalDate.now();
		while (true) {
			LocalDate userDate = LocalDate.parse(date, format);
			if (userDate.isEqual(currentDate) || userDate.isAfter(currentDate)) {
				return date;
			} else {
				System.err.println(".....The date is Expired......");
				System.out.print(" Enter correct Date : ");
			}
		}

	}

	public  boolean isValidDateTime(String date, String time) {
		LocalDateTime userInput = LocalDateTime.parse(date + " " + time,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		return currentDate().isAfter(userInput);
	}


		public  String getDateOfBirth(String date) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate currentDate = LocalDate.now();
			while (true) {
				LocalDate userDate = LocalDate.parse(date, format);
				if (userDate.isBefore(currentDate)) {
					return date;
				} else {
					System.err.println(".....The date is Expired......");
					System.out.print(" Enter correct Date : ");
				}
			}
	}

}
