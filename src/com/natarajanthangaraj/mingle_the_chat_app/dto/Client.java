package com.natarajanthangaraj.mingle_the_chat_app.dto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client{
	
	
	// scanner class for get input
	static Scanner scan=new Scanner(System.in);

	// All the friends,who chat with the user
    static List<String>people=new ArrayList<>();
	public static void main(String[] args) {
		
		// client socket
		Socket s;
		
		
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
				
				//add all users in list
				addPeople();
				// to choose the receiver
				 final String[] receiver = { selectPeople() };
				
				 
				
				// to sent message
				Thread sendMessage=new Thread(()->{
					while(true) {
					String message=scan.nextLine();
					
					try {
						dout.writeUTF(message+"@"+receiver[0]);
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
						System.out.println("client "+message);
						
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
	static String selectPeople() {
		System.out.println("♥✅  MINGLE");
		int i=1;
		for(String str:people) {
			System.out.println((i++)+" - "+str);
		}
		System.out.print(" Enter Number : ");
		i=scan.nextInt();
		 if (i > 0 && i <= people.size()) {
	            return people.get(i - 1);
	        } else {
	            return "group";
	        }
		}
		
	
	
	
	 static void addPeople() {
		 people.add("Karthika");
			people.add("Ananth");
			people.add("Amma");
	 }
	}





