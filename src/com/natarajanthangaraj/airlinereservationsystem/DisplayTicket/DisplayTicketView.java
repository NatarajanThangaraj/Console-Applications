package com.natarajanthangaraj.airlinereservationsystem.DisplayTicket;

import com.natarajanthangaraj.airlinereservationsystem.BaseView;
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;

public class DisplayTicketView extends BaseView{
	public DisplayTicketViewModel displayTicketViewModel;
	public DisplayTicketView() {
		this.displayTicketViewModel=new DisplayTicketViewModel(this);
	}

	public void showTicket(int ticketNumber) {
		TicketDetails ticket=displayTicketViewModel.getTicket(ticketNumber);
		 if (ticket != null) {
			    System.out.println("+--------------------------------------+");
		        System.out.println("|          AIRINDIA                    |");
		        System.out.println("|--------------------------------------|");
		        System.out.printf("|  Ticket Number: %-20s |\n", ticket.getFlight().getFlightNumber());
		        System.out.printf("|  From: %-30s |\n", ticket.getFlight().getFrom());
		        System.out.printf("|  To: %-32s |\n", ticket.getFlight().getTo());
		        System.out.printf("|  Departure Date: %-20s |\n", ticket.getFlight().getDepartDate());
		        System.out.printf("|  Passenger: %-25s |\n", ticket.getPassenger().getFirstName() + " " + ticket.getPassenger().getLastName());
		        System.out.printf("|  Passenger Type: %-20s |\n", ticket.getPassenger().getPassengerType());
		        System.out.printf("|  Category: %-25s |\n", ticket.getFlight().getCategory());
		        System.out.printf("|  Amount: $%-25.4f |\n", ticket.getFlight().getEconomyPrice());
		        System.out.println("+--------------------------------------+");
		    } else {
		        System.out.println("Ticket not found.");
		    }

}
}
