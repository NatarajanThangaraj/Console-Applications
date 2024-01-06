package com.natarajanthangaraj.atm.withdrawel;

import com.natarajanthangaraj.atm.validate.InputHandler;

public class WithdrawelView {

	private WithdrawelViewModel withdrawviewmodel;

	public WithdrawelView() {
		this.withdrawviewmodel = new WithdrawelViewModel(this);
	}

	public Long getAmount() {
		System.out.println("\n " + "\u001B[32m" + "----   Cash WithDrawel   ---" + "\u001B[0m" + "\n");
		System.out.print(" Enter Amount : ");
		Long amount = InputHandler.getNumber();
		return amount;
	}

	public void getWithdrawAmount(String userID) {
		if (withdrawviewmodel.possibleForWithdraw(userID, getAmount())) {
			System.out.println("\n" + "\u001B[32m" + "Please collect the Cash !" + "\u001B[0m" + "\n");
		} else {
			System.err.println("\n Insufficient Balance...  \n ");
		}
	}
}
