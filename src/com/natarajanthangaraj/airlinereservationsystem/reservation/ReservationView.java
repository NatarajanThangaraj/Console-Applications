package com.natarajanthangaraj.airlinereservationsystem.reservation;

import java.util.List;
import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.application.dto.SearchFlights;
import com.natarajanthangaraj.airlinereservationsystem.dto.Passenger;
import com.natarajanthangaraj.airlinereservationsystem.dto.Ticket;
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

	public SearchFlights flightDetails() {
		SearchFlights newSearch = new SearchFlights();

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
		newSearch.setAdult(scan.nextInt());
		System.out.print(" Number of Passenger :");
		newSearch.setAdultCount(scan.nextInt());
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

	String userSelectedFlight() {
		System.out.print("Enter Flight Number: ");
		String selectedFlight = scan.next();
		return selectedFlight.toUpperCase();
	}

	Passenger passengerDetails() {
		Passenger travellor = new Passenger();
		System.out.println("\t\t PASSENGER DETAILS : \t\t");
		System.out.print(" FirstName : ");
		travellor.setFirstName(scan.next());
		System.out.print(" LastName : ");
		travellor.setLastName(scan.next());
		System.out.print(" Date of Birth : ");
		travellor.setDob(scan.next());
		System.out.print(" Email : ");
		travellor.setEmail(scan.next());
		System.out.print(" Mobile Number : ");
		travellor.setMobileNumber(scan.nextLong());
		System.out.print(" Passenger  : Adult - ");
		travellor.setPassengers(scan.nextLong());
		return travellor;
	}

	public void showTicket(Ticket ticket) {
		System.out.println();
		System.out.println("Ticket Number : " + ticket.getTicketNumber());
		System.out.println(ticket.getFrom() + " ----> " + ticket.getTo());
		System.out.println("Depart Date : " + ticket.getDate());
		System.out.println("Passenger Name : " + ticket.getFirstName() + " " + ticket.getLastName());
		System.out.println("Passenger Details : Adult - " + ticket.getPassengers());
		System.out.println(" On-Boarding : Treminal 2");
		System.out.println();
	}

}
