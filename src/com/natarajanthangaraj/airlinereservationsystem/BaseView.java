package com.natarajanthangaraj.airlinereservationsystem;

import java.util.Random;
import java.util.Scanner;

public class BaseView {
	Scanner scan = new Scanner(System.in);

	public int getInt() {
		while (true) {
			try {
				int n = scan.nextInt();
				return n;
			} catch (Exception e) {
				System.err.println("Invalid Input !!! ");
				System.out.print("Enter the Valid Input : ");
				scan.nextLine();
			}
		}
	}
	public  int getTicketNumber() {
		System.out.print(" Enter the Ticket Number : ");
		int ticketNumber ;
		while (true) {
			try {
				ticketNumber = scan.nextInt();
				return ticketNumber;
			} catch (Exception e) {
				System.err.println("Invalid Input !!! ");
				System.out.print("Enter the Valid Input : ");
				scan.nextLine();
			}
		}
		
	}
	public String getFlightNumber() {
		System.out.print(" Enter Flight Number : ");
		while(true) {
		String flightNumber=scan.next();
		if( flightNumber.matches("^AI-\\d{3}$")) {
			return flightNumber;
		}else {
			System.out.println(" Enter Correct Flight Number ");
		}
	 	
		}
	}
	public String getTicketNumber(String flightNum) {
		Random random = new Random();
		char l1 = (char) ('a' + random.nextInt(25));
		int l2 = random.nextInt(10);
		return l1 + "" + l2 + flightNum.substring(flightNum.length() - 3);
	}
}