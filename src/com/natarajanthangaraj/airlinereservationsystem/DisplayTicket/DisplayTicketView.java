package com.natarajanthangaraj.airlinereservationsystem.DisplayTicket;

import org.json.simple.JSONObject;

import com.natarajanthangaraj.airlinereservationsystem.BaseView;

public class DisplayTicketView extends BaseView{
	public DisplayTicketViewModel displayTicketViewModel;

	public void showTicket(String ticketNumber) {
		JSONObject ticket=displayTicketViewModel.getTicket(ticketNumber);
		System.out.println("+----------------------------------+");
		System.out.println("|  Ticket Number :   |  " + ticket.get("TicketNumber") + "  |");
		System.out.println("|  From               |" + ticket.get("From") + "  |");
		System.out.println("|  To               |" + ticket.get("To") + "  |");
		System.out.println("|  Depart Date : " + ticket.get("Booking Date") + "  |");
		System.out.println("|  Passenger Name : " + ticket.get("First Name") + " " + ticket.get("Last Name") + "  |");
		System.out.println("|  Passenger Details : " + ticket.get("Type") + " - " + ticket.get("Count") + "  |");
		System.out.println("|  category : " + ticket.get("class") + "  |");
		System.out.println("|  Amount  : " + ticket.get("Total Amount") + "  |");
		System.out.println("+----------------------------------+");
	}
}
