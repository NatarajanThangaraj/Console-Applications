package com.natarajanthangaraj.foodordertracker.vieworders;

import java.util.Queue;

import com.natarajanthangaraj.foodordertracker.dto.Order;

public class ViewOrdersPresenter {
	private ViewOrdersView viewordersview;
	private ViewOrdersModel viewordersmodel;

	public ViewOrdersPresenter(ViewOrdersView viewOrdersView) {
		this.viewordersview = viewOrdersView;
		this.viewordersmodel = new ViewOrdersModel(this);
	}
	public Queue<Order> getOrderlist() {
		return  viewordersmodel.getOrdersFromRepository();
		
	}

}
