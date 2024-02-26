package com.natarajanthangaraj.cricketscoreboard.DTO;

public class CurrentPlayer {
	private Batter striker;
	private Batter nonStriker;
	private Bowler currentBowler;

	public Batter getStriker() {
		return striker;
	}

	public void setStriker(Batter striker) {
		this.striker = striker;
	}

	public Batter getNonStriker() {
		return nonStriker;
	}

	public void setNonStriker(Batter nonStriker) {
		this.nonStriker = nonStriker;
	}

	public Bowler getCurrentBowler() {
		return currentBowler;
	}

	public void setCurrentBowler(Bowler currentBowler) {
		this.currentBowler = currentBowler;
	}
}
