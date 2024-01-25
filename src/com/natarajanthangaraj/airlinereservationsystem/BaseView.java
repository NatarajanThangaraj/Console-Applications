package com.natarajanthangaraj.airlinereservationsystem;

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
}