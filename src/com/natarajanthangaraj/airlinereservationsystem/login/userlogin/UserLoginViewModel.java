package com.natarajanthangaraj.airlinereservationsystem.login.userlogin;

public class UserLoginViewModel {
	UserLoginView userLoginView;

	public UserLoginViewModel(UserLoginView userLoginView) {
		this.userLoginView = userLoginView;
	}

	public void selectedOperation(int select) {
		switch(select) {
		case 1->{
			userLoginView.getNewUserDetails();
		}
		}
		
	}

}
