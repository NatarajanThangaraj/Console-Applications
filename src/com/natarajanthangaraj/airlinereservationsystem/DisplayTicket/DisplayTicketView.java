package com.natarajanthangaraj.airlinereservationsystem.DisplayTicket;

import org.json.simple.JSONObject;

public class DisplayTicketView {
	public DisplayTicketViewModel displayticketviewmodel;

	public void showTicket(String ticketNumber) {
		JSONObject ticket=displayticketviewmodel.getTicket(ticketNumber);
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
