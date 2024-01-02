package com.natarajanthangaraj.airlinereservationsystem;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Utility {
	static Scanner scan=new Scanner(System.in);
	static LocalDateTime obj=LocalDateTime.now();
	public static String getPassengerType(int select) {
		if(select==1) {
			return "Adult";
		}else if (select==2) {
			return "Children";
		}else {
			return null;
		}
		
		}
		
	public static String getCategory(int select) {
		if(select==1) {
			return "Economy";
		}else if (select==2) {
			return "Business";
		}else {
			return null;
		}
		}
		
	public static String currentDate() {
		
		return obj.toString();
	}
	public static int getInteger() {
		while(true) {
			try {
				int n=scan.nextInt();
				return n;
			}catch(Exception e) {
				System.err.println("Invalid Input !!! ");
				System.out.print("Enter the Valid Input : ");
				scan.nextLine();
			}
		}
	}
}
