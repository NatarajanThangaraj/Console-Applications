package com.natarajanthangaraj.foodordertracker.addorder;

import java.util.Scanner;

import com.natarajanthangaraj.foodordertracker.dto.Order;

public class AddNewOrderView {
	Scanner scan = new Scanner(System.in);
	
	private AddNewOrderPresenter addneworderpresenter;

	public AddNewOrderView() {
		this.addneworderpresenter = new AddNewOrderPresenter(this);
	}

	public void getOrderDetails() {
		Order orderDetail = new Order();
		System.out.print("Enter the OrderNumber : ");
		orderDetail.setOrderNumber(scan.next());
		 addneworderpresenter.getOrder(orderDetail);
	}

	public void isSucceeded() {
		System.out.println("Order Added Successfully");
	}

	public void isFailed() {
		System.out.println("Invalid Order Number");
		
	}

}
