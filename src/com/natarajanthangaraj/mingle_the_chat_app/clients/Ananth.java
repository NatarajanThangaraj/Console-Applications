package com.natarajanthangaraj.mingle_the_chat_app.clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ananth {
public static void main(String[] args) {
		
		// client socket
		Socket s;
		 Scanner scan=new Scanner(System.in);
		  //final String[] receiver= {getReceiver()};
		
			try {
				// intialize the client socket
				s = new Socket("localhost",6668);
				
				// initialize the input and output stream
				DataInputStream dis=new DataInputStream(s.getInputStream());
				DataOutputStream dout=new DataOutputStream(s.getOutputStream());
				
				/*  IN THIS PLACE HAD A FEATURE OF LOGIN/SIGNUP */
				
				
				// get the userName 
				System.out.print("Enter your Name : ");
				String clientName=scan.nextLine();
				
				
				// send the user name first 
				dout.writeUTF(clientName);
				dout.flush();
				
				 
				
				// to sent message
				Thread sendMessage=new Thread(()->{
					while(true) {
					String message=scan.nextLine();
					try {
						dout.writeUTF(message);
						dout.flush();
						if(message.equals("bye"))
							break;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				});	
				
				// to read the incomeing messages
				Thread readMessage=new Thread(()->{
					while(true) {
					
					try {
						String message=dis.readUTF();
						System.out.println(message+"@Natarajan");
						
						
						if(message.equals("bye"))
							break;
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				});	
				sendMessage.start();
				readMessage.start();
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
//This method extract the receiver name from the sender's message
		private static  String getReceiver(String str) {
			int ind=0;
			while(str.charAt(ind)!=':') {
				ind++;
			}
			return str.substring(0,ind);
		}

}
