package com.natarajanthangaraj.airlinereservationsystem.login.repository;

import com.natarajanthangaraj.airlinereservationsystem.dto.Flight;
import com.natarajanthangaraj.airlinereservationsystem.dto.User;

public class Repository {
	private static Repository repo;
	private static JDBCConnection jdbcconnect;

	public static  Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
			jdbcconnect = new JDBCConnection();
		}
		return repo;

	}

	// checks occurence in table
	public boolean checkDetails(String name, String password, String person) {
		boolean flag = true;
		if (person.equalsIgnoreCase("user")) {
			flag = false;
		}
		return jdbcconnect.checkDetails(name, password, flag);
	}
	public boolean newUser(User user,String person) {
		boolean flag=true;
		if(person.equalsIgnoreCase("user")) {
			flag=false;
		}
		return jdbcconnect.insertData(user.getUserName(),
				                      user.getPassWord(),
				                      user.getgMail(),
				                      user.getMobileNumber(),
				                      flag);
	}

	public boolean deleteEntry(String userName, String passWord, String person) {
		boolean flag=true;
		if(person.equalsIgnoreCase("user")) {
			flag=false;
		}
		return jdbcconnect.deleteUser(userName, passWord, flag);
	}

	public boolean flightInstaller(String flightNumber, Flight newFlightDetails) {
		return jdbcconnect.newFlightInstaller(flightNumber,newFlightDetails);
		
	}
}
