package com.natarajanthangaraj.cricketscoreboard.DTO;

public class ScoreBoard {
	private String battingTeam;
	private int totalRuns;
	private int wickets;
	private int target;
	private int totalOvers;
	private String currentOvers;
	private int totalBalls;
	private int extras;
	private Team[] teams = new Team[2];
	private Innings innings1 ;
	private Innings innings2;

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
		this.totalRuns+=totalRuns;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets() {
		this.wickets ++;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget() {
		this.target =this.totalRuns+1;
		this.totalRuns=0;
		this.wickets=0;
		this.totalBalls=0;
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
		return innings1;
	}

	public void setInnings(Innings innings) {
		if(this.innings1==null)
		innings1 = innings;
		else {
			innings2=innings;
		}
	}

	public Innings getInnings2() {
		return innings2;
	}

//	public void setInnings2(Innings innings2) {
//		Innings2 = innings2;
//	}

	public int getExtras() {
		return extras;
	}

	public void setExtras(int extras) {
		this.extras += extras;
	}
	public void clearExtras() {
		this.extras=0;}

	

	public int getTotalBalls() {
		
		return totalBalls;
	}

	public void increaseBall() {
		this.totalBalls++;
	}

	public String getCurrentOvers() {
		int over = totalBalls / 6;
		int ball = totalBalls % 6;
		return switch (totalBalls) {
		case 1 -> "0.1";
		case 2 -> "0.2";
		case 3 -> "0.3";
		case 4 -> "0.4";
		case 5 -> "0.5";
		default -> over + "." + ball;
};

		
	}

	public void setCurrentOvers(String currentOvers) {
		this.currentOvers = currentOvers;
	}

	
}
