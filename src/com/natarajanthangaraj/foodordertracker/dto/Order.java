package com.natarajanthangaraj.foodordertracker.dto;

public class Order {
	private String orderNumber;
	private int chickenBucket;
	private int burger;
	private int softDrinks;
	private int frenchFries;
	private int sandwiches;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getChickenBucket() {
		return chickenBucket;
	}

	public void setChickenBucket(int chickenBucket) {
		this.chickenBucket = chickenBucket;
	}

	public int getBurger() {
		return burger;
	}

	public void setBurger(int burger) {
		this.burger = burger;
	}

	public int getSoftDrinks() {
		return softDrinks;
	}

	public void setSoftDrinks(int softDrinks) {
		this.softDrinks = softDrinks;
	}

	public int getFrenchFries() {
		return frenchFries;
	}

	public void setFrenchFries(int frenchFries) {
		this.frenchFries = frenchFries;
	}

	public int getSandwiches() {
		return sandwiches;
	}

	public void setSandwiches(int sandwiches) {
		this.sandwiches = sandwiches;
	}
}
