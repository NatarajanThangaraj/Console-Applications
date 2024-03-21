package com.natarajanthangaraj.calltaxibookingapplication.utillity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	 static Scanner scan=new Scanner(System.in);
	 static int getNumber(String message) {
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

		public static String getString(String message) {
			System.out.print(" Enter the "+message+" : ");
			String str = scan.next();
			return str;
		}
}
