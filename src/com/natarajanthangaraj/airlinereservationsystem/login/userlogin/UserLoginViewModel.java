package com.natarajanthangaraj.airlinereservationsystem.login.userlogin;

import com.natarajanthangaraj.airlinereservationsystem.application.ApplicationView;
import com.natarajanthangaraj.airlinereservationsystem.login.repository.Repository;

public class UserLoginViewModel {
	UserLoginView userLoginView;
	ApplicationView applicationView;

	public UserLoginViewModel(UserLoginView userLoginView) {
		this.userLoginView = userLoginView;
		this.applicationView = new ApplicationView();
	}

	public void selectedOperation(int select) {
		boolean result = false;
		switch (select) {
		case 0 -> {
			userLoginView.endLoginMessage();
		}
		case 1 -> {
			result = Repository.getInstance().checkDetails(userLoginView.userNamelistener(),
					userLoginView.userPassWordlistener(), "user");
			if (result) {
				userLoginView.successMessage(" User ");
				applicationView.start();
			}
		}
		case 2 -> {
			result = Repository.getInstance().newUser(userLoginView.getNewUserDetails(), "user");
			if (result) {
				userLoginView.successMessage(" User ");
				applicationView.start();
			} else {
				userLoginView.wrongUserNamePasswordMessage();
				result = Repository.getInstance().newUser(userLoginView.getNewUserDetails(), "user");
			}
		}
		case 3 -> {
			result = Repository.getInstance().deleteEntry(userLoginView.userNamelistener(),
					userLoginView.userPassWordlistener(), "user");
			if (result) {
				//System.out.println(" mission successfulla mudium");
			}
		}
		default -> {
			userLoginView.wrongSelectionMessage();
			userLoginView.showLoginDetails();
		}
		}

	}

}
