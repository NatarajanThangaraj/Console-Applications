package com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler;

import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeValidation {

	public static boolean timeValidation(String time) {

		String timeRegex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		Pattern pattern = Pattern.compile(timeRegex);
		Matcher matcher = pattern.matcher(time);	
			return matcher.matches();
		
		
	}

	public static LocalTime timeFormat(String time) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime localTime = LocalTime.parse(time, format);
		return localTime;
	}
}
