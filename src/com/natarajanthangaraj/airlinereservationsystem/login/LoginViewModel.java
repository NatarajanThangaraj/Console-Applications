package com.natarajanthangaraj.airlinereservationsystem.login;

import com.natarajanthangaraj.airlinereservationsystem.login.adminlogin.AdminLoginView;
import com.natarajanthangaraj.airlinereservationsystem.login.userlogin.UserLoginView;

public class LoginViewModel {
	 LoginView loginView;
	 AdminLoginView adminLogin;
	 UserLoginView userLogin;

	public LoginViewModel(LoginView loginView) {
		this.loginView = loginView;
		this.adminLogin = new AdminLoginView();
		this.userLogin = new UserLoginView();
	}

	public void selectAdminOrUser(int choice) {
		switch (choice) {
		case 1 -> {
			adminLogin.getAdminDetails();
		}
		case 2 -> {
			userLogin.showLoginDetails();
		}
		default -> {
			loginView.start();
		}
		}

	}

}
