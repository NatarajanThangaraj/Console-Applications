package com.natarajanthangaraj.airlinereservationsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utility {
	static LocalDateTime dateandtime=LocalDateTime.now();
	static DateTimeFormatter dateformat= DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static DateTimeFormatter timeformat= DateTimeFormatter.ofPattern("HH:mm");

	public static String getPassengerType(int select) {
		if(select==1) {
			return "Adult";
		}else if (select==2) {
			return "Children";
		}
		else if (select==3) {
			return "Infants";
		}else {
			return null;
		}
		
		}
		
	public static String getCategory(int select) {
		if(select==1) {
			return "Economy";
		}else if (select==2) {
			return "Business";
		}else {
			return null;
		}
		}
		
	public static String currentDate() {
		return dateandtime.format(dateformat);
	}
	public static String currentTime() {
		return dateandtime.format(timeformat);
	}
	
    public static String flightNumberGenerator() {
    	Random ran=new Random();
    	int randomNumber=ran.nextInt(900)+100;
    	return "AI-"+randomNumber;
    }
	
}
