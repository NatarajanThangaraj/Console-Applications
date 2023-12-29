package com.natarajanthangaraj.airlinereservationsystem.Repository;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.natarajanthangaraj.airlinereservationsystem.dto.Ticket;
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;
import com.natarajanthangaraj.airlinereservationsystem.flight.Flight;

public class Repository {
	private final String fileFlight = "C:\\Users\\ELCOT\\eclipse-workspace\\Console_Applications\\src\\com\\natarajanthangaraj\\airlinereservationsystem\\Repository\\Flights.json";
	private final String fileTicket = "C:\\Users\\ELCOT\\eclipse-workspace\\Console_Applications\\src\\com\\natarajanthangaraj\\airlinereservationsystem\\Repository\\Reservation.json";
	static List<Flight> allFlights = new ArrayList<>();
	private static Repository repo;

	private Repository() {
	};

	public static Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
		}
		return repo;
	}

	public void getFlightDetails() {
		JSONObject jsonobject = fileParser();
		JSONArray arrayOfFlights = (JSONArray) jsonobject.get("AllFlights");
		for (Object flight : arrayOfFlights) {
			JSONObject flightObject = (JSONObject) jsonobject.get(flight);
			Flight f = new Flight();
			f.setFlightNumber((String) flight);
			f.setFrom((String) flightObject.get("From"));
			f.setTo((String) flightObject.get("To"));
			f.setEconomyPrice((String) flightObject.get("EconomyPrice"));
			f.setEconomySeats((Long) flightObject.get("EconomySeats"));
			allFlights.add(f);
		}
	}

	public List<Flight> availableFlights(TicketDetails userSearch) {
		getFlightDetails();
		List<Flight> availableFlights = new ArrayList<>();
		for (Flight flight : allFlights) {
			if (userSearch.getFrom().equalsIgnoreCase(flight.getFrom())
					&& userSearch.getTo().equalsIgnoreCase(flight.getTo())) {
				availableFlights.add(flight);
			}
		}
		// System.out.println(availableFlights);
		return availableFlights;
	}

	public JSONObject getSpecifiedFlight(String flightNumber) {
		JSONObject flight = fileParser();
		JSONObject selectedFlight = (JSONObject) flight.get(flightNumber);
		return selectedFlight;
	}

	@SuppressWarnings("unchecked")
	public void allotSeat(String userSelectedFlight) {
		JSONObject flight = fileParser();
		JSONObject selectedFlight = getSpecifiedFlight(userSelectedFlight);
		Long seats = (Long) selectedFlight.get("EconomySeats");
		selectedFlight.put("EconomySeats", seats - 1);
		fileWriter(flight, fileFlight);
	}

	void fileWriter(JSONObject jsonobject, String path) {
		try (FileWriter fileWriter = new FileWriter(path)) {
			fileWriter.write(jsonobject.toJSONString());
		} catch (Exception e) {
		}
	}

	public Ticket createTicket(String userSelectedFlight, TicketDetails passengerDetails) {
		Ticket ticket = new Ticket();
		JSONObject flightDetails = getSpecifiedFlight(userSelectedFlight);
		ticket.setFrom((String) flightDetails.get("From"));
		ticket.setTo((String) flightDetails.get("To"));
		ticket.setDepartTime((String) flightDetails.get("DepartTime"));
		ticket.setLandingTime((String) flightDetails.get("LandingTime"));
		ticket.setFirstName(passengerDetails.getFirst_Name());
		ticket.setLastName(passengerDetails.getLast_Name());
		ticket.setPassenger_Type(passengerDetails.getPassenger_Type());
		ticket.setPassenger_Count(passengerDetails.getPassenger_Count());
		ticket.setMobileNumber(passengerDetails.getMobile_Number());
		ticket.setTicketNumber(getTicketNumber(userSelectedFlight));
		//fileWriter(ticket,fileTicket);
		return ticket;
	}

	private String getTicketNumber(String flightNum) {
		Random random = new Random();
		char l1 = (char) random.nextInt(26);
		int l2 = random.nextInt(10);
		return l1 + "" + l2 + flightNum.substring(flightNum.length() - 3);
	}

	JSONObject fileParser() {
		JSONParser parser = new JSONParser();
		JSONObject object = null;
		try {
			object = (JSONObject) parser.parse(new FileReader(
					"C:\\Users\\ELCOT\\eclipse-workspace\\Console_Applications\\src\\com\\natarajanthangaraj\\airlinereservationsystem\\Repository\\Flights.json"));
		} catch (Exception e) {
			System.out.println("Problem on DataBase");
		}
		return object;
	}

	 

}
