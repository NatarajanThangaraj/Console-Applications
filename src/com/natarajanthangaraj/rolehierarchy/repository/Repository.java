package com.natarajanthangaraj.rolehierarchy.repository;

import java.util.Map;

import com.natarajanthangaraj.rolehierarchy.connection.MysqlConnection;
import com.natarajanthangaraj.rolehierarchy.dto.Role;

public class Repository {
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
		query = "insert into Role(roleID,roleName,reportingName)" + "values (" + (getMaxID() + 1) + ",'"
				+ role.getRole() + "','" + role.getReportingRole() + "')";
		return MysqlConnection.getInstance().executAddOrUpdateQuery(query);

	}

	private int getMaxID() {
		query = "select max(roleID) from Role";
		return MysqlConnection.getInstance().getMaxID(query);

	}

	public Map<String, String> getRoleHierarchy() {
		query = "select * from role";
		return MysqlConnection.getInstance().getHierarchicalMap(query);
	}

	public boolean deleteRole(String deletingRole) {
		return MysqlConnection.getInstance().deleteAndUpadateQuery(deletingRole);
	}
}
