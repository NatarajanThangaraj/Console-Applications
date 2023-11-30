package com.natarajanthangaraj.gasrefillbooking.chatbotapplication;

import java.util.Scanner;

import com.natarajanthangaraj.gasrefillbooking.customer.Customer;

public class ChatBot {
	private ChatBotViewModel chatbotviewModel;

	public ChatBot() {
		this.chatbotviewModel = new ChatBotViewModel(this);
	}

	public void userValidation() {
		Scanner scan = new Scanner(System.in);
		Customer customer = new Customer();
		customer.setMobileNumber(scan.next());
		if (chatbotviewModel.validate(customer)) {
			isValidMobileNumber();
		} else {
			invalidMobileNumber();
		}

	}

	void isValidMobileNumber() {

	}

	void invalidMobileNumber() {

	}
}
