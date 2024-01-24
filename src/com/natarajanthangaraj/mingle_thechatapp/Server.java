package com.natarajanthangaraj.mingle_thechatapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private ServerSocket serverSocket;
	private List<Display>clients;

	public Server() {
		try {
			this.serverSocket = new ServerSocket(8080);
			this.clients=new ArrayList<>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void runServer() {
		Socket socket = null;
		try {
			System.out.println("Server Begins....\nOpen to users");
			while (!serverSocket.isClosed()) {
				socket = serverSocket.accept();
				Display display=new Display(this,socket);
				clients.add(display);
				Thread thread = new Thread(display);
				thread.start();
			}
		} catch (Exception e) {
			endServer();
		}
	}

	private void endServer() {
		System.out.println(" server is closed  ");
		if (serverSocket != null)
			try {
				serverSocket.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		;
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.runServer();

	}

}
