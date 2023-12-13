package com.natarajanthangaraj.foodordertracker.tracker;

import java.util.Scanner;

import com.natarajanthangaraj.foodordertracker.addorder.AddNewOrderView;
import com.natarajanthangaraj.foodordertracker.vieworders.ViewOrdersView;

public class TrackView {
	Scanner scan = new Scanner(System.in);
	private TrackPresenter trackpresenter;
	private AddNewOrderView addorder=new AddNewOrderView();
	private ViewOrdersView vieworder=new ViewOrdersView();
	public TrackView() {
		this.trackpresenter=new TrackPresenter(this);
		
	}

	public void start() {
		byte selection;
		do {
			System.out.println("1.Add new order");
			System.out.println("2.View all orders");
			System.out.println("0.Exit");
			selection = scan.nextByte();
			switch(selection) {
			case 1->{
				addorder.getOrderDetails();
				
			}
			case 2->{
				vieworder.showAllOrders();
			}
			}
		} while (selection != 0);

	}
}
