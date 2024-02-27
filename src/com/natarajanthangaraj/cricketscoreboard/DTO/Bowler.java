package com.natarajanthangaraj.cricketscoreboard.DTO;

public class Bowler {
	private String bowlerName;
	private String oversBowled;
	private int balls;
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
	public int getGivenRuns() {
		return givenRuns;
	}

	public void setGivenRuns(int givenRuns) {
		this.givenRuns+=givenRuns;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets() {
		this.wickets++;
	}
	public int getBalls() {
		return balls;
	}
	public void increaseBalls() {
		this.balls++;
	}
	public String getOversBowled() {
		int over = balls / 6;
		int ball = balls % 6;
		return switch (balls) {
		case 1 -> "0.1";
		case 2 -> "0.2";
		case 3 -> "0.3";
		case 4 -> "0.4";
		case 5 -> "0.5";
		default -> over + "." + ball;
	};
	}
	public void increaseBalls(String oversBowled) {
		this.oversBowled = oversBowled;
	}
	
}
