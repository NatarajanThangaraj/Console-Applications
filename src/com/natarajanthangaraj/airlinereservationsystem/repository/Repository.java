package com.natarajanthangaraj.airlinereservationsystem.repository;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.natarajanthangaraj.airlinereservationsystem.Utility;
import com.natarajanthangaraj.airlinereservationsystem.dto.Flight;
import com.natarajanthangaraj.airlinereservationsystem.dto.Passenger;
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;
import com.natarajanthangaraj.airlinereservationsystem.dto.Trip;
import com.natarajanthangaraj.airlinereservationsystem.login.repository.JDBCConnection;

public class Repository {
//	private final String fileFlight = "C:\\Users\\zoho\\eclipse-workspace\\Console-Applications\\src\\com\\natarajanthangaraj\\airlinereservationsystem\\repository\\Flights.json";
//	private final String fileTicket = "C:\\Users\\zoho\\eclipse-workspace\\Console-Applications\\src\\com\\natarajanthangaraj\\airlinereservationsystem\\repository\\Reservation.json";
	List<Flight> allFlights = new ArrayList<>();
	private static Repository repo;
	private static JDBCConnection jdbcConnect;

	private Repository() {
	};

	public static Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
			jdbcConnect=new JDBCConnection();
		}
		return repo;
	}


	// check each flight's criteria matching to user search
	public List<Flight> availableFlights(Trip trip) {
		return jdbcConnect.userSearchedFilghts(trip);
	}

	// get user selected flight object
	

	

//	@SuppressWarnings("unchecked")
//	public boolean createTicket(String userSelectedFlight, TicketDetails passengerDetails) {
//
//		JSONObject ticketDetails = new JSONObject();
//		JSONObject flightDetails = getSpecifiedFlight(userSelectedFlight);
//		ticketDetails.put("TicketNumber", getTicketNumber(userSelectedFlight));
//		ticketDetails.put("From", flightDetails.get("From"));
//
//		ticketDetails.put("To", flightDetails.get("To"));
//
//		ticketDetails.put("Booking Date", Utility.currentDate() + " " + Utility.currentTime());
//
//		ticketDetails.put("Depart Time", flightDetails.get("DepartTime"));
//
//		ticketDetails.put("Landing Time", flightDetails.get("LandingTime"));
//		ticketDetails.put("Total Amount",
//				(passengerDetails.getPassengerCount() * Integer.parseInt((String) flightDetails.get("EconomyPrice"))));
//		ticketDetails.put("First Name", passengerDetails.getFirst_Name());
//
//		ticketDetails.put("Last Name", passengerDetails.getLast_Name());
//
//		ticketDetails.put("Type", passengerDetails.getPassengerType());
//
//		ticketDetails.put("Count", passengerDetails.getPassenger_Count());
//		ticketDetails.put("class", passengerDetails.getCategory());
//
//		ticketDetails.put("Mobile Number", passengerDetails.getMobile_Number());
//		ticketDetails.put("Gmail Address", passengerDetails.getGmail());
//
//		JSONObject newticket = fileParser(fileTicket);
//		JSONArray Tickets = (JSONArray) newticket.get("Tickets");
//		Tickets.add(ticketDetails);
//		fileWriter(newticket, fileTicket);
//		return true;
//	}
//
	

	


	

	public List<Integer> createTicket(String flightNumber, List<Passenger> pList) {
		List<Integer>ticketList=new ArrayList<>();

		if(jdbcConnect.seatsAllocation(flightNumber,pList.size())) {
			ticketList=jdbcConnect.generateTicket(flightNumber,pList);			
		}
		
		
		return ticketList;
		
	}

}
