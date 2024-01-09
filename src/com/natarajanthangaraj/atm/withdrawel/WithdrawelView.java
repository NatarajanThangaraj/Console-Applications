package com.natarajanthangaraj.atm.withdrawel;

import com.natarajanthangaraj.atm.statement.Statement;
import com.natarajanthangaraj.atm.validate.InputHandler;

public class WithdrawelView {
	private long withdrawAmount;
	private WithdrawelViewModel withdrawviewmodel;
    Statement statement;
	public WithdrawelView() {
		this.withdrawviewmodel = new WithdrawelViewModel(this);
		this.statement=new Statement();
	}

	public long getAmount() {
		System.out.println("\n " + "\u001B[32m" + "----   Cash WithDrawel   ---" + "\u001B[0m" + "\n");
		System.out.print(" Enter Amount : ");
		withdrawAmount = InputHandler.getNumber();
		return withdrawAmount;
	}

	public void getWithdrawAmount(String userID) {
		if (withdrawviewmodel.possibleForWithdraw(userID, getAmount())) {
			System.out.println("\n" + "\u001B[32m" + "Please collect the Cash !" + "\u001B[0m" + "\n");
			if (InputHandler.statement()) {
				
				statement.getStatement(" Deposit", userID, withdrawAmount);
			}
		} else {
			System.err.println("\n Insufficient Balance...  \n ");
		}
	}
}
