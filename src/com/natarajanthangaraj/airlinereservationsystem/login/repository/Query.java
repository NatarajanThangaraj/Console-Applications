package com.natarajanthangaraj.airlinereservationsystem.login.repository;

public class Query {
  static final String insertTicket = "INSERT INTO ticket(flightNumber,passID)values(?,?)";
static 
final String insertQuery="INSERT INTO user(Name,password,isAdmin,gMailAddress,mobileNumber)values(?,?,?,?,?)";
final static String fetchQuery="SELECT * FROM user WHERE name=? AND password=? AND isAdmin=?";
final static String deleteQuery="DELETE FROM user WHERE name=? AND password=? AND isAdmin=?";
final static String addFlightQuery="INSERT INTO flight(flightNumber,fromAirportCode,toAirportCode,departTime,landingTime,economyPrice,businessPrice,economySeats,businessSeats)"
 		+ "values(?,?,?,?,?,?,?,?,?)";
final static String updateFlightSeats="UPDATE flight SET economySeats = economySeats - ? WHERE flightNumber = ?";
final static String getFlight="SELECT * FROM flight where fromAirportCode=? AND toAirportCode=? AND departTime=?";final
static String insertPassenger="INSERT INTO passenger (firstName, lastName, dateOfBirth, gMail, mobileNumber, flightNumber) " +
        "VALUES (?,?,?,?,?,?)";
final static  String getTicket="SELECT * FROM ticket WHERE ticketNumber=?";
final static String getAirportCodeByName = "SELECT * FROM airport WHERE airportName = ?";
final static String getFlightByNumber="SELECT * FROM flight WHERE flightNumber=?";
final static String getPassengerByID="SELECT * FROM passenger WHERE passID=?";
}

