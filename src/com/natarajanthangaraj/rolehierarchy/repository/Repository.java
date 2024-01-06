package com.natarajanthangaraj.rolehierarchy.repository;

import java.util.Map;

import com.natarajanthangaraj.rolehierarchy.connection.MysqlConnection;
import com.natarajanthangaraj.rolehierarchy.dto.Role;
import com.natarajanthangaraj.rolehierarchy.dto.User;

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
		query = "insert into Role(roleID,roleName,reportingName)" + "values (" + (getMaxID("Role") + 1) + ",'"
				+ role.getRole() + "','" + role.getReportingRole() + "')";
		return MysqlConnection.getInstance().executAddOrUpdateQuery(query);

	}
	public boolean insertUser(User user) {
		query = "insert into Employee(roleID,empName,empRole)" + "values (" + (getMaxID("Employee") + 1) + ",'"
				+ user.getUserName() + "','" + user.getUserRole() + "')";
		return MysqlConnection.getInstance().executAddOrUpdateQuery(query);
		
	}
	
	private int getMaxID(String tableName) {
		query = "select max(roleID) from "+tableName;
		return MysqlConnection.getInstance().getMaxID(query);

	}

	public Map<String, String> getRoleHierarchy() {
		query = "select * from role";
		return MysqlConnection.getInstance().getHierarchicalMap(query);
	}
	public Map<String, String> getUserHierarchy() {
		query = "select * from Employee";
		return MysqlConnection.getInstance().getHierarchicalMap(query);
	}

	public void deleteRole(String deletingRole) {
		String deleteQuery="delete from role where roleName= '"+deletingRole+"'";
		String getReportingRoleQuery="select * from role where roleName='"+deletingRole+"'";
		 MysqlConnection.getInstance().deleteAndUpadateQuery(deletingRole,deleteQuery,getReportingRoleQuery);
	}


	
}
