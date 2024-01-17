package com.natarajanthangaraj.mingle_thechatapp.ui;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Display  implements Runnable {
		Socket socket;
		ServerSocket server;
		DataInputStream scanner;
		Thread message;
		String userName;

		public Display() {
			try {
				server = new ServerSocket(80);
				socket = server.accept();
				scanner = new DataInputStream(socket.getInputStream());
				message = new Thread(this);
				message.start();
			} catch (Exception e) {
				System.out.println(" Exception occuered");
			}
		}
		public void run() {
			while (true) {
				try {
					String str = scanner.readUTF();
					if(str.equalsIgnoreCase("bye")) {
						scanner.close();
						socket.close();
						server.close();
						break;
					}
					System.out.println(userName + " : " + str + "\n");
					
				} catch (Exception e) {

				}
			}
			

		}
		public static void main(String[]args) {
			Display dis=new Display();
		}

	}


