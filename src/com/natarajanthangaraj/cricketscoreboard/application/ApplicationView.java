package com.natarajanthangaraj.cricketscoreboard.application;

import java.util.ArrayList;

import com.natarajanthangaraj.cricketscoreboard.BaseView;
import com.natarajanthangaraj.cricketscoreboard.DTO.Player;
import com.natarajanthangaraj.cricketscoreboard.DTO.ScoreBoard;
import com.natarajanthangaraj.cricketscoreboard.DTO.Team;

public class ApplicationView extends BaseView {
	private ApplicationViewModel applicationViewModel;

	public ApplicationView() {
		this.applicationViewModel = new ApplicationViewModel(this);
	}

	public void start() {
		ScoreBoard scoreCard = getMatchInfo();
		applicationViewModel.startScoring(scoreCard);

	}

	private ScoreBoard getMatchInfo() {
		ScoreBoard scoreBoard = new ScoreBoard();
		scoreBoard.setTeams(getTeamsInfo());
		scoreBoard.setTotalOvers(getNumber("OVERS LIMIT"));
		return scoreBoard;
	}

	private Team[] getTeamsInfo() {
		Team[] teams = new Team[2];
		System.out.println("/t TEAM 1 DETAILS /t");
		teams[0] = getTeam();
		System.out.println("/t TEAM 1 DETAILS /t");
		teams[1] = getTeam();
		return teams;
	}

	private Team getTeam() {
		Team team = new Team();
		team.setName(getString(" TEAM NAME "));
		ArrayList<Player> players = new ArrayList<>();
		System.out.println("/n   GIVE PLAYING 11'S   /n");
		for (int i = 1; i < 12; i++) {
			Player player = new Player();
			player.setPlayerName(getString(" player " + i + " Name"));
			player.setTeamName(team);
			players.add(player);
		}
		team.setPlayerList(players);
		return team;
	}

}
