package com.natarajanthangaraj.atm.deposit;

import com.natarajanthangaraj.atm.validate.InputHandler;

public class DepositView {

	public DepositViewModel depositviewmodel;

	public DepositView() {
		this.depositviewmodel = new DepositViewModel(this);
	}

	public long getAmount() {
		System.out.println("\n ----   Amount Deposit   ---\n");
		System.out.print(" Enter Amount : ");
		long amount = InputHandler.getNumber();
		return amount;
	}

	public void getdepositAmount(String userID) {
		if (depositviewmodel.depositAmount(userID, getAmount())) {
			System.out.println("\n" + "\u001B[32m" + "~***~ Amount Credited ~***~" + "\u001B[0m" + "\n");
		} else {
			System.err.println(" Last Transaction Cancelled ");
		}
	}
}
