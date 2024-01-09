package com.natarajanthangaraj.atm.withdrawel;

import com.natarajanthangaraj.atm.validate.InputHandler;

public class WithdrawelView {
	private long withdrawAmount;
	private WithdrawelViewModel withdrawviewmodel;

	public WithdrawelView() {
		this.withdrawviewmodel = new WithdrawelViewModel(this);
	}

	public void getAmount() {
		System.out.println("\n " + "\u001B[32m" + "----   Cash WithDrawel   ---" + "\u001B[0m" + "\n");
		System.out.print(" Enter Amount : ");
		withdrawAmount = InputHandler.getNumber();

	}

	public void getWithdrawAmount(String userID) {
		if (withdrawviewmodel.possibleForWithdraw(userID, withdrawAmount)) {
			System.out.println("\n" + "\u001B[32m" + "Please collect the Cash !" + "\u001B[0m" + "\n");
		} else {
			System.err.println("\n Insufficient Balance...  \n ");
		}
	}
}
