package com.natarajanthangaraj.airlinereservationsystem.managereservation;

import com.natarajanthangaraj.airlinereservationsystem.repository.Repository;

public class ManageBookingViewModel {
	public ManageBookingView manageView;

	public ManageBookingViewModel(ManageBookingView manageBookingView) {
		manageView = manageBookingView;
	}

	public void manageTicketDetails(String ticketNumber, int selectedFeature) {
		if (Repository.getInstance().cancelTicket(ticketNumber)) {
			manageView.successMessage();
		} else {
			manageView.failureMessage();
		}
	}

}
