package com.natarajanthangaraj.cricketscoreboard;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseView {
	static final Scanner scan = new Scanner(System.in);

//	public static void main(String[] args) {
//		System.out.println(new BaseView().getNumber("hello"));
//	}

	 protected int getNumber(String message) {
		System.out.print(" Enter the " + message + " : ");

		while (true) {
			try {
				int number = scan.nextInt();
				return number;
			} catch (InputMismatchException e) {
				System.err.println(" Wrong Input !!!");
				System.out.print(" Enter valid Input : ");
				scan.nextLine();
			}

		}

	}

	 protected String getString(String message) {
		System.out.print(" Enter the "+message+" : ");
		String str = scan.next();
		return str;
	}
}
