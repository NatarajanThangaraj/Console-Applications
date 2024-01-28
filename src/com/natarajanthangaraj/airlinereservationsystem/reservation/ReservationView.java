package com.natarajanthangaraj.airlinereservationsystem.reservation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.BaseView;
import com.natarajanthangaraj.airlinereservationsystem.Utility;
import com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler.DateValidation;
import com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler.TimeValidation;
import com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler.Validation;
import com.natarajanthangaraj.airlinereservationsystem.dto.Flight;
import com.natarajanthangaraj.airlinereservationsystem.dto.Passenger;
import com.natarajanthangaraj.airlinereservationsystem.dto.Trip;

public class ReservationView extends BaseView {

	private ReservationViewModel reserveViewModel;
	Scanner scan = new Scanner(System.in);
	public ReservationView() {
		this.reserveViewModel = new ReservationViewModel(this);
	}

	public void userSearch() {
		reserveViewModel.makeTrip();
	}

	public Trip flightDetails() {
		String date, time;
		Trip trip = new Trip();
		System.out.println("\n~*~*~   Enter your Trip Details   ~*~*~\n");
		System.out.print(" From : ");
		trip.setFrom(scan.next());
		System.out.print(" To : ");
		trip.setTo(scan.next());
		System.out.print(" Depart Date [dd/mm/yyyy] :");
		date = scan.next();
		while (!DateValidation.isValidDate(date)) {
			System.out.print(" Enter valid Date : ");
			date = scan.next();
		}
		trip.setDate(DateValidation.dateFormat(date));
		System.out.print(" Depart Time [HH:mm] :");
		time = scan.next();
		while (!TimeValidation.timeValidation(time)) {
			System.out.print(" Enter valid Time : ");
			time = scan.next();
		}
		trip.setTime(TimeValidation.timeFormat(time));
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

	public void userSelectionAction() {// make default
		System.out.println(" --------------------");
		System.out.println(" 1. Reserve a Ticket ");
		System.out.println(" 9. Go Back          ");
		System.out.println(" 0. Exit             ");
		System.out.println(" --------------------");
		System.out.print(" Enter Choice : ");
		reserveViewModel.goForward(getInt());
	}

	Passenger passengerDetails() {
		String gMail, mobileNumber;
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
		String date = scan.next();
		while (!DateValidation.getDateOfBirth(date)) {
			System.out.print(" Enter valid Date of Birth : ");
			date = scan.next();
		}
		scan.nextLine();
		System.out.print(" Email (Optional, press Enter to skip): ");
		gMail = scan.nextLine().trim();
		while (!gMail.isEmpty() && !Validation.isValidGmailAddress(gMail)) {
			System.out.println(" Enter valid gMail : ");
			gMail = scan.nextLine().trim();
		}
		scan.next();
		passenger.setgMailAddress(gMail.isEmpty() ? null : gMail);
		System.out.print(" Mobile Number (Optional, press Enter to skip): ");
		mobileNumber = scan.nextLine().trim();

		while (!mobileNumber.isEmpty() && !Validation.isValidMobileNumber(mobileNumber)) {
			System.out.println(" Enter valid Mobile Number : ");
			mobileNumber = scan.nextLine().trim();
		}
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
			System.out.println("\t\t PASSENGER " + (i + 1) + " DETAILS : \t\t");
			passengerList.add(passengerDetails());
		}
		return passengerList;
	}

	public void showTicketNumbers(List<Integer> ticketNumberList) {
		System.out.println(" Booking Successfully");
		System.out.println("--------------------------------");
		System.out.println(" Serial Number\t|\tTicket Number");
		System.out.println("--------------------------------");

		for (int i = 0; i < ticketNumberList.size(); i++) {
			System.out.printf(" %d\t|\t%s\n", i + 1, ticketNumberList.get(i));
		}

		System.out.println("--------------------------------");
		System.out.println(" These are Your Tickets... Kindly check your Ticket Details\n");
		System.out.println(" Have a Good Journey!!!");

	}

}
