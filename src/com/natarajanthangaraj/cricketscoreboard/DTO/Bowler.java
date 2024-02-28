package com.natarajanthangaraj.cricketscoreboard.DTO;

public class Bowler {
	private Player player;
	private String bowlerName;
	private int balls;
	private int givenRuns;
	private int wickets;
	// private double economy
	public String getBowlerName() {
		return this.player.getPlayerName();
	}
	public Bowler(Player player) {
		this.player=player;
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
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
