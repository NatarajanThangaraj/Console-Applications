package com.natarajanthangaraj.airlinereservationsystem.dto;

import java.time.LocalDate;

public class Passenger {
	private String firstName;
	private String lastName;
	private String passengerType;
	private LocalDate dateOfBirth;
	private String gMailAddress;
	private String mobileNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getgMailAddress() {
		return gMailAddress;
	}

	public void setgMailAddress(String gMailAddress) {
		this.gMailAddress = gMailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	
}
