package com.natarajanthangaraj.airlinereservationsystem.application;

import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.reservation.ReservationView;

public class ApplicationView {
	private ApplicationViewModel appviewmodel;
	ReservationView reserveView = new ReservationView();
	Scanner scan = new Scanner(System.in);

	public ApplicationView() {
		this.appviewmodel = new ApplicationViewModel(this);
	}

	public void start() {
		int select = 0;
		do {
			showFeatures();
			System.out.print("Enter your choice: ");

			select = scan.nextInt();
			switch (select) {
			case 1 -> {
				reserveView.userSearch();

			}
			case 2 -> {

			}
			case 3 -> {

			}
			case 4 -> {

			}
			case 0 -> {
				break;
			}
			default -> {
				System.out.println("Invalid selecton");
			}
			}
		} while (select != 0);
	}

	public void showFeatures() {
		System.out.println("	~*~	    Welcome To AIR INDIA	~*~	 ");
		System.out.println();
		System.out.println("  +======================================+");
		System.out.println("  |  1. Search Flights                   |");
		System.out.println("  |  2. Manage Booking                   |");
		System.out.println("  |  3. Check - In                       |");
		System.out.println("  |  4. Flight Status                    |");
		System.out.println("  |  0. Exit                             |");
		System.out.println("  +======================================+");
		System.out.println();
	}
}
