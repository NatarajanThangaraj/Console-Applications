package com.natarajanthangaraj.rolehierarchy.repository;

import java.io.FileWriter;
import java.sql.*;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.natarajanthangaraj.rolehierarchy.dto.Role;

public class Repository {
	//private final String path="C:\\Users\\ELCOT\\eclipse-workspace\\Console_Applications\\src\\com\\natarajanthangaraj\\rolehierarchy\\repository\\RoleData.json";
	//static TreeNode node;
	Connection con;
	private static Repository repo;

	private Repository() {
	}

	public static Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
		}
		return repo;
	}

	public void initRootRole(Role role) {
		String sql="insert into Role('Role_Name','Reporting_Name')"
	                 +"values("+role.getRootRole()+","+role.getReportingRole()+")";
	}
	public LinkedList<String> roleHierarchyList() {
		LinkedList<String> list = new LinkedList<>();
		return list;
	}
	void fileWriter(JSONObject jsonobject,String path) {
		try (FileWriter filewriter = new FileWriter(path)) {
			filewriter.write(jsonobject.toJSONString());
			
		}catch(Exception e) {
			
		}
	}
	JSONObject fileReader(String path) {
		JSONParser parser=new JSONParser();
		JSONObject fileDetails;
		try {
			fileDetails = (JSONObject) parser.parse(path);
			return fileDetails;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//temporery
		return null;
		
	}
	@SuppressWarnings("unchecked")
	JSONObject createInnerJsonObject() {
		JSONObject object=new JSONObject();
		JSONArray array=new JSONArray();
		object.put("Name ", null);
		object.put("Reporting_Roles", array);
		array.add("hello");
		return object;
	}
	
	
	

	
}
