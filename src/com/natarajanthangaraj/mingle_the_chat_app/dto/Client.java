package com.natarajanthangaraj.mingle_the_chat_app.dto;

import java.util.Scanner;

public class Client {
 static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter your Name : ");
		String clientName=scan.nextLine();
		dout.writeUTF(clientName);
		dout.flush();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
