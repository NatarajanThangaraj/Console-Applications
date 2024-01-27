package com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeValidation {
static Scanner scan=new Scanner(System.in);
	public static LocalTime timeValidation() {
		while(true) {
			String time=scan.next();
		String timeRegex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		Pattern pattern = Pattern.compile(timeRegex);
		Matcher matcher = pattern.matcher(time);
		
		if(matcher.matches()) {
			DateTimeFormatter format=DateTimeFormatter.ofPattern("HH:mm");
			LocalTime localTime = LocalTime.parse(time,format);
		return localTime;
		}else {
			System.out.print(" Enter valid Time : ");
		}
		}
	}
}
