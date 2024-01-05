package com.natarajanthangaraj.rolehierarchy;

import java.util.Scanner;

public class Utility {
	public static final String color="\u001B[32m" ;
	static Scanner scan = new Scanner(System.in);

	public static String getStringInput() {
		String str = scan.next();
		return str;

	}

	public static int getNumericValue() {
		while(true) {
		try {
		int number = scan.nextInt();
		return number;
		}catch(Exception e) {
			System.out.print(" Enter valid choice : ");
			scan.nextLine();
		}
		}
	}
}
