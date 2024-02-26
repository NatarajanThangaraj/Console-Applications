package com.natarajanthangaraj.cricketscoreboard.login;
import com.natarajanthangaraj.cricketscoreboard.database.DataBaseConnection;

public class Repository {
	public static Repository repo;
	private final DataBaseConnection connect=new DataBaseConnection();
	private Repository() {
	};

	public static Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
		}
		return repo;
	}

	public boolean checkUser(String userName, String passWord) {
		return  connect.checkUser(userName,passWord);
		
	}
	public boolean addUser(User user) {
		return  connect.addUser(user);
		
	}

}
