package com.natarajanthangaraj.airlinereservationsystem.login;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.natarajanthangaraj.airlinereservationsystem.dto.User;

public class LoginView{
	  Scanner scan = new Scanner(System.in);
	 LoginViewModel logviewmodel;
  public void start() {
	  this.logviewmodel = new LoginViewModel(this);
	    System.out.println("+-----------+");
		System.out.println("| 1.Admin   |");
		System.out.println("| --------- |");
		System.out.println("| 2.User    |");
		System.out.println("+-----------+\n");
		System.out.print("Enter Correct Choice : ");
		logviewmodel.selectAdminOrUser(scan.nextInt());
	}
 public User getNewUserDetails() {
		User newUser=new User();
		System.out.println();
		System.out.print(" Enter Your Name : "); //yet to validate
		newUser.setUserName(scan.next());
		System.out.print(" Enter PassWord : ");
		newUser.setPassWord(scan.next());
		System.out.print(" Enter Gmail Address : ");
		newUser.setgMail(scan.next());
		System.out.print(" Enter  Mobile Number : ");
		newUser.setMobileNumber(scan.next());
		return newUser;
		
	}
    protected int getSelection() {
    	int select=0;
    	while(true) {
    	try {
		System.out.print(" Enter Choice : ");
		select=scan.nextInt();
		return select;
    	}catch(InputMismatchException e) {
    		System.out.print(" Please Enter Valid Choice : ");
    	}
    	}
	}
   public String userNamelistener() {
	  System.out.print(" Enter Name : ");
	  return scan.next();
  }
  public String userPassWordlistener() {
	  System.out.print(" Enter passWord : ");
	  return scan.next();
  }
  public void endLoginMessage() {
	  System.out.println("\n\t  Thank you  !!! Have a Good Day \t\n");
	  
  }
  public void wrongSelectionMessage() {
	  System.err.println("\t Enter Valid Input \t");
  }
  public void successMessage(String person) {
	  System.out.println(" Welcome "+person+" to our AirLine Services ");
  }
}
