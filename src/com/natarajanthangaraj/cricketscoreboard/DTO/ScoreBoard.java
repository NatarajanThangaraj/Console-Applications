package com.natarajanthangaraj.cricketscoreboard.DTO;

public class ScoreBoard {
	private String battingTeam;
	private int totalRuns;
	private int wickets;
	private int target;
	private int totalOvers;
	private String currentOvers="0";
	private int extras;
	private Team[] teams = new Team[2];
	private Innings Innings1 ;
	private Innings Innings2;

	public String getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(String battingTeam) {
		this.battingTeam = battingTeam;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getTotalOvers() {
		return totalOvers;
	}

	public void setTotalOvers(int totalOvers) {
		this.totalOvers = totalOvers;
	}
	public Team[] getTeams() {
		return teams;
	}

	public void setTeams(Team[] teams) {
		this.teams = teams;
	}

	public Innings getInnings1() {
		return Innings1;
	}

	public void setInnings1(Innings innings1) {
		Innings1 = innings1;
	}

	public Innings getInnings2() {
		return Innings2;
	}

	public void setInnings2(Innings innings2) {
		Innings2 = innings2;
	}

	public int getExtras() {
		return extras;
	}

	public void setExtras(int extras) {
		this.extras = extras;
	}

	public String getCurrentOvers() {
		return currentOvers;
	}

	public void setCurrentOvers(String currentOvers) {
		this.currentOvers = currentOvers;
	}

	
}
