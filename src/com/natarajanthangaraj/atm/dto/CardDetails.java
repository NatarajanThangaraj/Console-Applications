package com.natarajanthangaraj.atm.dto;

public class CardDetails {
	private String atmCardNumber;
	private long pinNumber;
	private String accountNumber;
	private Double amount;

	public String getATMCardNumber() {
		return atmCardNumber;
	}

	public void setATMCardNumber(String aTMCardNumber) {
		atmCardNumber = aTMCardNumber;
	}

	public long getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(long pin) {
		 pinNumber=pin;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setAmount(Double amount) {
		this.amount=amount;
	}
	public Double getAmount() {
		return amount;
	}
}
