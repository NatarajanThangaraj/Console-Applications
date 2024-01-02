package com.natarajanthangaraj.airlinereservationsystem.application;

import com.natarajanthangaraj.airlinereservationsystem.managereservation.ManageBookingView;
import com.natarajanthangaraj.airlinereservationsystem.reservation.ReservationView;

public class ApplicationViewModel {
    private ApplicationView appview;
    ReservationView reserveView = new ReservationView();
    ManageBookingView manageView=new ManageBookingView();
	public ApplicationViewModel(ApplicationView applicationView) {
		this.appview=applicationView;
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

		}
		case 4 -> {

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
