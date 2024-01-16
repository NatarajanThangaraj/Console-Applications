package com.natarajanthangaraj.airlinereservationsystem.application;

import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.Utility;
import com.natarajanthangaraj.airlinereservationsystem.reservation.ReservationView;

public class ApplicationView {
	private ApplicationViewModel appviewmodel;
	Scanner scan = new Scanner(System.in);

	public ApplicationView() {
		this.appviewmodel = new ApplicationViewModel(this);
	}

	public void start() {
		int select = 0;
		do {
			showFeatures();
			System.out.print("Enter your choice: ");
			select = Utility.getInteger();
			if(select!=0)
			appviewmodel.selectedFeature(select);
		}while(select!=0);
			
		
	}

	public void showFeatures() {
		System.out.println("	~*~	    Welcome To AIR INDIA	~*~	 ");
		System.out.println();
		System.out.println("  +======================================+");
		System.out.println("  |  1. Search Flights                   |");
		System.out.println("  |  2. Manage Booking                   |");
		System.out.println("  |  3. View Ticket                      |");
		System.out.println("  |  0. Exit                             |");
		System.out.println("  +======================================+");
		System.out.println();
	}
}
