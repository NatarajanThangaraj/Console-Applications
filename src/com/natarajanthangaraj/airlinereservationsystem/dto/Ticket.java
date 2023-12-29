package com.natarajanthangaraj.airlinereservationsystem.dto;

public class Ticket {
	private String ticketNumber;
	private String from;
	private String to;
	private String date;
	private String departTime;
	private String landingTime;
	private String firstName;
	private String lastName;
	private int passenger_Type;
	private int Passenger_Count;
	private String Gmail;
	private int mobileNumber;

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String string) {
		this.departTime = string;
	}

	public String getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}

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

	

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	

	public int getPassenger_Type() {
		return passenger_Type;
	}

	public void setPassenger_Type(int passenger_Type) {
		this.passenger_Type = passenger_Type;
	}

	public int getPassenger_Count() {
		return Passenger_Count;
	}

	public void setPassenger_Count(int passenger_Count) {
		Passenger_Count = passenger_Count;
	}

	public String getGmail() {
		return Gmail;
	}

	public void setGmail(String gmail) {
		Gmail = gmail;
	}

	

	
}
