package com.natarajanthangaraj.airlinereservationsystem.dto;

public class TicketDetails {
	                        //Flight Details
	private String from;
	private String to;
	private String departDate;
	private String departTime;
	private String passenger_Type;
	private int passenger_Count;
	private String category;

	                        //Passenger Details
	private String First_Name;
	private String Last_Name;
	private String Date_Of_Birth;
	private String Gmail;
	private String Mobile_Number;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	public String getPassenger_Type() {
		return passenger_Type;
	}
	public void setPassenger_Type(String string) {
		this.passenger_Type = string;
	}
	public int getPassenger_Count() {
		return passenger_Count;
	}
	public void setPassenger_Count(int passenger_Count) {
		this.passenger_Count = passenger_Count;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String class1) {
		category = class1;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}
	public void setDate_Of_Birth(String date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}
	public String getGmail() {
		return Gmail;
	}
	public void setGmail(String gmail) {
		Gmail = gmail;
	}
	public String getMobile_Number() {
		return Mobile_Number;
	}
	public void setMobile_Number(String mobile_Number) {
		Mobile_Number = mobile_Number;
	}
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	
	
}
