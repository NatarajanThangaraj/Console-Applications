package com.natarajanthangaraj.foodordertracker.addorder;

import java.util.Random;
import java.util.Scanner;

import com.natarajanthangaraj.foodordertracker.dto.Order;

public class OrderTaker {
	Scanner scan = new Scanner(System.in);

	public Order takeOrder() {
		Order order = new Order();
		int select = 0;
		outer: do {
			items();
			select = scan.nextInt();
			switch (select) {
			case 1 -> {
				System.out.print("Enter Bucket count :");
				order.setChickenBucket(scan.nextInt());
			}
			case 2 -> {
				System.out.print("Enter Burger count :");
				order.setBurger(scan.nextInt());
			}
			case 3 -> {
				System.out.print("Enter Sandwich count :");
				order.setSandwiches(scan.nextInt());
			}
			case 4 -> {
				System.out.print("Enter FrenchFries Packet :");
				order.setFrenchFries(scan.nextInt());
			}
			case 5 -> {
				System.out.print("Enter SoftDrink  tin count :");
				order.setSoftDrinks(scan.nextInt());
			}
			default -> {
				break outer;
			}
			}
		} while (select != 0);
		order.setOrderNumber(generateOrderNumber());
		return order;
	}

	private String generateOrderNumber() {
		Random random = new Random();
		char l1 = (char) ('A' + random.nextInt(26));
		char l2 = (char) ('A' + random.nextInt(26));
		int num = random.nextInt(900) + 100;
		return (l1 + "" + l2 + "" + num);
	}

	public void items() {
		System.out.println("+--------------------------------------------+");
		System.out.println("|        1. Chicken Bucket                   |");
		System.out.println("|        2. Chicken Burger                   |");
		System.out.println("|        3. SandWiches                       |");
		System.out.println("|        4. French Fries                     |");
		System.out.println("|        5. Soft Drinks                      |");
		System.out.println("|        0.Close Order                       |");
		System.out.println("+--------------------------------------------+");
		System.out.println();
		System.out.print("Enter selction : ");
	}
}
