package com.natarajanthangaraj.rolehierarchy;

import java.util.Scanner;

public class Utility {
	static Scanner scan = new Scanner(System.in);

	public static String getStringInput() {
		String str = scan.next();
		return str;

	}

	public static int getNumericValue() {
		int number = scan.nextInt();
		return number;
	}
}
