package com.natarajanthangaraj.cricketscoreboard.scorer;

import java.util.ArrayList;

import com.natarajanthangaraj.cricketscoreboard.BaseView;
import com.natarajanthangaraj.cricketscoreboard.DTO.Batter;
import com.natarajanthangaraj.cricketscoreboard.DTO.Bowler;
import com.natarajanthangaraj.cricketscoreboard.DTO.Innings;
import com.natarajanthangaraj.cricketscoreboard.DTO.Player;
import com.natarajanthangaraj.cricketscoreboard.DTO.ScoreBoard;
import com.natarajanthangaraj.cricketscoreboard.DTO.Team;

public class ScorerView extends BaseView{
	public ScorerViewModel scorerViewModel;

	public ScorerView() {
		this.scorerViewModel = new ScorerViewModel(this);

	}

	public void startScoring(ScoreBoard scoreCard) {
		int over=scoreCard.getTotalOvers();
		int result =0;
		startMessage();
		Innings innings1=inningsInitialize(scoreCard.getTeams(),1);
		while(over>0) {
			for(int ball=1;ball>7;) {
				results();
				//System.out.println(" Result of the "+ball+" ball : ");
				result=getNumber(" Result of the Ball");
				scorerViewModel.updateScore(result,ball,innings1,scoreCard);
			}
		}
	}

	private Innings inningsInitialize(Team[] teams,int p) {
		Innings innings=new Innings();
		int team1=0,team2=1;
		if(p!=1) {
			team1=1;
			team2=0;
		}
		System.out.println(" SELECT THE STRIKER : ");
		innings.setStriker(new Batter(selectPlayer(teams[team1]).getPlayerName()));
		System.out.println(" SELECT THE NON-STRIKER : ");
		innings.setNonStriker(new Batter(selectPlayer(teams[team1]).getPlayerName()));
		System.out.println(" SELECT THE BOWLER : ");
		innings.setBowler(new Bowler(selectPlayer(teams[team2]).getPlayerName()));
		return innings;
	}
	

	private void results() {
	        System.out.println("+-----------+-----------+--------------+-----------+");
	        System.out.println("| 1. Dot    | 2. Run    | 3. Boundary  | 4. Six    |");
	        System.out.println("+-----------+-----------+--------------+-----------+");
	        System.out.println("| 5. Bye    | 6. Wide   | 7. No-Ball   | 8. Leg-Bye|");
	        System.out.println("+-----------+-----------+--------------+-----------+");
	        System.out.println("| 9. Bowled |10. Caught-|11. Run-Out   |12. LBW    |");
	        System.out.println("|           |   Out     |              |           |");
	        System.out.println("+-----------+-----------+--------------+-----------+");
	}

	private Player selectPlayer(Team team) {
		ArrayList<Player>playerList=team.getPlayerList();
		int serialNumber=1,selectedPlayer;
		System.out.println(" TEAM : "+team.getName());
		for(Player player:playerList ) {
			System.out.println(serialNumber+" : "+player.getPlayerName());
		}
		selectedPlayer=getNumber("Player Number");
		return playerList.get(selectedPlayer);
	}
	private void startMessage() {
		System.out.println("/n/t LET'S START THE SCORING ... /t");
	}

	public void scoreView(Innings innings, ScoreBoard score) {
		System.out.println("+------------------------------------------------+");
		System.out.printf("| %-15s* | %-4d / %-4s | %-15s |\n",
		                  innings.getStriker().getBatsmanName(),
		                  score.getTotalRuns(),
		                  score.getCurrentOvers(),
		                  innings.getNonStriker().getBatsmanName());
		System.out.printf("|                                                | %-4s / %-4s |                                             |\n",
		                  score.getCurrentOvers(),
		                  score.getTotalOvers());
		System.out.println("+------------------------------------------------+");
                                                                                
		
	}

}
