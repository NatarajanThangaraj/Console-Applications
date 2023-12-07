package com.natarajanthangaraj.gasrefillbooking.chatbotapplication.addcustomer;

import java.util.Scanner;

import com.natarajanthangaraj.gasrefillbooking.customer.Customer;

public class AddCustomer {
	private AddCustomerViewModel addcustomervm;

	public AddCustomer() {
		this.addcustomervm = new AddCustomerViewModel(this);
	}

	public  void getCustomerDetails() {
		Scanner scan = new Scanner(System.in);
		Customer customer = new Customer();
		System.out.print("Enter your Name : ");
		customer.setName(scan.next());
		System.out.print("Enter your Age : ");
		customer.setAge(scan.nextByte());
		                scan.nextLine();
		System.out.print("Enter your Address : ");
		customer.setAddress(scan.nextLine());
		System.out.print("Enter your Mobile Number : ");
		customer.setMobileNumber(scan.next());
		System.out.print("Enter your Aadhar Number : ");
		customer.setAadharNumber(scan.nextLong());
		System.out.print("Enter your Pin Code : ");
		customer.setPincode(scan.nextInt());
	
		addcustomervm.storeCustomerDetails(customer);
	}
}
