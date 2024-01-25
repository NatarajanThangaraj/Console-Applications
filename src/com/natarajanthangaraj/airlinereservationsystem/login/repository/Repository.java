package com.natarajanthangaraj.airlinereservationsystem.login.repository;

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
	public boolean checkDetails(String name, String password, String tableName) {
		boolean flag = true;
		if (tableName.equalsIgnoreCase("user")) {
			flag = false;
		}
		return jdbcconnect.checkDetails(name, password, flag);
	}
	public boolean newEntry(String name,String password,String tableName) {
		boolean flag=true;
		if(tableName.equalsIgnoreCase("user")) {
			flag=false;
		}
		return jdbcconnect.insertData(name, password, flag);
	}
}
