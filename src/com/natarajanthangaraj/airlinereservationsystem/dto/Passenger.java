package com.natarajanthangaraj.airlinereservationsystem.dto;

import java.util.Date;

public class Passenger {
	private String firstName;
	private String lastName;
	private String email;
	private String dob;
	private String countryCode;
	private Long mobileNumber;
	private Long Passengers;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPassengers() {
		return Passengers;
	}

	public void setPassengers(Long passengers) {
		Passengers = passengers;
	}

	
}
