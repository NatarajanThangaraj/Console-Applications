package com.natarajanthangaraj.rolehierarchy.repository.connection;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class MysqlConnection {
	private static MysqlConnection dbConnect;
	private static Connection connect;
	private static Statement stmt;

	private MysqlConnection() {

	}

	public static MysqlConnection getInstance() {
		if (dbConnect == null) {
			dbConnect = new MysqlConnection();
		}
		return dbConnect;
	}

	private Connection getConnection() {
		if (connect == null) {
			try {
				connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/RoleHierarchy", "root", "");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connect;

	}

	private Statement getStatement() {
		if (stmt == null) {
			try {
				stmt = getConnection().createStatement();
				return stmt;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stmt;
	}

	public boolean executAddOrUpdateQuery(String query) {
		try {
			PreparedStatement preState = getConnection().prepareStatement(query);
			preState.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public int getMaxID(String query) {
		try {
			ResultSet result = getStatement().executeQuery(query);
			if (result.next())
				return result.getInt(1);
			else
				return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Map<String, String> getHierarchicalMap(String query) {
		Map<String, String> map = new LinkedHashMap<>();
		try {
			ResultSet result = getStatement().executeQuery(query);
			while (result.next()) {
				map.put(result.getString(2), result.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public void deleteAndUpadateQuery(String role,String deleteQuery,String getReportingRoleQuery) {
		String reportingRole="";
		String updateQuery;
		try {
			ResultSet result=getStatement().executeQuery(getReportingRoleQuery);
			if(result.next()) {
				reportingRole=result.getString(3);
			}
			updateQuery="update role set reportingName='"+reportingRole+"' where reportingName='"+role+"'";
			executAddOrUpdateQuery(deleteQuery);
			executAddOrUpdateQuery(updateQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

}
