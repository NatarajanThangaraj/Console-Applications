package com.natarajanthangaraj.airlinereservationsystem;

import com.natarajanthangaraj.airlinereservationsystem.DisplayTicket.DisplayTicketView;
import com.natarajanthangaraj.airlinereservationsystem.application.ApplicationView;
import com.natarajanthangaraj.airlinereservationsystem.consoleinputhandler.DateValidation;
import com.natarajanthangaraj.airlinereservationsystem.dto.Passenger;
import com.natarajanthangaraj.airlinereservationsystem.login.LoginView;
import com.natarajanthangaraj.airlinereservationsystem.reservation.ReservationView;

public class Main {

	public static void main(String[] args) {
//		DisplayTicketView ticketView=new DisplayTicketView();
		ApplicationView appview =new ApplicationView();
//		LoginView loginView=new LoginView();
//		loginView.start();
		appview.start();
		//ticketView.showTicket(ticketView.getTicketNumber());
//		ReservationView obj=new ReservationView();
//		obj.userSearch();
		
}
}
