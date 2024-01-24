package com.natarajanthangaraj.airlinereservationsystem.login.repository;

public class Query {
 static  String insertQuery="INSERT INTO user(Name,password,isAdmin)values(?,?,?)";
 static String fetchQuery="SELECT * FROM user WHERE name=? AND password=? AND isAdmin=?";
}
