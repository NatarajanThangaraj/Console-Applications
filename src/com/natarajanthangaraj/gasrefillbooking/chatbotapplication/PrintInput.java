package com.natarajanthangaraj.gasrefillbooking.chatbotapplication;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PrintInput {

	void display(JSONArray jsonArray) {
		try {
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObjct = (JSONObject) jsonArray.get(i);
			System.out.println(jsonObjct.get(Integer.toString(i)));
		}
		}catch(NullPointerException e) {
			System.out.println("Wrong Selection Enter the Correct Number ");
		}
	}
}
