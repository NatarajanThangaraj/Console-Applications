package com.natarajanthangaraj.mingle_thechatapp.user;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
	String userName;
	Socket socket;
	BufferedWriter writer;
	OutputStreamWriter streamWriter;
	Scanner scan = new Scanner(System.in);

	void getConnection() {
		int amountOfTry = 0;
		while (amountOfTry < 3 && socket == null) {
			try {
				amountOfTry++;
				socket = new Socket("localhost", 8080);
				//socket.isConnected();
			} catch (Exception e) {
				System.out.println("Trying again in few seconds");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ne) {
					ne.printStackTrace();
				}
				if (amountOfTry == 3)
					System.err.println("Unable to create connection with server");
			}
		}
		try {
			streamWriter = new OutputStreamWriter(socket.getOutputStream());
			writer = new BufferedWriter(streamWriter);
			System.out.println(" connected successfully  ");
			userName=getName();
		} catch (Exception e) {
		}
	}

	void startChat() {
		String message;
		try {
			while (!socket.isClosed()) {
				message = scan.nextLine();
				if (message.equalsIgnoreCase("exit")) {
					closeReaderAndWrite(socket, writer, streamWriter);
					break;
				} else {
					writer.write(userName + " : " + message);
					writer.flush();
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private void closeReaderAndWrite(Socket socket2, BufferedWriter writer2, OutputStreamWriter streamWriter2) {
		try {
			if (streamWriter2 != null)
				streamWriter2.close();
			if (writer2 != null)
				writer2.close();
			if (socket2 != null)
				socket2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	String getName() {
		System.out.print(" Enter your Name : ");
		return  scan.next();
	}
	public static void main(String[] args) {
		Client1 client =new Client1();
		client.getConnection();
		Thread chatThread = new Thread(client::startChat);
        chatThread.start();
	}

}
