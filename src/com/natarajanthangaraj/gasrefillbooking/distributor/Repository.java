package com.natarajanthangaraj.gasrefillbooking.distributor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

	public JSONArray parse(String path)  {
		JSONParser par = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) par.parse(new FileReader(
					"C:\\Users\\ELCOT\\eclipse-workspace\\Console_Applications\\src\\com\\natarajanthangaraj\\gasrefillbooking\\distributor\\Data.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray arr = (JSONArray) obj.get(path);
		return arr;
	}
}
