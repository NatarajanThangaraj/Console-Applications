package com.natarajanthangaraj.atm.dto;

public class CardDetails {
	private String ATMCardNumber;
	private Long PinNumber;
	public String getATMCardNumber() {
		return ATMCardNumber;
	}
	public void setATMCardNumber(String aTMCardNumber) {
		ATMCardNumber = aTMCardNumber;
	}
	public Long getPinNumber() {
		return PinNumber;
	}
	public void setPinNumber(Long pinNumber) {
		PinNumber = pinNumber;
	}
}
