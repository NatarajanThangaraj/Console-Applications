package com.natarajanthangaraj.airlinereservationsystem.reservation;

import com.natarajanthangaraj.airlinereservationsystem.Repository.Repository;
import com.natarajanthangaraj.airlinereservationsystem.application.dto.SearchFlights;
import com.natarajanthangaraj.airlinereservationsystem.dto.Ticket;

public class ReservationViewModel {
	private ReservationView reserveview;

	// private Repository repo;
	public ReservationViewModel(ReservationView reservationView) {
		this.reserveview = reservationView;
		// repo=new Repository();
	}

	public void getAllFlights() {
		SearchFlights sf = reserveview.flightDetails();
		
		reserveview.showavailableFlights(Repository.getInstance().availableFlights(sf));

	}

	public void ticketAllocation(String userSelectedFlight) {
		Repository.getInstance().allotSeat(userSelectedFlight);
		Ticket ticket=Repository.getInstance().createTicket(userSelectedFlight,reserveview.passengerDetails());
		reserveview.showTicket(ticket);
	}

}
