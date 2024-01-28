package com.natarajanthangaraj.airlinereservationsystem.DisplayTicket;

import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;
import com.natarajanthangaraj.airlinereservationsystem.repository.Repository;

public class DisplayTicketViewModel {
	public DisplayTicketView displayTicketView;

	public DisplayTicketViewModel(DisplayTicketView displayTicketView) {
		this.displayTicketView = displayTicketView;
	}

	public TicketDetails getTicket(int ticketNumber) {
		 return Repository.getInstance().getTicket(ticketNumber);
		
	}
	
}
