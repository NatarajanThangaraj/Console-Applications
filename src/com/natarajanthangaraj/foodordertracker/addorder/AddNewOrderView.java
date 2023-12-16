package com.natarajanthangaraj.foodordertracker.addorder;

import java.util.Scanner;

import com.natarajanthangaraj.foodordertracker.dto.Order;

public class AddNewOrderView {
	Scanner scan = new Scanner(System.in);
	//private  ordertaker=new OrderTaker();
	private AddNewOrderPresenter addneworderpresenter;

	public AddNewOrderView() {
		this.addneworderpresenter = new AddNewOrderPresenter(this);
	}

	public void getOrderDetails() {
		 addneworderpresenter.getOrder( new OrderTaker().takeOrder());
	}

	public void isSucceeded() {
		System.out.println("      ---------------------------------------------");
		System.out.println("      |        Last Order Added Successfully      |");
		System.out.println("      ---------------------------------------------");
	}

	public void isFailed() {
		System.out.println("Invalid Order Number");
		
	}

}
