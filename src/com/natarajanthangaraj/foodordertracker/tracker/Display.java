package com.natarajanthangaraj.foodordertracker.tracker;

import com.natarajanthangaraj.foodordertracker.dto.Order;

public class Display {
	public void receiveOrder(Order order) {
		System.out.println("         *********************************           ");
		System.out.println("         |  "+order.getOrderNumber()+"   this order is Ready!!!|");
		System.out.println("         *********************************           ");
	}
}
