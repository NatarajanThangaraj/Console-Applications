package com.natarajanthangaraj.airlinereservationsystem.reservation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.BaseView;
import com.natarajanthangaraj.airlinereservationsystem.Utility;
import com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler.DateValidation;
import com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler.TimeValidation;
import com.natarajanthangaraj.airlinereservationsystem.dto.Flight;
import com.natarajanthangaraj.airlinereservationsystem.dto.Passenger;
import com.natarajanthangaraj.airlinereservationsystem.dto.Trip;

public class ReservationView extends BaseView {

	private ReservationViewModel reserveViewModel;
	Scanner scan = new Scanner(System.in);
	// Flight flightDetails = new Flight();

	public ReservationView() {
		this.reserveViewModel = new ReservationViewModel(this);
	}

	public void userSearch() {
		reserveViewModel.makeTrip();
		// reserveViewModel.ticketAllocation(userSelectedFlight());
	}

	public Trip flightDetails() {
		Trip trip = new Trip();
		System.out.println("~*~*~   Enter your Trip Details   ~*~*~");
		System.out.print(" From : ");
		trip.setFrom(scan.next());
		System.out.print(" To : ");
		trip.setTo(scan.next());
		System.out.print(" Depart Date [dd/mm/yyyy] :");
		trip.setDate(DateValidation.isValidDateTime());
		System.out.print(" Depart Time [HH:mm] :");
		trip.setTime(TimeValidation.timeValidation());
		System.out.print(" Number of Passenger :");
		trip.setNumberOfPassenger(getInt());
		System.out.println("     +===================+");
		System.out.println("     |    1 .Economy     |");
		System.out.println("     |    2 .Business    |");
		System.out.println("     +===================+");
		System.out.print("Category :");
		trip.setCategory(Utility.getCategory(scan.nextInt()));
		return trip;
	}

	void showavailableFlights(List<Flight> flights) {
		int number = 1;
		if (flights.size() == 0) {
			System.out.println(" Currently not Available ...");
			return;
		} else {
			System.out.println("\t SELECT FLIGHT :\t");
			System.out.println(
					"+---+----------------+---------------+----------------+----------------+-----------------+--------+");
			System.out.println(
					"| N | Flight Number  | Depart Time   | Landing Time   | Economy Price  | Business Price  | Seats  |");
			System.out.println(
					"+---+----------------+---------------+----------------+----------------+-----------------+--------+");
			for (Flight eachFlight : flights) {
				System.out.printf("| %-2d| %-14s| %-14s| %-15s| %-14.1f| %-15.1f| %-6d|\n", number++,
						eachFlight.getFlightNumber(), eachFlight.getDepartTime(), eachFlight.getLandingTime(),
						eachFlight.getEconomyPrice(), eachFlight.getBusinessPrice(), eachFlight.getEconomySeats());
			}

			System.out.println(
					"+---+----------------+---------------+----------------+----------------+-----------------+--------+");

		}
	}

	public void userSelectionAction() {//make default
		System.out.println(" --------------------");
		System.out.println(" 1. Reserve a Ticket ");
		System.out.println(" 9. Go Back          ");
		System.out.println(" 0. Exit             ");
		System.out.println(" --------------------");
		System.out.print(" Enter Choice : ");
		reserveViewModel.goForward(getInt());
	}

	Passenger passengerDetails() {
		Passenger passenger = new Passenger();
		System.out.print(" FirstName : ");
		passenger.setFirstName(scan.next());
		System.out.print(" LastName : ");
		passenger.setLastName(scan.next());
		System.out.println("     +===================+");
		System.out.println("     |    1 . Adult      |");
		System.out.println("     |    2 . Children   |");
		System.out.println("     |    3 . Infant     |");
		System.out.println("     +===================+");
		System.out.print("Passenger :");
		passenger.setPassengerType(Utility.getPassengerType(scan.nextInt()));
		System.out.print(" Date of Birth [ dd/mm/yyyy ] : ");
		passenger.setDateOfBirth(DateValidation.getDateOfBirth());
		System.out.print(" Email (Optional, press Enter to skip): ");
	    String gMail = scan.next().trim();
	    passenger.setgMailAddress(gMail.isEmpty() ? null : gMail);
	    System.out.print(" Mobile Number (Optional, press Enter to skip): ");
	    String mobileNumber = scan.next().trim();
	    passenger.setMobileNumber(mobileNumber.isEmpty() ? null : mobileNumber);
		return passenger;
	}

	public void successMessage() {
		System.out.println(" Ticket booked successfully....");
	}
	public void endMessage() {
		System.out.println(" Thank you Have a Good Day....");
	}
	public void wrongSelectionAlert() {
		System.err.println(" Wrong Selection");
	}

	protected int getSelection() {
		int select = 0;
		while (true) {
			try {
				System.out.print(" Enter Choice : ");
				select = scan.nextInt();
				return select;
			} catch (InputMismatchException e) {
				System.out.print(" Please Enter Valid Choice : ");
			}
		}
	}

	public List<Passenger> getPassengerList(int numberOfPassenger) {
		List<Passenger> passengerList = new ArrayList<>();
		for (int i = 0; i < numberOfPassenger; i++) {
			System.out.println("\t\t PASSENGER "+(i+1)+"DETAILS : \t\t");
			passengerList.add(passengerDetails());
		}
		return passengerList;
	}

	public void showTicketNumbers(List<Integer> ticketNumberList) {
		System.out.println(" Booking Successfully");
		for(int i=0;i<ticketNumberList.size();i++) {
			System.out.println((i+1)+" . "+ticketNumberList.get(i));
		}
		System.out.println(" These are Your Tickets ... Kindly check your Ticket Details \n");
		System.out.println(" Have a Good Journey!!!");
		
	}

}
