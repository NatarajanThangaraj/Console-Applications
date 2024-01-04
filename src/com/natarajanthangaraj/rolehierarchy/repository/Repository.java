package com.natarajanthangaraj.rolehierarchy.repository;

import com.natarajanthangaraj.rolehierarchy.connection.MysqlConnection;
import com.natarajanthangaraj.rolehierarchy.dto.Role;

public class Repository {
	//private final String path="C:\\Users\\ELCOT\\eclipse-workspace\\Console_Applications\\src\\com\\natarajanthangaraj\\rolehierarchy\\repository\\RoleData.json";
	String query;
	private static Repository repo;

	private Repository() {
	}

	public static Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
		}
		return repo;
	}

	
	public boolean insertRole(Role role) {
		query="insert into Role(roleID,roleName,reportingName)"+"values ("+(getMaxID())+",'"+role.getRole()+"','"+role.getReportingRole()+"')";
		return MysqlConnection.getInstance().executAddOrUpdateQuary(query);

	}
	private int getMaxID() {
		query="select max(roleID) from Role";
		return MysqlConnection.getInstance().getMaxID(query);
		
	}
//	public LinkedList<String> roleHierarchyList() {
//		LinkedList<String> list = new LinkedList<>();
//		return list;
//	}
//	void fileWriter(JSONObject jsonobject,String path) {
//		try (FileWriter filewriter = new FileWriter(path)) {
//			filewriter.write(jsonobject.toJSONString());
//			
//		}catch(Exception e) {
//			
//		}
//	}
//	JSONObject fileReader(String path) {
//		JSONParser parser=new JSONParser();
//		JSONObject fileDetails;
//		try {
//			fileDetails = (JSONObject) parser.parse(path);
//			return fileDetails;
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		//temporery
//		return null;
//		
//	}
//	@SuppressWarnings("unchecked")
//	JSONObject createInnerJsonObject() {
//		JSONObject object=new JSONObject();
//		JSONArray array=new JSONArray();
//		object.put("Name ", null);
//		object.put("Reporting_Roles", array);
//		array.add("hello");
//		return object;
//	}
	
	
	

	
}
