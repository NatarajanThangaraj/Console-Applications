package com.natarajanthangaraj.airlinereservationsystem.reservation;

import com.natarajanthangaraj.airlinereservationsystem.Repository.Repository;
import com.natarajanthangaraj.airlinereservationsystem.dto.Ticket;
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;

public class ReservationViewModel {
	private ReservationView reserveview;

	// private Repository repo;
	public ReservationViewModel(ReservationView reservationView) {
		this.reserveview = reservationView;
		// repo=new Repository();
	}

	public void getAllFlights() {
		 TicketDetails tk = reserveview.flightDetails();
		
		reserveview.showavailableFlights(Repository.getInstance().availableFlights(tk));

	}

	public void ticketAllocation(String userSelectedFlight) {
		Repository.getInstance().allotSeat(userSelectedFlight);
		Ticket ticket=Repository.getInstance().createTicket(userSelectedFlight,reserveview.passengerDetails());
		reserveview.showTicket(ticket);
	}

}
