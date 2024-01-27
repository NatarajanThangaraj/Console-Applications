package com.natarajanthangaraj.airlinereservationsystem.login.adminlogin;

import com.natarajanthangaraj.airlinereservationsystem.Utility;
import com.natarajanthangaraj.airlinereservationsystem.login.repository.Repository;

public class AdminLoginViewModel {
   private AdminLoginView adminLoginView;
	public AdminLoginViewModel(AdminLoginView adminLoginView) {
		this.adminLoginView=adminLoginView;
	}
	public boolean checkDetails(String name, String password) {
		return Repository.getInstance().checkDetails(name, password, "admin");	
	}
	public void selectedFeature(int select) {
		boolean result;
		switch(select) {
		case 1->{
			result=Repository.getInstance().flightInstaller( Utility.flightNumberGenerator(), 
					                                         adminLoginView.getNewFlightDetails());
			if(result) {
				adminLoginView.FlightSuccessMessage();
			}
		}
		case 2->{
			result=Repository.getInstance().newUser(adminLoginView.getNewUserDetails(), "admin");
			if(result) {
				adminLoginView.addAdminSuccessMessage();
			}
		}
		case 3->{
			result=Repository.getInstance().deleteEntry(adminLoginView.userNamelistener(),
					                                    adminLoginView.userPassWordlistener(), "admin");
			if(result) {
				adminLoginView.DeleteAdminSuccessMessage();
			}
		}
		case 9->{
			adminLoginView.getAdminDetails();
		}
		case 0->{
			adminLoginView.endLoginMessage();
		}
		}
		
		
	}

}

