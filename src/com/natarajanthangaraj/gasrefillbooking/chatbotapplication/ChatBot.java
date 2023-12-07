package com.natarajanthangaraj.gasrefillbooking.chatbotapplication;

import java.util.Scanner;

import com.natarajanthangaraj.gasrefillbooking.chatbotapplication.addcustomer.AddCustomer;
import com.natarajanthangaraj.gasrefillbooking.customer.Customer;

public class ChatBot {
	private ChatBotViewModel chatbotviewModel;

	public ChatBot() {
		this.chatbotviewModel = new ChatBotViewModel(this);
	}

	public void userValidation() {
		Scanner scan = new Scanner(System.in);
		Customer customer = new Customer();
		do {
			System.out.print("Enter Mobile Number : ");
			customer.setMobileNumber(scan.next());
		} while (!chatbotviewModel.validate(customer));
		new Utility().introduction();
		chatbotviewModel.start();
	}

	public static void main(String[] args) {
		ChatBot chatbot = new ChatBot();
		chatbot.userValidation();
	}

}
