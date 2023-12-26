package com.natarajanthangaraj.atm.deposit;

import java.util.Scanner;

public class DepositView {
	Scanner scan = new Scanner(System.in);
	public  DepositViewModel depositviewmodel;
	 public DepositView(){
		 this.depositviewmodel=new  DepositViewModel(this);
	 }
	public Long getAmount() {
		System.out.println("\n ----   Amount Deposit   ---\n");
		System.out.print(" Enter Amount : ");
		Long amount = scan.nextLong();
		return amount;
	}
	public void getdepositAmount(String userID) {
		if(depositviewmodel.depositAmount(userID,getAmount())) {
			System.out.println("\n Amount Credited \n");
		}else {
			System.out.println(" Last Transaction Cancelled ");
		}
	}
}
