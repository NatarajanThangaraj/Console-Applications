package com.natarajanthangaraj.atm.deposit;

import com.natarajanthangaraj.atm.validate.InputHandler;

public class DepositView {
	long depositAmount;
	public DepositViewModel depositviewmodel;

	public DepositView() {
		this.depositviewmodel = new DepositViewModel(this);
	}

	public void getAmount() {
		System.out.println("\n ----   Amount Deposit   ---\n");
		System.out.print(" Enter Amount : ");
		depositAmount = InputHandler.getNumber();

	}

	public void getdepositAmount(String userID) {
		if (depositviewmodel.depositAmount(userID, depositAmount)) {
			System.out.println("\n" + "\u001B[32m" + "~***~ Amount Credited ~***~" + "\u001B[0m" + "\n");
			if(InputHandler.statement()) {
				
			}
		} else {
			System.err.println(" Last Transaction Cancelled ");
		}
	}
}
