package com.natarajanthangaraj.airlinereservationsystem.login.adminlogin;

import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler.TimeValidation;
import com.natarajanthangaraj.airlinereservationsystem.dto.Flight;
import com.natarajanthangaraj.airlinereservationsystem.login.LoginView;

public class AdminLoginView extends LoginView{
	private AdminLoginViewModel adminLoginViewModel;
	Scanner scan=new Scanner(System.in);
	public AdminLoginView(){
		this.adminLoginViewModel=new AdminLoginViewModel(this);
	}   
	public void getAdminDetails() {
		String name;
		String password;
		System.out.print("     Enter Admin Name :");
		name=scan.next();
		System.out.println();
		System.out.print("     Enter password :");
		password=scan.next();
		if(adminLoginViewModel.checkDetails(name,password)) {
			showFeatures(name);
		}else {
			getAdminDetails();
		}
		
	}

	private void showFeatures(String name) {
		System.out.println("\n  ---  WELCOME   "+name+"  ---  \n");
		System.out.println("  1.New Flight   ");
		System.out.println("  2.New Admin    ");
		System.out.println("  3.Delete Admin ");
		System.out.println("  9.Back         ");
		System.out.println("  0.Exit         ");
		System.out.println();
     adminLoginViewModel.selectedFeature(getSelection());
		// change price,flight timing,change route
		
	}
	public Flight getNewFlightDetails() {
		Flight newFlight=new Flight();
		System.out.print("\n    --->   Enter Flight Details   <---   \n");
		System.out.print(" Enter  depart/landing Airport : ");
		newFlight.setFrom(scan.next());
		System.out.print(" Enter  land/departing Airport : ");
		newFlight.setTo(scan.next());
		System.out.print(" Enter departTime [ HH:mm ] : ");
		String time = scan.next();
		while (!TimeValidation.timeValidation(time)) {
			System.out.print(" Enter valid Time : ");
			time = scan.next();
		}
		newFlight.setDepartTime(TimeValidation.timeFormat(time));
		System.out.print(" Enter landingTime [ HH:mm ] : ");
		 time = scan.next();
		while (!TimeValidation.timeValidation(time)) {
			System.out.print(" Enter valid Time : ");
			time = scan.next();
		}
		newFlight.setLandingTime(TimeValidation.timeFormat(time));
		System.out.print(" Enter Economy Class Price ( in Ruppes ): ");
		newFlight.setEconomyPrice(scan.nextDouble());
		System.out.print(" Enter Business Class Price ( in Ruppes ): ");
		newFlight.setBusinessPrice(scan.nextDouble());
		System.out.print(" Enter Number of seats Economy  Class : ");
		newFlight.setEconomySeats(scan.nextInt());
		System.out.print(" Enter Number of seats Business  Class : ");
		newFlight.setBusinessSeats(scan.nextInt());
		return newFlight;
	}
	void FlightSuccessMessage() {
		System.out.println(" New Flight Added Successfully ....");
	}
    void addAdminSuccessMessage() {
		System.out.println(" New Admin Added Successfully ....");
		
	}
    void DeleteAdminSuccessMessage() {
    	System.out.println(" Remove Admin Successfully..");
    }
	
}
