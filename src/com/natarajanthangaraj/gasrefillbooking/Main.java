package com.natarajanthangaraj.gasrefillbooking;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Main {
	Stack<String> stack = new Stack();

	public static void main(String[] args) throws Exception {
		Main chatBot = new Main();
		chatBot.start();
	}
	

	private void start() throws Exception {
		int select;
		introduction();
		stack.push("Press");
		display(parse("Press"));
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
			navigation();
			}catch(Exception e) {
				System.out.println("Wrong Select ...Please Select Correct Number !");
			}
		} while (select != 0);
		conclusion();
	}

	private void display(JSONArray jsonArray) {
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObjct = (JSONObject) jsonArray.get(i);
			System.out.println(jsonObjct.get(Integer.toString(i)));
		}
	}

	private JSONArray parse(String path) throws Exception {
		JSONParser par = new JSONParser();
		JSONObject obj = (JSONObject) par.parse(new FileReader(
				"C:\\Users\\ELCOT\\git\\Array\\ZSGS\\src\\com\\natarajanthangaraj\\problemsolving\\chatbot\\Data.json"));
		JSONArray arr = (JSONArray) obj.get(path);
		return arr;
	}

	private static void introduction() {
		System.out.println("   * = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("   |                                                                  |");
		System.out.println("   |     WELCOME TO 24*7 INDANE AUTOMATED REFILL BOOKING SYSTEM       |");
		System.out.println("   |                                                                  |");
		System.out.println("   |            --- Your's Distributor : PRIYA GAS AGENCY ---         |");
		System.out.println("   |                                                                  |");
		System.out.println("   * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * =");
	}

	private static void navigation() {
		System.out.println();
		System.out.println("<----  Press 9 to go back  ---->");
		System.out.println("****  Press 0 to Exit  ****");
		System.out.println();
	}

	private static void conclusion() {
		System.out.println();
		System.out.println("FOR MORE DETAILS CONTACT YOUR DISTRIBUTOR ");
		System.out.println("#####          THANK YOU FOR CHOOSING INDANE        #####");
		System.out.println();
	}
}
