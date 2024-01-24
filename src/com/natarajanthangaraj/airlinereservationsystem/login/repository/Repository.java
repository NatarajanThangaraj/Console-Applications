package com.natarajanthangaraj.airlinereservationsystem.login.repository;

public class Repository {
	private static Repository repo;
	private static JDBCConnection jdbcconnect;

	public Repository getInstance() {
		if (repo == null) {
			this.repo = new Repository();
			this.jdbcconnect = new JDBCConnection();
		}
		return repo;

	}

	// checks occurence in table
	boolean checkDetails(String name, String password, String tableName) {
		boolean flag = true;
		if (tableName.equalsIgnoreCase("user")) {
			flag = false;
		}
		return jdbcconnect.checkDetails(name, password, flag);
	}
	boolean newEntry(String name,String password,String tableName) {
		boolean flag=true;
		if(tableName.equalsIgnoreCase("user")) {
			flag=false;
		}
		return jdbcconnect.insertData(name, password, flag);
	}
}
