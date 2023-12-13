package com.natarajanthangaraj.foodordertracker.vieworders;

import com.natarajanthangaraj.foodordertracker.dto.Order;

public class ViewOrdersView {
	private ViewOrdersPresenter vieworderspresent;

	public ViewOrdersView() {
		this.vieworderspresent = new ViewOrdersPresenter(this);
	}
	public void showAllOrders() {
		for(Order order:vieworderspresent.getOrderlist()) {
			System.out.println(order.getOrderNumber());
		}
		
	}
}
