package com.natarajanthangaraj.airlinereservationsystem.flight;

public class Flight {
	private String flightNumber;
	private String from;
	private String to;
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
		businessSeats = businessSeats;
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

}
