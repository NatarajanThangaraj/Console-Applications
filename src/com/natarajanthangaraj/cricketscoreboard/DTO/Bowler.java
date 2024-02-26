package com.natarajanthangaraj.cricketscoreboard.DTO;

public class Bowler {
	private String bowlerName;
	private int oversBowled;
	private int givenRuns;
	private int wickets;
	// private double economy
	public String getBowlerName() {
		return bowlerName;
	}
	public Bowler(String playerName) {
		this.bowlerName=playerName;
	}
	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}

	public int getOversBowled() {
		return oversBowled;
	}

	public void setOversBowled(int oversBowled) {
		this.oversBowled = oversBowled;
	}

	public int getGivenRuns() {
		return givenRuns;
	}

	public void setGivenRuns(int givenRuns) {
		this.givenRuns = givenRuns;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
}
