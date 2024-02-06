package com.natarajanthangaraj.airlinereservationsystem.login.repository;

public final class Query {
  static  String insertTicket = "INSERT INTO ticket(flightNumber,passID)values(?,?)";
static 
 String insertQuery="INSERT INTO user(Name,password,isAdmin,gMailAddress,mobileNumber)values(?,?,?,?,?)";
 static String fetchQuery="SELECT * FROM user WHERE name=? AND password=? AND isAdmin=?";
 static String deleteQuery="DELETE FROM user WHERE name=? AND password=? AND isAdmin=?";
 static String addFlightQuery="INSERT INTO flight(flightNumber,fromAirportCode,toAirportCode,departTime,landingTime,economyPrice,businessPrice,economySeats,businessSeats)"
 		+ "values(?,?,?,?,?,?,?,?,?)";
 static String updateFlightSeats="UPDATE flight SET economySeats = economySeats - ? WHERE flightNumber = ?";
 static String getFlight="SELECT * FROM flight where fromAirportCode=? AND toAirportCode=? AND departTime=?";
static String insertPassenger="INSERT INTO passenger (firstName, lastName, dateOfBirth, gMail, mobileNumber, flightNumber) " +
        "VALUES (?,?,?,?,?,?)";
 static  String getTicket="SELECT * FROM ticket WHERE ticketNumber=?";
 static String getAirportCodeByName = "SELECT * FROM airport WHERE airportName = ?";
 static String getFlightByNumber="SELECT * FROM flight WHERE flightNumber=?";
 static String getPassengerByID="SELECT * FROM passenger WHERE passID=?";
 static String deleteTicket="DELETE FROM ticket WHERE ticketNumber=?";
}

