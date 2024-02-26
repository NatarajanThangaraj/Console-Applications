package com.natarajanthangaraj.cricketscoreboard.DTO;

import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Player> playerList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
}
