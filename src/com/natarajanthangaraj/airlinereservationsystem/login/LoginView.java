package com.natarajanthangaraj.airlinereservationsystem.login;

import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.Utility;

public class LoginView{
	private LoginViewModel logviewmodel;
	Scanner scan = new Scanner(System.in);

	public LoginView() {
		//this.logviewmodel = new LoginViewModel(this);
	}
  void start() {
	    System.out.print("+-----------+");
		System.out.print("|  1.Admin  |");
		System.out.print("  --------- |");
		System.out.print("|  2.User   |");
		System.out.print("+-----------+\n");
		System.out.print("Enter Correct Choice : ");
		//logviewmodel.selectAdminOrUser(Utility.getInteger());
	}
}
