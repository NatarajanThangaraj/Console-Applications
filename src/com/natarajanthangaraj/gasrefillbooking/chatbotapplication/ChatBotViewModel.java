package com.natarajanthangaraj.gasrefillbooking.chatbotapplication;

import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.natarajanthangaraj.gasrefillbooking.customer.Customer;

public class ChatBotViewModel {
	private ChatBot chatbot;
	Utility utility = new Utility();
	Stack<String> stack = new Stack();

	public ChatBotViewModel(ChatBot chatBot) {
		this.chatbot = chatBot;
	}

	public boolean validate(Customer customer) {
		Pattern pattern = Pattern.compile("^[0-9]{10}$");
		Matcher matcher = pattern.matcher(customer.getMobileNumber());
		return matcher.matches();
	}

	public void start()  {
		int select;
		stack.push("Press");
		try {
			display(parse("Press"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println();
			System.out.print("Enter your Option :");
			select = scan.nextInt();
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
			String path = stack.peek();
			try {
				display(parse(path));
				utility.navigation();
			} catch (Exception e) {
				System.out.println("Wrong Select ...Please Select Correct Number !");
			}
		} while (select != 0);
		utility.conclusion();
	}

	private JSONArray parse(String path) throws Exception {
		JSONParser par = new JSONParser();
		JSONObject obj = (JSONObject) par.parse(new FileReader(
				"C:\\Users\\ELCOT\\eclipse-workspace\\Console_Applications\\src\\com\\natarajanthangaraj\\gasrefillbooking\\distributor\\Data.json"));
		JSONArray arr = (JSONArray) obj.get(path);
		return arr;
	}
	private void display(JSONArray jsonArray) {
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObjct = (JSONObject) jsonArray.get(i);
			System.out.println(jsonObjct.get(Integer.toString(i)));
		}
	}

}
