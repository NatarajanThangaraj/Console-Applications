package com.natarajanthangaraj.gasrefillbooking.chatbotapplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.natarajanthangaraj.gasrefillbooking.customer.Customer;

public class ChatBotViewModel {
	private ChatBot chatbot;

	public ChatBotViewModel(ChatBot chatBot) {
		this.chatbot = chatBot;
	}

	public boolean validate(Customer customer) {
		Pattern pattern=Pattern.compile("^[0-9]{10}$");
		Matcher matcher=pattern.matcher(customer.getMobileNumber());
		return matcher.matches();
	}

}
