package com.natarajanthangaraj.airlinereservationsystem.login.userlogin;

import java.util.Scanner;

public class UserLoginView {
	private UserLoginViewModel userLoginViewModel;
	Scanner scan=new Scanner(System.in);
	public UserLoginView() {
		this.userLoginViewModel = new UserLoginViewModel(this);
	}
	public void showLoginDetails() {
		System.out.println(" !!!  HELLO USER !!!");
		System.out.println();
		System.out.println(" 1. Already have an account ?");
		System.out.println(" 2. New User ");
		System.out.println(" 3. Delte  Account ");
		System.out.println(" 0. Exit ");
		System.out.println();
		userLoginViewModel.selectedOperation(getSelection());
		
	}
	 void getNewUserDetails() {
		String name;
		String password;
		String gMail;
		String mobileNumber;
		System.out.println();
		System.out.print(" Enter Your Name : "); //yet to validate
		name=scan.next();
		System.out.print(" Enter PassWord : ");
		password=scan.next();
		System.out.print(" Enter Gmail Address : ");
		password=scan.next();
		System.out.print(" Enter  Mobile Number : ");
		password=scan.next();
		
	}
	int getSelection() {
		System.out.println(" Enter your Selection : ");
		return scan.nextInt();
	}
}
