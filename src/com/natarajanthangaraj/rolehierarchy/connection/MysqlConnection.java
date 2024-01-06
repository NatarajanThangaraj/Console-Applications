package com.natarajanthangaraj.rolehierarchy.connection;

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

	private Connection getConnection() throws SQLException {
		if (connect == null) {
			connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/RoleHierarchy", "root", "");
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

	public boolean deleteAndUpadateQuery(String role) {
		String reportingRole="";
		String deleteQuery="delete from role where roleName= '"+role+"'";
		String getReportingRoleQuery="select * from role where roleName='"+role+"'";
		String updateQuery="update role set reportingName='"+reportingRole+"' where reportingName='"+role+"'";
		try {
			ResultSet result=getStatement().executeQuery(getReportingRoleQuery);
			System.out.println(reportingRole);
			if(result.next()) {
				reportingRole=result.getString(3);
			}
			//executAddOrUpdateQuery(deleteQuery);
			
			executAddOrUpdateQuery(updateQuery);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		//System.out.println(reportingRole);
	}

}
