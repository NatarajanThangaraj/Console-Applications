package com.natarajanthangaraj.airlinereservationsystem.application.dto;

public class SearchFlights {
	private String from;
	private String to;
	private String departDate;
	private int adult;
	private int adultCount;
	private int category;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the departDate
	 */
	public String getDepartDate() {
		return departDate;
	}

	/**
	 * @param departDate the departDate to set
	 */
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	/**
	 * @return the adult
	 */
	public int getAdult() {
		return adult;
	}

	/**
	 * @param adult the adult to set
	 */
	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
}
