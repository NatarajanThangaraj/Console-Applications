package com.natarajanthangaraj.unReservedTicketBookingApplication.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidation {
	public static boolean isValidMail(String gMailAddress) {

		String gmailPattern = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";

		Pattern pattern = Pattern.compile(gmailPattern);
		Matcher matcher = pattern.matcher(gMailAddress);

		return matcher.matches();
	}
	
}
