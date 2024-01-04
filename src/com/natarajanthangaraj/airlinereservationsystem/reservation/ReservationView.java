package com.natarajanthangaraj.airlinereservationsystem.reservation;

import java.util.List;
import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.Utility;
import com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler.DateValidation;
import com.natarajanthangaraj.airlinereservationsystem.dto.Flight;
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;

public class ReservationView {
	TicketDetails ticketDetails = new TicketDetails();
	private ReservationViewModel reserveviewmodel;
	Scanner scan = new Scanner(System.in);

	public ReservationView() {
		this.reserveviewmodel = new ReservationViewModel(this);
	}

	public void userSearch() {

		reserveviewmodel.getAllFlights();

		reserveviewmodel.ticketAllocation(userSelectedFlight());
	}

	public TicketDetails flightDetails() {
		System.out.print(" From : ");
		ticketDetails.setFrom(scan.next());
		System.out.print(" To : ");
		ticketDetails.setTo(scan.next());
		System.out.print(" Depart Date [dd/mm/yyyy] :");
		ticketDetails.setDepartDate( DateValidation.isValidDateTime());
		System.out.println("     +===================+");
		System.out.println("     |    1 . Adult      |");
		System.out.println("     +===================+");
		System.out.print("Passenger :");
		ticketDetails.setPassenger_Type(Utility.getPassengerType(scan.nextInt()));
		System.out.print(" Number of Passenger :");
		ticketDetails.setPassenger_Count(scan.nextInt());
		System.out.println("     +===================+");
		System.out.println("     |    1 .Economy     |");
		System.out.println("     |    2 .Business    |");
		System.out.println("     +===================+");
		System.out.print("Category :");
		ticketDetails.setCategory(Utility.getCategory(scan.nextInt()));
		return ticketDetails;
	}

	void showavailableFlights(List<Flight> flights) {
		int Numbers = 1;
		if(flights.size()==0) {
			System.out.println(" Currently not Available ...");
			return ;
		}else {
		System.out.println("\t SELECT FLIGHT :\t");
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.println("| N |  Flight Number  |  Depart Time  |  Landing Time  |   Price  |   seats  |");
		System.out.println("+----------------------------------------------------------------------------+");
		for (Flight eachFlight : flights) {
			System.out.println("| " + Numbers++ + "  |" + "     " + eachFlight.getFlightNumber() + "      " + "|     "
					+ eachFlight.getDepartTime()+" AM     |     "+eachFlight.getLandingTime()+" AM   |" + "  " + eachFlight.getEconomyPrice() + " |" + "   "
					+ eachFlight.getEconomySeats() + "    " + "|");

		}
		System.out.println("+----------------------------------------------------------------------------+");
	}
	}

	String userSelectedFlight() {
		System.out.print("Enter Flight Number: ");
		String selectedFlight = scan.next();
		return selectedFlight.toUpperCase();
	}

	TicketDetails passengerDetails() {
		System.out.println("\t\t PASSENGER DETAILS : \t\t");
		System.out.print(" FirstName : ");
		ticketDetails.setFirst_Name(scan.next());
		System.out.print(" LastName : ");
		ticketDetails.setLast_Name(scan.next());
		System.out.print(" Date of Birth [ dd/mm/yyyy ] : ");
//		while(!DateValidation.isValidDate(scan.next())) {
//			System.out.print(" Please Enter the valid date : ");
//		} 
		ticketDetails.setDate_Of_Birth(scan.next());
		System.out.print(" Email : ");
		ticketDetails.setGmail(scan.next());
		System.out.print(" Mobile Number : ");
		ticketDetails.setMobile_Number(scan.next());
		return ticketDetails;
	}

//	public void showTicket(Map amp) {
//		System.out.println("+-------------------------------------------+");
//		System.out.println("|  Ticket Number :   |" + ticket.getTicketNumber()+"|");
//	    System.out.println("| From               |"+ticket.getFrom());
//		System.out.println("Depart Date : " + ticket.getDate());
//		System.out.println("Passenger Name : " + ticket.getFirstName() + " " + ticket.getLastName());
//		System.out.println("Passenger Details : "+ ticket.getPassenger_Type()+"\n");
//		System.out.println("Number of Passengers : "+ticket.getPassenger_Count());
//	System.out.println(" On-Boarding : ");
//		System.out.println();
//	}

	public void successMessage() {
		System.out.println(" Ticket booked successfully....");	
	}

	public void manageBooking() {
		
		
	}

}
