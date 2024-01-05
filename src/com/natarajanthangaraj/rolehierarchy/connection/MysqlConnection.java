package com.natarajanthangaraj.rolehierarchy.connection;

import java.sql.*;

public class MysqlConnection {
	private static MysqlConnection dbConnect;
	private static Connection connect;

	private MysqlConnection() {

	}

	public static MysqlConnection getInstance() {
		if (dbConnect == null) {
			dbConnect = new MysqlConnection();
		}
		return dbConnect;
	}
	private Connection getConnection() throws SQLException {
		if(connect==null) {
		  connect=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/RoleHierarchy","root","");
		}
		return connect;
		
	}
	public boolean executAddOrUpdateQuary(String query)  {
		try {
		PreparedStatement preState=getConnection().prepareStatement(query);
		preState.executeUpdate();
		return true;
		}catch(Exception e) {
		return false;
		}
	
	}
	public int getMaxID(String query) {
		try {
		Statement stmt=getConnection().createStatement();
		ResultSet result=stmt.executeQuery(query);
			if(result.next())
			return result.getInt("roleID");
			else 
				return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
