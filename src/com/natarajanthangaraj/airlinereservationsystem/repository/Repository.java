package com.natarajanthangaraj.airlinereservationsystem.repository;

import java.util.ArrayList;

import java.util.List;
import com.natarajanthangaraj.airlinereservationsystem.dto.Flight;
import com.natarajanthangaraj.airlinereservationsystem.dto.Passenger;
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;
import com.natarajanthangaraj.airlinereservationsystem.dto.Trip;
import com.natarajanthangaraj.airlinereservationsystem.login.repository.JDBCConnection;

public class Repository {
	List<Flight> allFlights = new ArrayList<>();
	private static Repository repo;

	private Repository() {
	};

	public static Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
		}
		return repo;
	}

	public List<Flight> availableFlights(Trip trip) {
		return JDBCConnection.getInstance().userSearchedFilghts(trip);
	}

	public List<Integer> createTicket(String flightNumber, List<Passenger> pList) {
		List<Integer> ticketList = new ArrayList<>();

		if (JDBCConnection.getInstance().seatsAllocation(flightNumber, pList.size())) {
			ticketList = JDBCConnection.getInstance().generateTicket(flightNumber, pList);
		}

		return ticketList;

	}

	public TicketDetails getTicket(int ticketNumber) {
		return JDBCConnection.getInstance().getTicket(ticketNumber);
	}

	public boolean cancelTicket(int ticketNumber) {
		return JDBCConnection.getInstance().cancelTicket(ticketNumber);
	}

}
