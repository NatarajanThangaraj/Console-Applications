package com.natarajanthangaraj.airlinereservationsystem.DisplayTicket;

import org.json.simple.JSONObject;

import com.natarajanthangaraj.airlinereservationsystem.repository.Repository;

public class DisplayTicketViewModel {
	public DisplayTicketView displayticketview;

	public DisplayTicketViewModel(DisplayTicketView displayticketview) {
		this.displayticketview = displayticketview;
	}
	JSONObject getTicket(String ticketNumber) {
		return Repository.getInstance().getTicket(ticketNumber);
	}
}
