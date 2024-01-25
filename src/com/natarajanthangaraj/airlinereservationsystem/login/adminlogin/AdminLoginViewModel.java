package com.natarajanthangaraj.airlinereservationsystem.login.adminlogin;

import com.natarajanthangaraj.airlinereservationsystem.login.repository.Repository;

public class AdminLoginViewModel {
   private AdminLoginView adminloginview;
	public AdminLoginViewModel(AdminLoginView adminLoginView) {
		this.adminloginview=adminLoginView;
	}
	public boolean checkDetails(String name, String password) {
		return Repository.getInstance().checkDetails(name, password, "admin");	
	}

}
