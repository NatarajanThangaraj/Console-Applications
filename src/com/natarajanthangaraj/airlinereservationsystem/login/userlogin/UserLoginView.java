package com.natarajanthangaraj.airlinereservationsystem.login.userlogin;

import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.dto.User;
import com.natarajanthangaraj.airlinereservationsystem.login.LoginView;

public class UserLoginView extends LoginView{
	 UserLoginViewModel userLoginViewModel;
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
	
	 
	public void wrongUserNamePasswordMessage() {
		System.err.println(" Wrong UserName or PassWord ");
		
	}
}
