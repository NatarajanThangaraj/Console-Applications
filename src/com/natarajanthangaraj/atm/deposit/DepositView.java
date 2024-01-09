package com.natarajanthangaraj.atm.deposit;

import com.natarajanthangaraj.atm.statement.Statement;
import com.natarajanthangaraj.atm.validate.InputHandler;

public class DepositView {
	long depositAmount;
	public DepositViewModel depositviewmodel;
	public Statement statement;

	public DepositView() {
		this.depositviewmodel = new DepositViewModel(this);
		this.statement = new Statement();
	}

	public long getAmount() {
		System.out.println("\n ----   Amount Deposit   ---\n");
		System.out.print(" Enter Amount : ");
		depositAmount = InputHandler.getNumber();
		return depositAmount;
	}

	public void getdepositAmount(String userID) {
		if (depositviewmodel.depositAmount(userID,getAmount())) {
			System.out.println("\n" + "\u001B[32m" + "~***~ Amount Credited ~***~" + "\u001B[0m" + "\n");
			if (InputHandler.statement()) {
				statement.getStatement(" Deposit", userID, depositAmount);
			}
		} else {
			System.err.println(" Last Transaction Cancelled ");
		}
	}
}
