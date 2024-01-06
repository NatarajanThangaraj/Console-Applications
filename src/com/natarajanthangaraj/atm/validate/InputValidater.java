package com.natarajanthangaraj.atm.validate;

import com.natarajanthangaraj.atm.dto.CardDetails;

public class InputValidater {

	public static boolean validateCardDetails(CardDetails carddetail) {
		long pinNumber = carddetail.getPinNumber();
		return (carddetail.getATMCardNumber().length() == 16 && (pinNumber < 9999 && pinNumber > 999));
	}

}
