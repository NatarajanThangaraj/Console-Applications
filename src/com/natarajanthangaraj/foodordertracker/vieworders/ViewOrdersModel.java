package com.natarajanthangaraj.foodordertracker.vieworders;

import java.util.Queue;

import com.natarajanthangaraj.foodordertracker.Repository.Repository;
import com.natarajanthangaraj.foodordertracker.dto.Order;

public class ViewOrdersModel {
	private ViewOrdersPresenter vieworderspresenter;

	public ViewOrdersModel(ViewOrdersPresenter viewOrdersPresenter) {
		this.vieworderspresenter = viewOrdersPresenter;
		
	}
	public Queue<Order> getOrdersFromRepository() {
		//Repository.getInstance();
		return Repository.getStorage();
	}

}
