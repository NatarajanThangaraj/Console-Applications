package com.natarajanthangaraj.cricketscoreboard.DTO;

public class Player {
	private String playerName;
	private Team teamName;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Team getTeamName() {
		return teamName;
	}

	public void setTeamName(Team teamName) {
		this.teamName = teamName;
	}
}
