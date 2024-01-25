package com.natarajanthangaraj.airlinereservationsystem.dto;

public class TicketDetails {
	private Flight flight;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gMail;
	private String mobileNumber;
	
	
	public String getFirst_Name() {
		return firstName;
	}
	public void setFirst_Name(String first_Name) {
		firstName = first_Name;
	}
	public String getLast_Name() {
		return lastName;
	}
	public void setLast_Name(String last_Name) {
		lastName = last_Name;
	}
	public String getDate_Of_Birth() {
		return dateOfBirth;
	}
	public void setDate_Of_Birth(String date_Of_Birth) {
		dateOfBirth = date_Of_Birth;
	}
	public String getMobile_Number() {
		return mobileNumber;
	}
	public void setMobile_Number(String mobile_Number) {
		mobileNumber = mobile_Number;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public String getgMail() {
		return gMail;
	}
	public void setgMail(String gMail) {
		this.gMail = gMail;
	}
	
	
	
}
