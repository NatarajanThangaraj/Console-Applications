package com.natarajanthangaraj.foodordertracker.tracker;

public class TrackPresenter {
private TrackView trackerview;
private TrackModel trackermodel;
	public TrackPresenter(TrackView trackView) {
		this.trackerview=trackView;
	}
	public TrackPresenter(TrackModel trackModel) {
		this.trackermodel=trackModel;
	}

}
