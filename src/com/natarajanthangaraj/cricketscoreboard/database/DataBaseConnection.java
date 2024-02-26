package com.natarajanthangaraj.cricketscoreboard.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.natarajanthangaraj.cricketscoreboard.login.User;

public class DataBaseConnection extends Queries{
private Connection con;	
int affectedRows;
public DataBaseConnection() {
	try {
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricketScoreBoard", "root", "Nattu@27");
	}catch(SQLException e) {
		//remove
		System.out.println(e);
	}
}
	public boolean checkUser(String userName, String passWord) {
		ResultSet result=null;
		try {
		PreparedStatement stmt=con.prepareStatement(checkUser);
		stmt.setString(1, userName);
		stmt.setString(2, passWord);
		result=stmt.executeQuery();
		return result.next();
		}catch(SQLException e) {
			//remove
			System.out.println(e);
		}
		return false;
	}
	public boolean addUser(User user) {
		try {
		PreparedStatement stmt=con.prepareStatement(addUser);
		stmt.setString(1, user.getUserName());
		stmt.setString(2, user.getPassWord());
		stmt.setString(3, user.geteMail());
		stmt.setString(4, user.getMobileNumber());
		affectedRows=stmt.executeUpdate();
		}catch(SQLException e) {
			//remove
			System.out.println(e);
		}
		if(affectedRows>0) {
			return true;
		}
		return false;
	}

}
