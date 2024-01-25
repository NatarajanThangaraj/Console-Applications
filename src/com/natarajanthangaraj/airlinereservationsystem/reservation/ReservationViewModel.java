package com.natarajanthangaraj.airlinereservationsystem.reservation;

import com.natarajanthangaraj.airlinereservationsystem.dto.Flight;
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;
import com.natarajanthangaraj.airlinereservationsystem.repository.Repository;

public class ReservationViewModel {
	private ReservationView reserveView;
	TicketDetails ticketDetails;
	Flight flight;

	public ReservationViewModel(ReservationView reservationView) {
		this.reserveView = reservationView;
		this.flight=new Flight();
		// flightDetails=new TicketDetails();
	}

	public void getAllFlights() {
		  flight = reserveView.flightDetails();
		reserveView.showavailableFlights(Repository.getInstance().availableFlights(ticketDetails));

	}

	public void ticketAllocation(String userSelectedFlight) {
		Repository.getInstance().allotSeat(userSelectedFlight,reserveView.passengerDetails());
		if(Repository.getInstance().createTicket(userSelectedFlight,ticketDetails)){
			reserveView.successMessage();
		}
	}

}
