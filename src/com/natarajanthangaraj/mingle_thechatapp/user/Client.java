package com.natarajanthangaraj.mingle_thechatapp.user;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable{
	Socket socket;
	DataOutputStream dos;
	BufferedReader reader;
    String userName;
    Thread text;
	Client(String userName) throws Exception{
    	socket= new Socket("localhost",80);
    	dos=new DataOutputStream(socket.getOutputStream());
    	reader=new BufferedReader(new InputStreamReader(System.in));
    	this.userName=userName;
    	text=new Thread(this);
     }
	
	public static void main(String[] args) {
		

	}

	@Override
	public void run() {
		
		
	}

}
