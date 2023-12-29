package com.natarajanthangaraj.atm.atmapplication;

import java.util.Scanner;

import com.natarajanthangaraj.atm.dto.CardDetails;

public class ATMApplicationview {
	Scanner scan = new Scanner(System.in);
	private ATMApplicationViewModel atmviewmodel;

	public ATMApplicationview() {
		this.atmviewmodel = new ATMApplicationViewModel(this);
	}

	public void insertCard() {
		CardDetails carddetail = new CardDetails();
		System.out.print(" Enter 16 - digit card Number : ");
		carddetail.setATMCardNumber(scan.next());
		System.out.print(" Enter Pin Number : ");
		carddetail.setPinNumber(scan.nextLong());
		if (atmviewmodel.formatValidate(carddetail)) {
			atmviewmodel.datavalidate(carddetail);
		}else {
			errorMessage();
		}
	}

	public void printMenu() {
		System.out.println(" \n\t ~*~    Welcome to CANARA Bank ~*~ \t\n");
		System.out.println(" +-------------------------------+");
		System.out.println(" |  1.Deposit                    |");
		System.out.println(" |  2.Withdrawal                 |");
		System.out.println(" |  3.Balance Enquiry           |");
		System.out.println(" |  0.Cancel                     |");
		System.out.println(" +-------------------------------+\n");

	}

	public int userSelection() {
		System.out.print("Enter the choice : ");
		int select = scan.nextInt();
		return select;
	}

	public void errorMessage() {
		System.err.println("\t\t Wrong PIN or CARD NUMBER \t\t  \n Last Transaction Cancelled...\n");
	}

}
