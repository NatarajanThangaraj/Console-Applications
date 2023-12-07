package com.natarajanthangaraj.gasrefillbooking.distributor.customerdetails;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class Repository {
	private static Repository repo;

	private Repository() {
	}

	public static Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
		}
		return repo;
	}
	public void writeJsonToFile( JSONObject jsonObject) {
		String path = "C:\\Users\\ELCOT\\eclipse-workspace\\Console_Applications\\src\\com\\natarajanthangaraj\\gasrefillbooking\\distributor\\customerdetails\\CustomerDetails.json";
		try (FileWriter fileWriter = new FileWriter(path)) {
			fileWriter.write(jsonObject.toString()); // Use 2 for pretty printing
			System.out.println("Customer added successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
