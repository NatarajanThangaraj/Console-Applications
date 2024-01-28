package com.natarajanthangaraj.airlinereservationsystem.reservation;

import java.util.List;

import com.natarajanthangaraj.airlinereservationsystem.dto.Flight;
import com.natarajanthangaraj.airlinereservationsystem.dto.Passenger;
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;
import com.natarajanthangaraj.airlinereservationsystem.dto.Trip;
import com.natarajanthangaraj.airlinereservationsystem.repository.Repository;

public class ReservationViewModel {
	private ReservationView reserveView;
	Flight flight;
	Trip trip;

	public ReservationViewModel(ReservationView reservationView) {
		this.reserveView = reservationView;
		this.flight = new Flight();
		
	}
	public void goForward(int select)  {
		String flightNumber = null;
		List<Passenger>pList;
		List<Integer>ticketNumberList;
		switch(select) {
		case 1->{
			while(flightNumber==null) {
				flightNumber=reserveView.getFlightNumber();
			}			
				pList=reserveView.getPassengerList(trip.getNumberOfPassenger());
				
				ticketNumberList=Repository.getInstance().createTicket(flightNumber,pList );
				reserveView.showTicketNumbers(ticketNumberList);
		}case 9->{
			makeTrip();
		}case 0->{
			reserveView.endMessage();
		}default->{
			reserveView.wrongSelectionAlert();
			reserveView.getSelection();
		}
		}
		
	}

	public void makeTrip() {
		trip=reserveView.flightDetails();
		List<Flight> flightList = Repository.getInstance().availableFlights(trip);
		reserveView.showavailableFlights(flightList);
		reserveView.userSelectionAction();
		
	}

}
