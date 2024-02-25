package com.natarajanthangaraj.gasrefillbooking.chatbotapplication;

import org.json.simple.JSONArray;

import com.natarajanthangaraj.gasrefillbooking.dto.Choice;

public class ChatBot {
	private Choice choice = new Choice();
	private ChatBotViewModel chatbotviewModel;
	private PrintInput print = new PrintInput();
	private UserInput userinput = new UserInput();

	public ChatBot() {
		this.chatbotviewModel = new ChatBotViewModel(this);
		chatbotviewModel.start();
	}
	
	public void getUserChoice() {
		choice.setChoice(userinput.getUserInput());
	}

	public int UserChoice() {
		return choice.getChoice();
	}

	public void getMessage(JSONArray jarr) {
		print.display(jarr);
	}

}
