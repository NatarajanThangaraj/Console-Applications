
package com.natarajanthangaraj.gasrefillbooking.chatbotapplication;

import java.util.Stack;
import com.natarajanthangaraj.gasrefillbooking.distributor.Repository;

public class ChatBotViewModel {
	private ChatBot chatbot;
	Utility utility = new Utility();
	Stack<String> stack = new Stack<String>();

	
	public ChatBotViewModel(ChatBot chatBot) {
		this.chatbot=chatBot;
	}

	public void start()  {
		int select;
		String path;
		utility.introduction();
		stack.push("Press");
		chatbot.getMessage(Repository.getInstance().parse("Press"));
		do {
			chatbot.getUserChoice();
			select=chatbot.UserChoice();
			
			if (select == 9) {
				stack.pop();
				if (stack.isEmpty()) {
					break;
				}
			} else if (select == 0) {
				break;
			} else {
				stack.push(stack.peek() + "_" + select);
			}
			 path = stack.peek();
			chatbot.getMessage(Repository.getInstance().parse(path));
			utility.navigation();
		} while (select != 0);
		utility.conclusion();
	}

	
	

}
