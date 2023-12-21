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
	private Long passengers;
	private String email;
	private Long mobileNumber;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getPassengers() {
		return passengers;
	}

	

	public void setPassengers(Long passengers2) {
		this.passengers=passengers2;
		
	}

	

	
}
