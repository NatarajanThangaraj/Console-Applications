package com.natarajanthangaraj.airlinereservationsystem.dto;

public class TicketDetails {
	private Flight flight;
	private Passenger passenger;
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	
	
}
