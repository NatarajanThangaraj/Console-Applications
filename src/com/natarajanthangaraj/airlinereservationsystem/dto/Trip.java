package com.natarajanthangaraj.airlinereservationsystem.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Trip {
	private String from;
	private String to;
	private LocalDate date;
	private LocalTime time;
	private int numberOfPassenger;
	private String category;
// private String flightNumber;
// private List<Passenger>passengerList;
//public String getFlightNumber() {
//	return flightNumber;
//}
//public void setFlightNumber(String flightNumber) {
//	this.flightNumber = flightNumber;
//}
//public List<Passenger> getPassengerList() {
//	return passengerList;
//}
//public void setPassengerList(List<Passenger> passengerList) {
//	this.passengerList = passengerList;
//}
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public int getNumberOfPassenger() {
		return numberOfPassenger;
	}
	public void setNumberOfPassenger(int numberOfPassenger) {
		this.numberOfPassenger = numberOfPassenger;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
