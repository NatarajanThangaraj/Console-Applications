package com.natarajanthangaraj.cricketscoreboard.login;

public class LoginViewModel {
    public LoginView loginView;
	public LoginViewModel(LoginView loginView) {
		this.loginView=loginView;
	}
	public boolean checkUser(String userName, String passWord) {
		return Repository.getInstance().checkUser(userName,passWord);
		
	}
	public boolean addUser(User user) {
		return Repository.getInstance().addUser(user);
		
	}

}
