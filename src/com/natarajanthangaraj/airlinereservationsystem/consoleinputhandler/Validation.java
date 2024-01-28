package com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static boolean isValidGmailAddress(String email) {
        String gmailPattern = "^[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*@gmail\\.com$";
        Pattern pattern = Pattern.compile(gmailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
	public static boolean isValidMobileNumber(String mobileNumber) {
		String mobileNumberPattern = "^[0-9]{10}$"; 
        Pattern pattern = Pattern.compile(mobileNumberPattern);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }

}
