package com.natarajanthangaraj.airlinereservationsystem.application;

import com.natarajanthangaraj.airlinereservationsystem.BaseView;

public class ApplicationView extends BaseView{
	private ApplicationViewModel appViewModel;

	public ApplicationView() {
		this.appViewModel = new ApplicationViewModel();
	}

	public void start() {
		int select = 0;
		do {
			showFeatures();
			System.out.print("Enter your choice: ");
			select = getInt();
			if(select!=0)
			appViewModel.selectedFeature(select);
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
