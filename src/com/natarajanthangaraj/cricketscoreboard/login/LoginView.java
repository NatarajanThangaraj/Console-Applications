package com.natarajanthangaraj.cricketscoreboard.login;

import com.natarajanthangaraj.cricketscoreboard.BaseView;
import com.natarajanthangaraj.cricketscoreboard.application.ApplicationView;

public class LoginView extends BaseView {
	public LoginViewModel loginViewModel;
	public ApplicationView application = new ApplicationView();

	public LoginView() {
		this.loginViewModel = new LoginViewModel(this);
	}

	public void start() {
		welcomeAddress();
		loginFeatures();

	}

	private void loginFeatures() {
		System.out.println("+----------------------+");
        System.out.println("|   1 . SIGN IN        |");
        System.out.println("|   2 . SIGN UP        |");
        System.out.println("|   3 . EXIT           |");
        System.out.println("+----------------------+");
		selectedAction();
	}

	private void selectedAction() {
		int choice = getNumber("Choice");
		boolean result;
		switch (choice) {
		case 1 -> {
			String userName = getString("user name");
			String passWord = getString("password");
			result = loginViewModel.checkUser(userName, passWord);
			if (result) {
				application.start();
			} else {
				System.err.println(" Invalid userName or Password !!!");
				System.out.println(" kindly  sign in");
				loginFeatures();
			}
		}
		case 2 -> {
			result=loginViewModel.addUser(loginListener());
			if(result) {
				application.start();
			}
		}
		case 3 -> {

		}
		default -> {
			System.err.println(" Wrong Choosen ....");
			selectedAction();
		}
		}

	}

	private User loginListener() {
		User user=new User();
		// yet to validate
		user.setUserName(getString(" Name "));
		user.setPassWord(getString(" password"));
		user.seteMail(getString(" GMail Address"));
		user.setMobileNumber(getString(" Mobile Number"));
		return user;
	}

	private void welcomeAddress() {
		System.out.println("***         WELCOME TO DADA SCORING APPLICATION        ***");

	}

	
	
}
