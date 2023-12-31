package com.natarajanthangaraj.airlinereservationsystem.managereservation;

import java.util.Scanner;

public class ManageBookingView {
	Scanner scan = new Scanner(System.in);
	private ManageBookingViewModel managebookingviewmodel;

	public ManageBookingView() {
		this.managebookingviewmodel = new ManageBookingViewModel(this);
	}

	public void manageBooking() {
		String TicketNumber = getTicketNumber();
		int selectedFeature = manageFeatures();
		managebookingviewmodel.manageTicketDetails(TicketNumber, selectedFeature);
	}

	private int manageFeatures() {
		System.out.println("\n+=========================+");
		System.out.println("  |  1. Cancel Ticket       |");
		System.out.println("  |  0. Exit                |");
		System.out.println("  +=========================+\n");
		System.out.print(" Enter a Choice : ");
		int selectedFeature = scan.nextInt();
		return selectedFeature;
	}

	private String getTicketNumber() {
		System.out.print(" Enter the Ticket Number ");
		String ticketNumber = scan.next();
		return ticketNumber;
	}

}
