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
}
