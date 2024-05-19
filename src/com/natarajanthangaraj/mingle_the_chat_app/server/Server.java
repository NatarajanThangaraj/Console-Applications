package com.natarajanthangaraj.mingle_the_chat_app.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
  private static final int port=6668;
  private static Map<String,ClientHandler> clients=new HashMap<>();
	public static void main(String[] args) {
		 String clientName=null;
		try {
			// server socket
			ServerSocket ss = new ServerSocket(port);
			
			serverStartedMessage();
			// the server always in listening state 
			while(true) {
			Socket s=null;
			s=ss.accept();
			
			// to get the name of the client
			DataInputStream dis=new DataInputStream(s.getInputStream());
			clientName=dis.readUTF();
			
			// create a instance of ClientHandler for every new client is connect to the server
			ClientHandler handler=new ClientHandler(clientName,s);
			
			// save the name and the instance in the map
			clients.put(clientName,handler);
			// start the handler thread 
			handler.start();
			
			}
		} catch (IOException e) {
		   System.out.println(" Server ERROR !"+e);
		}
		
		

	}
	 static class ClientHandler extends Thread{
		Socket s;
		DataInputStream dis;
		DataOutputStream dout;
		String sender;
		ClientHandler(String userName,Socket ss){
			
			// initialize the all instance of the clientHandler
			this.s=ss;
			try {
				this.dis=new DataInputStream(s.getInputStream());
				this.dout=new DataOutputStream(s.getOutputStream());
				
				
				}catch(IOException e) {
					System.out.println("Problem on ClientHandler");
				}
			this.sender=userName;
		}
		
		public void run() {
			// Message@receiverName
			String msgWithName = null;
			do {
				try {
					// reads the message from the sender 
					msgWithName=dis.readUTF();
					
					// take the message
					String message=getMessage(msgWithName);
					
					//take the receiver name
					String receiver=getReceiver(msgWithName);
					
					// sends  the message to the correct receiver
					broadcastMessage(message,sender,receiver,this);
					
					// try to end chat
					if(message.equals("bye"))
						break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}while(true);
			
		}
		
		
		// This method was used to send the message to the specify receiver 
		private void broadcastMessage(String message, String sender,String receiver, ClientHandler user) {
			for(Map.Entry<String,ClientHandler> client:clients.entrySet()) {
				if(receiver.equals(client.getKey())) {
					user.sendMessage(sender+" : "+message);
				}
			}
			
		}
		
		// It is writer method in the receiver
		private void sendMessage(String string) {
			try {
			dout.writeUTF(string);
			dout.flush();
			}catch(IOException e) {
				System.err.println("SendMessageMethodError");
			}
		}
		
		//This method extract the receiver name from the sender's message
		private String getReceiver(String str) {
			int ind=0;
			while(str.charAt(ind)!='@') {
				ind++;
			}
			return str.substring(ind);
		}
		
		//This method extract the message from the sender's message
		private String getMessage(String str) {
			int ind=0;
			while(str.charAt(ind)!='@') {
				ind++;
			}
			return str.substring(ind+1,str.length());
		}
		
	}

	private static void serverStartedMessage() {
		System.out.println("The server has been started");
		
	}

}

