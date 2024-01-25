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
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;

public class Repository {
	private final String fileFlight = "C:\\Users\\zoho\\eclipse-workspace\\Console-Applications\\src\\com\\natarajanthangaraj\\airlinereservationsystem\\repository\\Flights.json";
	private final String fileTicket = "C:\\Users\\zoho\\eclipse-workspace\\Console-Applications\\src\\com\\natarajanthangaraj\\airlinereservationsystem\\repository\\Reservation.json";
	List<Flight> allFlights = new ArrayList<>();
	private static Repository repo;

	private Repository() {
	};

	public static Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
		}
		return repo;
	}

	// gather all flights with its details from json file
	public void getFlightDetails() {
		JSONObject jsonobject = fileParser(fileFlight);
		JSONArray arrayOfFlights = (JSONArray) jsonobject.get("AllFlights");
		for (Object flight : arrayOfFlights) {
			JSONObject flightObject = (JSONObject) jsonobject.get(flight);
			Flight f = new Flight();
			f.setFlightNumber((String) flight);
			f.setFrom((String) flightObject.get("From"));
			f.setTo((String) flightObject.get("To"));
			f.setDepartTime((String) flightObject.get("DepartTime"));
			f.setLandingTime((String) flightObject.get("LandingTime"));
			f.setEconomyPrice((String) flightObject.get("EconomyPrice"));
			f.setEconomySeats((Long) flightObject.get("EconomySeats"));
			allFlights.add(f);
		}
	}

	// check each flight's criteria matching to user search
	public List<Flight> availableFlights(Flight userSearch) {
		getFlightDetails();
		List<Flight> availableFlights = new ArrayList<>();
		for (Flight flight : allFlights) {
			if (userSearch.getFrom().equalsIgnoreCase(flight.getFrom())
					&& userSearch.getTo().equalsIgnoreCase(flight.getTo())) {
				availableFlights.add(flight);
			}
		}
		return availableFlights;
	}

	// get user selected flight object
	public JSONObject getSpecifiedFlight(String flightNumber) {
		JSONObject flight = fileParser(fileFlight);
		JSONObject selectedFlight = (JSONObject) flight.get(flightNumber);
		return selectedFlight;
	}

	@SuppressWarnings("unchecked")
	// decrese the seat count from user selected flight
	public void allotSeat(String userSelectedFlight, TicketDetails passengerDetails) {
		JSONObject flight = fileParser(fileFlight);
		JSONObject selectedFlight = getSpecifiedFlight(userSelectedFlight);
		Long seats = (Long) selectedFlight.get("EconomySeats");
		selectedFlight.put("EconomySeats", seats - passengerDetails.getPassenger_Count());
		fileWriter(flight, fileFlight);
	}

	@SuppressWarnings("unchecked")
	public boolean createTicket(String userSelectedFlight, TicketDetails passengerDetails) {

		JSONObject ticketDetails = new JSONObject();
		JSONObject flightDetails = getSpecifiedFlight(userSelectedFlight);
		ticketDetails.put("TicketNumber", getTicketNumber(userSelectedFlight));
		ticketDetails.put("From", flightDetails.get("From"));

		ticketDetails.put("To", flightDetails.get("To"));

		ticketDetails.put("Booking Date", Utility.currentDate() + " " + Utility.currentTime());

		ticketDetails.put("Depart Time", flightDetails.get("DepartTime"));

		ticketDetails.put("Landing Time", flightDetails.get("LandingTime"));
		ticketDetails.put("Total Amount",
				(passengerDetails.getPassengerCount() * Integer.parseInt((String) flightDetails.get("EconomyPrice"))));
		ticketDetails.put("First Name", passengerDetails.getFirst_Name());

		ticketDetails.put("Last Name", passengerDetails.getLast_Name());

		ticketDetails.put("Type", passengerDetails.getPassengerType());

		ticketDetails.put("Count", passengerDetails.getPassenger_Count());
		ticketDetails.put("class", passengerDetails.getCategory());

		ticketDetails.put("Mobile Number", passengerDetails.getMobile_Number());
		ticketDetails.put("Gmail Address", passengerDetails.getGmail());

		JSONObject newticket = fileParser(fileTicket);
		JSONArray Tickets = (JSONArray) newticket.get("Tickets");
		Tickets.add(ticketDetails);
		fileWriter(newticket, fileTicket);
		return true;
	}

	private String getTicketNumber(String flightNum) {
		Random random = new Random();
		char l1 = (char) ('a' + random.nextInt(25));
		int l2 = random.nextInt(10);
		return l1 + "" + l2 + flightNum.substring(flightNum.length() - 3);
	}

	JSONObject fileParser(String path) {
		JSONParser parser = new JSONParser();
		JSONObject object = null;
		try {
			object = (JSONObject) parser.parse(new FileReader(path));
		} catch (Exception e) {

		}
		return object;
	}

	void fileWriter(JSONObject jsonobject, String path) {
		try (FileWriter fileWriter = new FileWriter(path)) {
			fileWriter.write(jsonobject.toJSONString());
		} catch (Exception e) {
		}
	}

	public boolean cancelTicket(String ticketNumber) {
		try {
			JSONObject ticketFile = fileParser(fileTicket);
			JSONArray tickets = (JSONArray) ticketFile.get("Tickets");
			for (int i = 0; i < tickets.size(); i++) {
				if (((JSONObject) tickets.get(i)).get("TicketNumber").equals(ticketNumber)) {
					tickets.remove(i);
					fileWriter(ticketFile, fileTicket);
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public JSONObject getTicket(String ticketNumber) {
		JSONObject ticketFile = fileParser(fileTicket);
		JSONArray tickets = (JSONArray) ticketFile.get("Tickets");
		for (int i = 0; i < tickets.size(); i++) {
			if (((JSONObject) tickets.get(i)).get("TicketNumber").equals(ticketNumber)) {
				return (JSONObject) tickets.get(i);

			}
		}
		return null;
	}
}
