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
		System.out.print("Enter Mobile Number : ");
		customer.setMobileNumber(scan.next());
		if (chatbotviewModel.validate(customer)) {
			isValidMobileNumber();
		} else {
			invalidMobileNumber();
		}

	}

	void isValidMobileNumber()  {
	new	Utility().introduction();
	chatbotviewModel.start();
	}

	void invalidMobileNumber() {
		System.out.println("Invalid Mobile Number");
	}
	public static void main(String[] args) {
		ChatBot chatbot=new ChatBot();
		chatbot.userValidation();
	}
	
}
