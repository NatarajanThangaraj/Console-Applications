package com.natarajanthangaraj.airlinereservationsystem.login.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.natarajanthangaraj.airlinereservationsystem.dto.Flight;
import com.natarajanthangaraj.airlinereservationsystem.dto.Passenger;
import com.natarajanthangaraj.airlinereservationsystem.dto.TicketDetails;
import com.natarajanthangaraj.airlinereservationsystem.dto.Trip;

public class JDBCConnection {
	private static JDBCConnection jdbcConnect; 
    private static Connection con;
	int affectedRows = 0;

	
	public static JDBCConnection getInstance() {
		if(jdbcConnect==null) {
			jdbcConnect=new JDBCConnection();
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation", "root", "Nattu@27");
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		return jdbcConnect;
	}

	boolean insertData(String name, String password, String gMailAddress, String mobileNumber, boolean flag) {
		try {
			PreparedStatement prepstmt = con.prepareStatement(Query.insertQuery);
			prepstmt.setString(1, name);
			prepstmt.setString(2, password);
			prepstmt.setBoolean(3, flag);
			prepstmt.setString(4, gMailAddress);
			prepstmt.setString(5, mobileNumber);
			affectedRows = prepstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (affectedRows > 0) {
			return true;
		}
		return false;
	}

	boolean checkDetails(String name, String password, boolean flag) {
		ResultSet result = null;
		try {
			PreparedStatement prepstmt = con.prepareStatement(Query.fetchQuery);
			prepstmt.setString(1, name);
			prepstmt.setString(2, password);
			prepstmt.setBoolean(3, flag);
			result = prepstmt.executeQuery();
			return result.next();
		} catch (SQLException e) {

			e.printStackTrace();
		}
//		} finally {
//			closeResultSet(result);
//			closeResources();
//		}
		return false;

	}

	public boolean deleteUser(String userName, String passWord, boolean flag) {
		try {
			PreparedStatement prepstmt = con.prepareStatement(Query.deleteQuery);
			prepstmt.setString(1, userName);
			prepstmt.setString(2, passWord);
			prepstmt.setBoolean(3, flag);
			affectedRows = prepstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (affectedRows > 0) {
			return true;
		}
		return false;
	}

	public boolean newFlightInstaller(String flightNumber, Flight newFlight) {
		try {
			PreparedStatement prepstmt = con.prepareStatement(Query.addFlightQuery);
			prepstmt.setString(1, flightNumber);
			prepstmt.setString(2, getAirportCodeByName(newFlight.getFrom()));
			prepstmt.setString(3, getAirportCodeByName(newFlight.getTo()));
			prepstmt.setTime(4, Time.valueOf(newFlight.getDepartTime()));
			prepstmt.setTime(5, Time.valueOf(newFlight.getLandingTime()));
			prepstmt.setDouble(6, newFlight.getEconomyPrice());
			prepstmt.setDouble(7, newFlight.getBusinessPrice());
			prepstmt.setInt(8, newFlight.getEconomySeats());
			prepstmt.setInt(9, newFlight.getBusinessSeats());
			affectedRows = prepstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (affectedRows > 0) {
			return true;
		}
		return false;
	}

	public List<Flight> userSearchedFilghts(Trip trip) {
		List<Flight> flights = new ArrayList<>();
		int seatCount = 0;
		try {
			PreparedStatement prepared = con.prepareStatement(Query.getFlight);
			prepared.setString(1, getAirportCodeByName(trip.getFrom()));
			prepared.setString(2, getAirportCodeByName(trip.getTo()));
			prepared.setTime(3, Time.valueOf(trip.getTime()));
			ResultSet resultSet = prepared.executeQuery();
			while (resultSet.next()) {
				seatCount = resultSet.getInt((trip.getCategory() + "Seats"));
				if (seatCount >= trip.getNumberOfPassenger()) {
					flights.add(flightMapper(resultSet, trip));
				} // any alternative way
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flights;
	}

	public String getAirportCodeByName(String airportName) {
		String airportCode = null;
		try {
			
			PreparedStatement innerPrepstmt = con.prepareStatement(Query.getAirportCodeByName);
			innerPrepstmt.setString(1, airportName);
			ResultSet resultSet = innerPrepstmt.executeQuery();

			if (resultSet.next()) {
				airportCode = resultSet.getString("airportCode");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airportCode;
	}

	public Flight flightMapper(ResultSet resultSet, Trip trip) {
		Flight flight = new Flight();
		try {
			flight.setFlightNumber(resultSet.getString("flightNumber"));
			flight.setFrom(resultSet.getString("fromAirportCode"));
			flight.setTo(resultSet.getString("toAirportCode"));
			flight.setDepartTime(resultSet.getTime("departTime").toLocalTime());
			flight.setLandingTime(resultSet.getTime("landingTime").toLocalTime());
			flight.setDepartDate(trip.getDate());
			flight.setEconomyPrice(resultSet.getDouble("economyPrice"));
			flight.setBusinessPrice(resultSet.getDouble("businessPrice"));
			flight.setBusinessSeats(resultSet.getInt("businessSeats"));
			flight.setEconomySeats(resultSet.getInt("economySeats"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flight;
	}

	public boolean seatsAllocation(String flightNumber, int seatsToSubtract) {

		try {
			PreparedStatement preparedStatement = con.prepareStatement(Query.updateFlightSeats);
			preparedStatement.setInt(1, seatsToSubtract);
			preparedStatement.setString(2, flightNumber);
			if( preparedStatement.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	 public List<Integer> generateTicket(String flightNumber, List<Passenger> pList) {
	        List<Integer> ticketNumbers = new ArrayList<>();
	        try {
	             PreparedStatement preparedStatement = con.prepareStatement(Query.insertPassenger, Statement.RETURN_GENERATED_KEYS); 
	            for (Passenger passenger : pList) {
	                preparedStatement.setString(1, passenger.getFirstName());
	                preparedStatement.setString(2, passenger.getLastName());
	                preparedStatement.setDate(3, Date.valueOf(passenger.getDateOfBirth()));
	                preparedStatement.setString(4, passenger.getgMailAddress());
	                preparedStatement.setString(5, passenger.getMobileNumber());
	                preparedStatement.setString(6, flightNumber);
	                preparedStatement.addBatch();
	               
	            }
	            preparedStatement.executeBatch();
	            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	                while (generatedKeys.next()) {
	                	ticketNumbers.add(insertTicket(flightNumber,generatedKeys.getInt(1)));
//	                    generatedPassIDs.add(generatedKeys.getInt(1));
	                }
	          
	        
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	System.out.println(" Mission failed");
	        }
	        
	        return ticketNumbers;
	 }
//	private void closeResultSet(ResultSet resultSet) {
//		try {
//			if (resultSet != null) {
//				resultSet.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void closeResources() {
//		try {
//			if (prepstmt != null) {
//				prepstmt.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	private int insertTicket(String flightNumber, int passID) {
		try {
			PreparedStatement stmt=con.prepareStatement(Query.insertTicket,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, flightNumber);
			stmt.setInt(2, passID);
			stmt.executeUpdate();
			ResultSet ticketNumber=stmt.getGeneratedKeys();
			while(ticketNumber.next()) {
				return ticketNumber.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public TicketDetails getTicket(int ticketNumber) {
		TicketDetails ticket=new TicketDetails();
		try {
			PreparedStatement prep=con.prepareStatement(Query.getTicket);
			prep.setInt(1, ticketNumber);
		    ResultSet resultSet=prep.executeQuery();
		    if (resultSet.next()) {
		    ticket.setFlight(getFlightByNumber(resultSet.getString("flightNumber")));
		    ticket.setPassenger(getPassengerByID(resultSet.getInt("passID")));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticket;
	}

	private Flight getFlightByNumber(String flightNumber) {
		Flight flight=new Flight();
		try {
			PreparedStatement stmt=con.prepareStatement(Query.getFlightByNumber);
			stmt.setString(1, flightNumber);
			ResultSet resultSet=stmt.executeQuery();
			 if (resultSet.next()) {
			flight.setFlightNumber(resultSet.getString("flightNumber"));
			flight.setFrom(resultSet.getString("fromAirportCode"));
			flight.setTo(resultSet.getString("toAirportCode"));
			flight.setDepartTime(resultSet.getTime("departTime").toLocalTime());
			flight.setLandingTime(resultSet.getTime("landingTime").toLocalTime());
			flight.setEconomyPrice(resultSet.getDouble("economyPrice"));
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return flight;
	}

	private Passenger getPassengerByID(int ID) {
		Passenger passenger=new Passenger();
		try {
			PreparedStatement stmt=con.prepareStatement(Query.getPassengerByID);
			stmt.setInt(1, ID);
			ResultSet resultSet=stmt.executeQuery();
			 if (resultSet.next()) {
			passenger.setFirstName(resultSet.getString("firstName"));
			passenger.setLastName(resultSet.getString("lastName"));
			passenger.setDateOfBirth(resultSet.getDate("dateOfBirth").toLocalDate());
			passenger.setgMailAddress(resultSet.getString("gMail"));
			passenger.setMobileNumber(resultSet.getString("mobileNumber"));
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return passenger;
	}

	public boolean cancelTicket(int ticketNumber) {
		try {
		PreparedStatement preparedStatement = con.prepareStatement(Query.deleteTicket);
			preparedStatement.setInt(1, ticketNumber);
			affectedRows=preparedStatement.executeUpdate();
			if(affectedRows>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
