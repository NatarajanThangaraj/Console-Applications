package com.natarajanthangaraj.airlinereservationsystem.login.adminlogin;

import com.natarajanthangaraj.rolehierarchy.Utility;

public class AdminLoginView {
	private AdminLoginViewModel adminloginviewmodel;
	AdminLoginView(){
		this.adminloginviewmodel=new AdminLoginViewModel(this);
	}
   
	void showLoginFeatures() {
		String name;
		String password;
		System.out.print("     Enter Admin Name :");
		name=Utility.getStringInput();
		System.out.println();
		System.out.print("     Enter password :");
		password=Utility.getStringInput();
		//checkDetails(name,password);
		
	}
}
