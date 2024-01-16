package com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateValidation {
	LocalDateTime date ; 
 static Scanner scan=new Scanner(System.in);

	static LocalDateTime currentDate() {
		return LocalDateTime.now();
	}


	public static String isValidDateTime() {
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate currentDate = LocalDate.now();
		String userInput;
		while(true) {
			userInput=getDate();
			 LocalDate userDate = LocalDate.parse(userInput, format);
			 if( userDate.isEqual(currentDate)||userDate.isAfter(currentDate)) {
			 return userInput;
			 }else {
				 System.err.println(".....The date is Expired......");
				 System.out.print(" Enter correct Date : ");
			 }
		}
		
		

	}
	public static boolean isValidDateTime(String date,String time) {
		           LocalDateTime userInput= LocalDateTime.parse(date + " " + time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		           return currentDate().isAfter(userInput);
		        }
	static String getDate() {
		while(true) {
			try {
		  String date =scan.next();
		  return date;
			}catch(Exception e) {
				System.err.println("Invalid Input !!! ");
				System.out.print("Enter the Valid Input : ");
			}
		}
	   }
		    
	}
   
	

