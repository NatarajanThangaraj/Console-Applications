package com.natarajanthangaraj.airlinereservationsystem;

import com.natarajanthangaraj.airlinereservationsystem.application.ApplicationView;
import com.natarajanthangaraj.airlinereservationsystem.login.LoginView;

public class Main {

	public static void main(String[] args) {
		ApplicationView appview =new ApplicationView();
		LoginView loginView=new LoginView();
		loginView.start();
	}

}
