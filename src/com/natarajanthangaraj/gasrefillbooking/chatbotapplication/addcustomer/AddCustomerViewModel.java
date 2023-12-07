package com.natarajanthangaraj.gasrefillbooking.chatbotapplication.addcustomer;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import com.natarajanthangaraj.gasrefillbooking.customer.Customer;
import com.natarajanthangaraj.gasrefillbooking.distributor.customerdetails.Repository;

public class AddCustomerViewModel {
	private AddCustomer addnew;
	private JSONObject mainJson = new JSONObject();
	private JSONObject personJson = new JSONObject();

	public AddCustomerViewModel(AddCustomer addCustomer) {
		this.addnew = addCustomer;
	}

	@SuppressWarnings("unchecked")
	public void storeCustomerDetails(Customer customer) {
		personJson.put("Name", customer.getName());
		personJson.put("Age", customer.getAge());
		personJson.put("Address", customer.getAddress());
		personJson.put("Pin Code", customer.getPincode());
		personJson.put("Aadhar Number", customer.getAadharNumber());
		mainJson.put(customer.getMobileNumber(), personJson);

		// Write the JSON data to a file
		Repository.getInstance().writeJsonToFile(mainJson);
	}

}
