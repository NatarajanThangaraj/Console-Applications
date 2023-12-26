package com.natarajanthangaraj.atm.repository;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.natarajanthangaraj.atm.dto.CardDetails;

public class Repository {
	private static Repository repo;
	String path="C:\\Users\\ELCOT\\eclipse-workspace\\Console_Applications\\src\\com\\natarajanthangaraj\\atm\\repository\\BankAccounts.json";
	private Repository() {

	}

	public static Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
		}
		return repo;
	}

	public boolean validation(CardDetails carddetail) {
		JSONObject object=(JSONObject) fileParser().get(carddetail.getATMCardNumber());
		return object.get("PinNumber").equals(carddetail.getPinNumber());
	}
	JSONObject fileParser() {
		JSONParser parser = new JSONParser();
		JSONObject object = null;
		try {
			object = (JSONObject) parser.parse(new FileReader(path));
		} catch (Exception e) {
			System.out.println("Problem on DataBase");
		}
		return object;
	}

	@SuppressWarnings("unchecked")
	public void isDeposited(String userId, Long amount) {
		JSONObject file=fileParser();
		JSONObject account=(JSONObject)file.get(userId);
		account.put("Amount",(Double) account.get("Amount")+amount);
		fileWriter(file,path);
	}
	void fileWriter(JSONObject jsonobject, String path) {
		try (FileWriter fileWriter = new FileWriter(path)) {
			fileWriter.write(jsonobject.toJSONString());
		} catch (Exception e) {
		}
	}

	@SuppressWarnings("unchecked")
	public boolean isWithdrawened(String userId, Long amount) {
		JSONObject file=fileParser();
		JSONObject account=(JSONObject)file.get(userId);
		if((Double)account.get("Amount")<=500) {
			return false;
		}else {
			account.put("Amount",(Long)account.get("Amount")-amount);
			fileWriter(file,path);
			return true;
		}
		
	}

	public JSONObject BalanceEnquiry(String userId) {	
		return (JSONObject) fileParser().get(userId);
	}
	
}
