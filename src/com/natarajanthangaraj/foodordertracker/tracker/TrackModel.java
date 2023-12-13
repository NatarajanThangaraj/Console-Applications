package com.natarajanthangaraj.foodordertracker.tracker;

public class TrackModel {
	private TrackPresenter trackpresenter;

	public TrackModel() {
		this.trackpresenter=new TrackPresenter(this);
	}
}
