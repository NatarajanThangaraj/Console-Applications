package com.natarajanthangaraj.mingle_thechatapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	
	public Server() {
		try {
			this.serverSocket=new ServerSocket(8080);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	private void runServer() {
		Socket socket = null;
		try {
			System.out.println("Server Begins....\nOpen to users");
			while(!serverSocket.isClosed()) {
			 socket=serverSocket.accept();
			Thread thread=new Thread(new Display(socket));
			thread.start();
			}
		} catch (IOException e) {
			endServer();
		}
	}
	private void endServer() {
		System.out.println(" server is closed  ");
			if(serverSocket!=null) this.serverSocket.isClosed();
	}
	public static void main(String[] args) {
		

	}

}
