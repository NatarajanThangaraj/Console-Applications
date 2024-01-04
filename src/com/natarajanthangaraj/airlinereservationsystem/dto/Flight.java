package com.natarajanthangaraj.airlinereservationsystem.dto;

public class Flight {
	private String flightNumber;
	private String from;
	private String to;
	private String departTime;
	private String landingTime;
	private String economyPrice;
	private String businessPrice;
	private Long economySeats;
	private int businessSeats;

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

	public Long getEconomySeats() {
		return economySeats;
	}

	public void setEconomySeats(Long long1) {
		this.economySeats = long1;
	}

	public int getBusinessSeats() {
		return businessSeats;
	}

	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}

	public String getEconomyPrice() {
		return economyPrice;
	}

	public void setEconomyPrice(String economyPrice) {
		this.economyPrice = economyPrice;
	}

	public String getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(String businessPrice) {
		this.businessPrice = businessPrice;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}

}
