package com.natarajanthangaraj.foodordertracker.Repository;

import com.natarajanthangaraj.foodordertracker.dto.Order;
import com.natarajanthangaraj.foodordertracker.tracker.Display;

import java.util.LinkedList;
import java.util.Queue;

public class Repository implements Runnable {
	Display display = new Display();
	Thread thread = new Thread(this);
	boolean flag=true;
	public static Repository repo;
	private static Queue<Order> storage = new LinkedList<>();

	private Repository() {
	};

	public static Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
		}
		return repo;
	}

	public boolean isAdded(Order order) {
		if (getStorage().contains(order)) {
			return false;
		} else {
			getStorage().add(order);
			if(!storage.isEmpty()&&flag) {
				flag=false;
				thread.start();
			}else if(storage.isEmpty()) {
				flag=true;
			}
			return true;
		}

	}

	public static Queue<Order> getStorage() {
		return storage;
	}

	public static void setStorage(Queue<Order> storage) {
		Repository.storage = storage;
	}

	@Override
	public void run() {
		while (!storage.isEmpty()) {
			Order nextOrder = storage.remove();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			display.receiveOrder(nextOrder);
		}
	}

}