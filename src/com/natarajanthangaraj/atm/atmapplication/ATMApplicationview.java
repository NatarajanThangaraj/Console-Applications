package com.natarajanthangaraj.atm.atmapplication;
import com.natarajanthangaraj.atm.dto.CardDetails;
import com.natarajanthangaraj.atm.validate.InputHandler;

public class ATMApplicationview {
	
	private ATMApplicationViewModel atmviewmodel;
	CardDetails carddetail = new CardDetails();
	public ATMApplicationview() {
		this.atmviewmodel = new ATMApplicationViewModel(this);
	}

	public void insertCard() {
		System.out.println("  ~*~ Insert the ATM CARD ~*~");
		System.out.print(" Enter 16 - digit card Number : ");
		carddetail.setATMCardNumber(InputHandler.getStringValue());
		System.out.print(" Enter Pin Number : ");
		carddetail.setPinNumber(InputHandler.getNumber());
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
		System.out.println(" |  3.Balance Enquiry            |");
		System.out.println(" |  4.Change Pin Number          |");
		System.out.println(" |  0.Cancel                     |");
		System.out.println(" +-------------------------------+\n");

	}

	public int userSelection() {
		System.out.print("Enter the choice : ");
		int select = InputHandler.getChoice();
		return select;
	}

	public void errorMessage() {
		System.err.println("\t\t Wrong PIN or CARD NUMBER \t\t  \n Last Transaction Cancelled...\n");
	}
	

}
