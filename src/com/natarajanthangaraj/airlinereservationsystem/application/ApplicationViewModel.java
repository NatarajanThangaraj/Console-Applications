package com.natarajanthangaraj.airlinereservationsystem.application;

import org.json.simple.JSONObject;

import com.natarajanthangaraj.airlinereservationsystem.Utility;
import com.natarajanthangaraj.airlinereservationsystem.DisplayTicket.DisplayTicketView;
import com.natarajanthangaraj.airlinereservationsystem.managereservation.ManageBookingView;
import com.natarajanthangaraj.airlinereservationsystem.repository.Repository;
import com.natarajanthangaraj.airlinereservationsystem.reservation.ReservationView;

public class ApplicationViewModel {
	private ApplicationView appview;
	ReservationView reserveView;
	ManageBookingView manageView;
	DisplayTicketView ticketView;

	public ApplicationViewModel(ApplicationView applicationView) {
		this.appview=applicationView;
		this.reserveView= new ReservationView();
		this.manageView=new ManageBookingView();
		this.ticketView=new DisplayTicketView();
	}

	public void selectedFeature(int select) {
		switch (select) {
		case 1 -> {
			reserveView.userSearch();
		}
		case 2 -> {
			manageView.manageBooking();
		}
		case 3 -> {
			ticketView.showTicket(Utility.getTicketNumber());
		}
		case 0 -> {
			break;
		}
		default -> {
			System.out.println("Invalid selecton");
		}
		}

	}

	

}
