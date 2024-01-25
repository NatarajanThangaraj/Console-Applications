package com.natarajanthangaraj.airlinereservationsystem.DisplayTicket;

import org.json.simple.JSONObject;

import com.natarajanthangaraj.airlinereservationsystem.repository.Repository;

public class DisplayTicketViewModel {
	public DisplayTicketView displayTicketView;

	public DisplayTicketViewModel(DisplayTicketView displayTicketView) {
		this.displayTicketView = displayTicketView;
	}
	JSONObject getTicket(String ticketNumber) {
		return Repository.getInstance().getTicket(ticketNumber);
	}
}
