package com.natarajanthangaraj.mingle_thechatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Display implements Runnable {
   Socket socket;
   BufferedReader reader;
   InputStreamReader streamReader;
	

	public Display(Socket socket) {
		this.socket=socket;
		try {
		streamReader=new InputStreamReader(socket.getInputStream());
		reader=new BufferedReader(streamReader);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		

	}

}
