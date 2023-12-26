package com.natarajanthangaraj.atm.withdrawel;

import java.util.Scanner;

public class WithdrawelView {
	Scanner scan=new Scanner(System.in);
	private WithdrawelViewModel withdrawviewmodel;
	public  WithdrawelView () {
		this.withdrawviewmodel=new WithdrawelViewModel(this);
	}
	public Long getAmount() {
		System.out.println("\n ----   Cash WithDrawel   ---\n");
		System.out.print(" Enter Amount : ");
		Long amount = scan.nextLong();
		return amount;
	}
	public void getWithdrawAmount(String userID) {
		if(withdrawviewmodel.possibleForWithdraw(userID, getAmount())) {
			System.out.println("\n Please collect the Cash ! \n");
		}else {
			System.out.println("\n Insufficient Balance...  \n ");
		}
	}
}
