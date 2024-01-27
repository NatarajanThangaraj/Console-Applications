package com.natarajanthangaraj.airlinereservationsystem.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
	private String flightNumber;
	private String from;
	private String to;
	private LocalTime departTime;
	private LocalTime landingTime;
	private LocalDate departDate;
	private Double economyPrice;
	private Double businessPrice;
	private int economySeats;
	private int businessSeats;
	private String passengerType;
	private int passengerCount;
	private String category;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
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

	public int getEconomySeats() {
		return economySeats;
	}

	public void setEconomySeats(int long1) {
		this.economySeats = long1;
	}

	public int getBusinessSeats() {
		return businessSeats;
	}

	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}

	public Double getEconomyPrice() {
		return economyPrice;
	}

	public void setEconomyPrice(Double economyPrice) {
		this.economyPrice = economyPrice;
	}

	public Double getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(Double businessPrice) {
		this.businessPrice = businessPrice;
	}

	public LocalTime getDepartTime() {
		return departTime;
	}

	public void setDepartTime(LocalTime departTime) {
		this.departTime = departTime;
	}

	public LocalTime getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(LocalTime landingTime) {
		this.landingTime = landingTime;
	}

	public LocalDate getDepartDate() {
		return departDate;
	}

	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



}
