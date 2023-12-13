package com.natarajanthangaraj.foodordertracker.addorder;
import com.natarajanthangaraj.foodordertracker.dto.Order;

public class AddNewOrderPresenter {
	private AddNewOrderView addneworderview;
	private AddNewOrderModel addnewordermodel;

	public AddNewOrderPresenter(AddNewOrderView addNewOrderView2) {
		addneworderview = addNewOrderView2;
		addnewordermodel = new  AddNewOrderModel(this);
		
	}
	public void getOrder(Order order) {
		if (addnewordermodel.addOrderToRepository(order)) {
			addneworderview.isSucceeded();
		} else {
			addneworderview.isFailed();
		}
	}


}
