package com.natarajanthangaraj.foodordertracker.addorder;

import com.natarajanthangaraj.foodordertracker.dto.Order;
import com.natarajanthangaraj.foodordertracker.repository.Repository;

public class AddNewOrderModel {
	private AddNewOrderPresenter addneworderpresenter;

	public AddNewOrderModel(AddNewOrderPresenter addNewOrderPresenter2) {
		this.addneworderpresenter = addNewOrderPresenter2;
	}

	

	

	public boolean addOrderToRepository(Order order) {
		return Repository.getInstance().isAdded(order);
	}
}
