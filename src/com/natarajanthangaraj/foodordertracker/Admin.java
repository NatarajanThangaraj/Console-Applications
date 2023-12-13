package com.natarajanthangaraj.foodordertracker;

import com.natarajanthangaraj.foodordertracker.tracker.TrackView;

public class Admin {
	
	public static void main(String[] args) {
		Admin admin=new Admin();
		admin.start();
	}

	private void start() {
		TrackView track=new TrackView();
		track.start();
		
	}

}
