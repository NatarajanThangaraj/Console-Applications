package com.natarajanthangaraj.cricketscoreboard.database;

public class Queries {
  final String checkUser=" SELECT userID FROM Login WHERE userName=? && passWord=?";
  final String addUser=" INSERT INTO Login(userName,passWord,emailId,mobileNumber)values(?,?,?,?)";
}
