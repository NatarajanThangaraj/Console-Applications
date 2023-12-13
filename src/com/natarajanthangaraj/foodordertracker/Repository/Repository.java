package com.natarajanthangaraj.foodordertracker.Repository;

import com.natarajanthangaraj.foodordertracker.dto.Order;
import java.util.LinkedList;
import java.util.Queue;

public class Repository {
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
			return true;
		}

	}

	public static Queue<Order> getStorage() {
		return storage;
	}

	public static void setStorage(Queue<Order> storage) {
		Repository.storage = storage;
	}
}
