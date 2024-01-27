package com.natarajanthangaraj.airlinereservationsystem.repository.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
	private static MySQLConnection mysqlconnect;
	private static Connection con;
	private static Statement statement;
	private final static String url="jdbc:mysql://localhost:3306/airlinereservation";
	private final static String userName="root";
	private final static String password="Nattu@27";

	public static MySQLConnection getInstance() {
		if (mysqlconnect == null) {
			mysqlconnect = new MySQLConnection();
			try {
				con= DriverManager.getConnection(url, userName, password);
				statement=con.createStatement();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return mysqlconnect;
	}
	
	
}