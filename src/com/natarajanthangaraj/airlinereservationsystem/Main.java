package com.natarajanthangaraj.airlinereservationsystem;

import com.natarajanthangaraj.airlinereservationsystem.login.LoginView;
import com.natarajanthangaraj.airlinereservationsystem.reservation.ReservationView;

public class Main {

	public static void main(String[] args) {
//		ApplicationView appview =new ApplicationView();
//		LoginView loginView=new LoginView();
//		loginView.start();
		ReservationView obj=new ReservationView();
		obj.userSearch();
//		int remainder, count = 0;
//		int num = 100
//				;
//		for (int i = 1; i <= num; i++) {
//			int temp = i;
//			while (temp > 0) {
//				remainder = temp % 10;
//				if (remainder == 1) {
//					count++;
//				}
//				temp = temp / 10;
//			}
//		}
//		System.out.println(count);
	}

}
