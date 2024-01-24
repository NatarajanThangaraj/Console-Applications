package com.natarajanthangaraj.mingle_thechatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Display implements Runnable {
	Socket socket;
	Server serverSocket;
	BufferedReader reader;
	InputStreamReader streamReader;

	public Display(Socket socket) {
		
	}

	public Display(Server server, Socket socket2) {
		this.socket = socket2;
		this.serverSocket=server;
		try {
			streamReader = new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(streamReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String inbox;
		while (socket.isConnected()) {
			//System.out.println(" Hi Bro");
			try {
				inbox = reader.readLine();
				if (inbox.equalsIgnoreCase("exit")) {
					break;
				} else {
					System.out.println(inbox);
				}
			} catch (IOException e) {
				e.printStackTrace();
				closeReader(socket, streamReader, reader);
				break;
			}
		}

	}

	private void closeReader(Socket socket2, InputStreamReader streamReader2, BufferedReader reader2) {

		try {
			if (socket2 != null)
				socket2.close();
			if (streamReader2 != null)
				streamReader2.close();
			if (reader2 != null) {
				reader2.close();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
