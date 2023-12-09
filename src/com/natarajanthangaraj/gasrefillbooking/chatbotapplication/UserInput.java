package com.natarajanthangaraj.gasrefillbooking.chatbotapplication;

import java.util.Scanner;

public class UserInput {

	Scanner scan = new Scanner(System.in);

	public int getUserInput() {
		System.out.print("Enter your Choice : ");
		int input = scan.nextInt();
		return input;
	}
}
