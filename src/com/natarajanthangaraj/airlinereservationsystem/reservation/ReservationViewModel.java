package com.natarajanthangaraj.airlinereservationsystem.reservation;

import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;
import com.natarajanthangaraj.airlinereservationsystem.repository.Repository;

public class ReservationViewModel {
	private ReservationView reserveview;
	TicketDetails ticketdetails;

	public ReservationViewModel(ReservationView reservationView) {
		this.reserveview = reservationView;
		// ticketdetails=new TicketDetails();
	}

	public void getAllFlights() {
		  ticketdetails = reserveview.flightDetails();
		reserveview.showavailableFlights(Repository.getInstance().availableFlights(ticketdetails));

	}

	public void ticketAllocation(String userSelectedFlight) {
		Repository.getInstance().allotSeat(userSelectedFlight,reserveview.passengerDetails());
		if(Repository.getInstance().createTicket(userSelectedFlight,ticketdetails)){
			reserveview.successMessage();
		}
	}

}
