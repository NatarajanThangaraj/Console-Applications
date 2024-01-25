package com.natarajanthangaraj.airlinereservationsystem.login.adminlogin;

import java.util.Scanner;

public class AdminLoginView {
	private AdminLoginViewModel adminLoginViewModel;
	Scanner scan=new Scanner(System.in);
	public AdminLoginView(){
		this.adminLoginViewModel=new AdminLoginViewModel(this);
	}
   
	public void getAdminDetails() {
		String name;
		String password;
		System.out.print("     Enter Admin Name :");
		name=scan.next();
		System.out.println();
		System.out.print("     Enter password :");
		password=scan.next();
//		if(adminLoginViewModel.checkDetails(name,password)) {
//			showFeatures(name);
//		}else {
//			getAdminDetails();
//		}
		
	}

//	private void showFeatures(String name) {
//		System.out.println();
//		System.out.println("  ---  WELCOME   "+name+"  ---  ");
//		System.out.println();
//		System.out.println("  1.New Flight  ");
//		System.out.println("  2.New Admin   ");
//		System.out.println();
//		// change price,flight timing,change route
//		
//	}
}
