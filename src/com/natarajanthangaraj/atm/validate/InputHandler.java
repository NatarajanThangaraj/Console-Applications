package com.natarajanthangaraj.atm.validate;

import java.util.Scanner;

public class InputHandler {
	static Scanner scan = new Scanner(System.in);

	public static long getNumber() {
		while (true) {
			try {
				long n = scan.nextLong();
				return n;
			} catch (Exception e) {
				System.out.print(" Enter Valid Input : ");
				scan.nextLine();
			}
		}
	}

	public static String getStringValue() {
		return scan.next();
	}

	public static int getChoice() {
		while (true) {
			try {
				int n = scan.nextInt();
				return n;
			} catch (Exception e) {
				System.out.println(" Enter valid choice : ");
				scan.nextLine();
			}
		}
	}

	public static boolean statement() {
		System.out.println("\n  Do You Want Statement ?  \n");
		System.out.println("\n  1.YES           0.NO      \n");
		System.out.print("Enter Choice : ");
		int select = getChoice();
		if (select == 1) {
			return true;
		} else {
			return false;
		}
	}
}
