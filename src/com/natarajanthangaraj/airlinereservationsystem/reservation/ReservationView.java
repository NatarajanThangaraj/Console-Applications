package com.natarajanthangaraj.airlinereservationsystem.reservation;

import java.util.List;
import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.Utility;
import com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler.DateValidation;
import com.natarajanthangaraj.airlinereservationsystem.dto.Flight;
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;

public class ReservationView extends DateValidation {

	private ReservationViewModel reserveViewModel;
	Scanner scan = new Scanner(System.in);
	Flight flightDetails = new Flight();

	public ReservationView() {
		this.reserveViewModel = new ReservationViewModel(this);
	}

	public void userSearch() {

		reserveViewModel.getAllFlights();

		reserveViewModel.ticketAllocation(userSelectedFlight());
	}

	public Flight flightDetails() {
		System.out.print(" From : ");
		flightDetails.setFrom(scan.next());
		System.out.print(" To : ");
		flightDetails.setTo(scan.next());
		System.out.print(" Depart Date [dd/mm/yyyy] :");
		flightDetails.setDepartDate(isValidDateTime(scan.next()));
		System.out.println("     +===================+");
		System.out.println("     |    1 . Adult      |");
		System.out.println("     +===================+");
		System.out.print("Passenger :");
		flightDetails.setPassengerType(Utility.getPassengerType(scan.nextInt()));
		System.out.print(" Number of Passenger :");
		flightDetails.setPassengerCount(scan.nextInt());
		System.out.println("     +===================+");
		System.out.println("     |    1 .Economy     |");
		System.out.println("     |    2 .Business    |");
		System.out.println("     +===================+");
		System.out.print("Category :");
		flightDetails.setCategory(Utility.getCategory(scan.nextInt()));
		return flightDetails;
	}

	void showavailableFlights(List<Flight> flights) {
		int number = 1;
		if (flights.size() == 0) {
			System.out.println(" Currently not Available ...");
			return;
		} else {
			System.out.println("\t SELECT FLIGHT :\t");
			System.out.println("+----------------------------------------------------------------------------+");
			System.out.println("| N |  Flight Number  |  Depart Time  |  Landing Time  |   Price  |   seats  |");
			System.out.println("+----------------------------------------------------------------------------+");
			for (Flight eachFlight : flights) {
				System.out.println("| " + number++ + "  |" + "     " + eachFlight.getFlightNumber() + "      "
						+ "|     " + eachFlight.getDepartTime() + " AM     |     " + eachFlight.getLandingTime()
						+ " AM   |" + "  " + eachFlight.getEconomyPrice() + " |" + "   " + eachFlight.getEconomySeats()
						+ "    " + "|");

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
		flightDetails.setFirst_Name(scan.next());
		System.out.print(" LastName : ");
		flightDetails.setLast_Name(scan.next());
		System.out.print(" Date of Birth [ dd/mm/yyyy ] : ");
		flightDetails.setDate_Of_Birth(getDateOfBirth(scan.next()));
		System.out.print(" Email : ");
		flightDetails.setGmail(scan.next());
		System.out.print(" Mobile Number : ");
		flightDetails.setMobile_Number(scan.next());
		return flightDetails;
	}

	public void successMessage() {
		System.out.println(" Ticket booked successfully....");
	}

}
