package com.natarajanthangaraj.mingle_thechatapp.user;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable{
	Socket socket;
	DataOutputStream dos;
	BufferedReader reader;
    String userName;
    Thread text;
	public Client(String userName) {
    	try {
			socket= new Socket("localhost",80);
			dos=new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	
    	reader=new BufferedReader(new InputStreamReader(System.in));
    	this.userName=userName;
    	text=new Thread(this);
    	text.start();
//    	dos.close();
//    	reader.close();
     }
	
	public static void main(String[] args) {
		Client client =new Client("Rahul");
	}

	@Override
	public void run() {
		try {
			String message=reader.readLine();
			dos.writeUTF(message);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
