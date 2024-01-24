package com.natarajanthangaraj.airlinereservationsystem.login.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {
	JDBCConnection jdbc;
	Connection con;
	PreparedStatement prepstmt;
	String url = "jdbc:mysql://127.0.01:3306/AirlineReservation";
	String userName = "root";
	String password = "";

	JDBCConnection() {
		jdbc = new JDBCConnection();
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	boolean insertData(String name, String password, boolean flag) {
		int result = 0;
		try {
			prepstmt = con.prepareStatement(Query.insertQuery);
			prepstmt.setString(1, name);
			prepstmt.setString(2, password);
			prepstmt.setBoolean(3, flag);
			result = prepstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result > 0) {
			return true;
		}
		return false;
	}

	boolean checkDetails(String name, String password, boolean flag) {
		ResultSet result;
		try {
			prepstmt = con.prepareStatement(Query.fetchQuery);
			prepstmt.setString(1, name);
			prepstmt.setString(2, password);
			prepstmt.setBoolean(3, flag);
			result = prepstmt.executeQuery();
			if (result.next()) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}
}
