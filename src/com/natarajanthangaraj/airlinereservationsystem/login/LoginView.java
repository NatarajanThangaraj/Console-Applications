package com.natarajanthangaraj.airlinereservationsystem.login;

import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.Utility;

public class LoginView{
	private LoginViewModel logviewmodel;
	Scanner scan = new Scanner(System.in);

	public LoginView() {
		this.logviewmodel = new LoginViewModel(this);
	}
  public void start() {
	    System.out.println("+-----------+");
		System.out.println("| 1.Admin   |");
		System.out.println("| --------- |");
		System.out.println("| 2.User    |");
		System.out.println("+-----------+\n");
		System.out.print("Enter Correct Choice : ");
		logviewmodel.selectAdminOrUser(scan.nextInt());
	}
}
