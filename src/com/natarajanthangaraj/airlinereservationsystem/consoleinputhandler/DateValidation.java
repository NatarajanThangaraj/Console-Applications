package com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateValidation {
	LocalDateTime date;
	static Scanner scan=new Scanner(System.in);
	static LocalDateTime currentDate() {
		return LocalDateTime.now();
	}

	public static LocalDate isValidDateTime() {
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate currentDate = LocalDate.now();
		while (true) {
			String date=scan.next();
			LocalDate userDate = LocalDate.parse(date, format);
			if (userDate.isEqual(currentDate) || userDate.isAfter(currentDate)) {
				
				return userDate;
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


		public static  LocalDate getDateOfBirth() {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate currentDate = LocalDate.now();
			while (true) {
				String date=scan.next();
				LocalDate userDate = LocalDate.parse(date, format);
				if (userDate.isBefore(currentDate)) {
					return userDate;
				} else {
					System.err.println(".....The date is Expired......");
					System.out.print(" Enter correct Date : ");
				}
			}
	}

}
