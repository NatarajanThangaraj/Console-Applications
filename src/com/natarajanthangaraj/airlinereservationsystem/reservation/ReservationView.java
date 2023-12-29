package com.natarajanthangaraj.airlinereservationsystem.reservation;

import java.util.List;

import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler.DateValidation;
import com.natarajanthangaraj.airlinereservationsystem.dto.Ticket;
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;
import com.natarajanthangaraj.airlinereservationsystem.flight.Flight;

public class ReservationView {
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
		TicketDetails newSearch = new TicketDetails();

		System.out.print(" From : ");
		newSearch.setFrom(scan.next());
		System.out.print(" To : ");
		newSearch.setTo(scan.next());
		System.out.print(" Depart Date :");
		newSearch.setDepartDate(scan.next());
		System.out.println("     +===================+");
		System.out.println("     |    1 . Adult      |");
		System.out.println("     +===================+");
		System.out.print("Passenger :");
		newSearch.setPassenger_Type(scan.nextInt());
		System.out.print(" Number of Passenger :");
		newSearch.setPassenger_Count(scan.nextInt());
		System.out.println("     +===================+");
		System.out.println("     |    1 .Economy     |");
		System.out.println("     |    2 .Business    |");
		System.out.println("     +===================+");
		System.out.print("Category :");
		newSearch.setCategory(scan.nextInt());
		return newSearch;
	}

	void showavailableFlights(List<Flight> flights) {
		int Numbers = 1;
		if(flights.size()==0) {
			System.out.println(" Currently not Available ...");
		}else {
		System.out.println("\t SELECT FLIGHT :\t");
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.println("| N |  Flight Number  |  Depart Time  |  Landing Time  |   Price  |   seats  |");
		System.out.println("+----------------------------------------------------------------------------+");
		for (Flight eachFlight : flights) {
			System.out.println("| " + Numbers++ + "  |" + "     " + eachFlight.getFlightNumber() + "      " + "|"
					+ "     20:00     |" + "     22:30      |" + "  " + eachFlight.getEconomyPrice() + " |" + "   "
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
		TicketDetails travellor = new TicketDetails();
		System.out.println("\t\t PASSENGER DETAILS : \t\t");
		System.out.print(" FirstName : ");
		travellor.setFirst_Name(scan.next());
		System.out.print(" LastName : ");
		travellor.setLast_Name(scan.next());
		System.out.print(" Date of Birth [ dd/mm/yyyy ] : ");
		while(!DateValidation.isValidDate(scan.next())) {
			System.out.print(" Please Enter the valid date : ");
		} 
			
		
		travellor.setDate_Of_Birth(scan.next());
		System.out.print(" Email : ");
		travellor.setGmail(scan.next());
		System.out.print(" Mobile Number : ");
		travellor.setMobile_Number(scan.nextInt());
		return travellor;
	}

	public void showTicket(Ticket ticket) {
		System.out.println();
		System.out.println("Ticket Number : " + ticket.getTicketNumber());
		System.out.println(ticket.getFrom() + " ----> " + ticket.getTo());
		System.out.println("Depart Date : " + ticket.getDate());
		System.out.println("Passenger Name : " + ticket.getFirstName() + " " + ticket.getLastName());
		System.out.println("Passenger Details : ");
		int passengerType=ticket.getPassenger_Type();
		System.out.println(" On-Boarding : Treminal 2");
		System.out.println();
	}

}
