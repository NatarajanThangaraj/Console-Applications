package com.natarajanthangaraj.cricketscoreboard.scorer;

import java.util.ArrayList;
import java.util.Arrays;

import com.natarajanthangaraj.cricketscoreboard.BaseView;
import com.natarajanthangaraj.cricketscoreboard.DTO.Batter;
import com.natarajanthangaraj.cricketscoreboard.DTO.Bowler;
import com.natarajanthangaraj.cricketscoreboard.DTO.Innings;
import com.natarajanthangaraj.cricketscoreboard.DTO.Player;
import com.natarajanthangaraj.cricketscoreboard.DTO.ScoreBoard;
import com.natarajanthangaraj.cricketscoreboard.DTO.Team;

public class ScorerView extends BaseView {
	public ScorerViewModel scorerViewModel;
	public ScoreBoard scoreCard;

	public ScorerView() {
		this.scorerViewModel = new ScorerViewModel(this);

	}

	public void startScoring(ScoreBoard scoreCard) {
		this.scoreCard = scoreCard;
		startMessage();
		firstInnings();
		secondInnings();
	}

	private void firstInnings() {
		firstInnMessage();
		int totalOvers = scoreCard.getTotalOvers();
		int currentOvers = 0;
		int result = 0;

		Innings innings1 = inningsInitialize(scoreCard.getTeams());
		inn: while (currentOvers < totalOvers) {
			for (int ball = 1; ball < 7; ball++) {
				results();
				result = getNumber(" Result of the Ball");
				scorerViewModel.updateScore(result, ball, innings1, scoreCard);
				if (result == 6) {
					reBowlMessage();
					ball--;
				} else if (result == 7) {
					freeHitMessage();
					ball--;
				} else if (scoreCard.getWickets() == 10) {
					break inn;
				}
			}
			currentOvers++;
			endOfOver(innings1);
			if (currentOvers != totalOvers)
				changeBowler(innings1);

		}
		endOfInnings(innings1);

	}

	private void secondInnings() {
		secInnMessage();
		int totalOvers = scoreCard.getTotalOvers();
		int currentOvers = 0;
		int result = 0;
		startMessage();
		Innings innings2 = inningsInitialize(scoreCard.getTeams());
		inn: while (currentOvers < totalOvers) {
			for (int ball = 1; ball < 7; ball++) {
				results();
				result = getNumber(" Result of the Ball");
				scorerViewModel.updateScore(result, ball, innings2, scoreCard);
				if (result == 6) {
					reBowlMessage();
					ball--;
				} else if (result == 7) {
					freeHitMessage();
					ball--;
				} else if (scoreCard.getWickets() == 10) {
					if (scoreCard.getTarget() > scoreCard.getTotalRuns()) {
						winningMessage();
					}
					break inn;
				} else if (scoreCard.getTarget() <= scoreCard.getTotalRuns()) {
					break inn;
				}
			}
			currentOvers++;
			endOfOver(innings2);
			
			if (currentOvers != totalOvers)
				changeBowler(innings2);

		}
		endOfInnings(innings2);
		winningMessage();

	}

	private void endOfOver(Innings innings) {
		scorerViewModel.changeStriker(1, innings);
		Bowler currentBowler = innings.getBowler();
		innings.setInningsBowl(currentBowler);
	}

	private void endOfInnings(Innings innings) {
		
		scoreCard.setInnings(innings);
		scoreCard.setTarget();
		addStrikerandNonStriker(innings);
		battingScoreCard(innings);
		extrasScoreCard();
		bowlingScoreCard(innings);
		swapTeams();
	}


	private void bowlingScoreCard(Innings innings) {
		System.out.println("\t+--------------------------------------+");
		System.out.println("\t|             | OVERS - WICKETS - RUNS |");
		System.out.println("\t+--------------------------------------+");

		for (Bowler bowler : innings.getInningsBowl()) {
			System.out.printf("\t| %-16s | %-4s - %-4d - %-4d |\n", bowler.getBowlerName(), bowler.getOversBowled(),
					bowler.getWickets(), bowler.getGivenRuns());
		}

		System.out.println("\t+--------------------------------------+");
	}

	private void battingScoreCard(Innings innings) {
		System.out.println("\t\t\t+------------------------------------------+");
		System.out.println("\t\t\t|             | RUNS  - BALLS - SIX - FOUR  |");
		System.out.println("\t\t\t+------------------------------------------+");

		for (Batter batter : innings.getInningsBat()) {
			System.out.printf("\t\t\t| %-20s | %-4d - %-5d - %-4d - %-4d |\n", batter.getBatsmanName(),
					batter.getRuns(), batter.getBalls(), batter.getSixes(), batter.getFours());
			System.out.printf("\t\t\t|%s|\n", batter.getOutType());
		}

		System.out.println("\t\t\t+------------------------------------------+");
	}
	private void extrasScoreCard() {
		System.out.println(" \t\t\t EXTRAS : "+scoreCard.getExtras());
		scoreCard.clearExtras();
	}
	private Innings inningsInitialize(Team[] teams) {
		Innings innings = new Innings();
		System.out.println(" SELECT THE STRIKER : ");
		innings.setStriker(new Batter(selectPlayer(teams[0]).getPlayerName()));
		System.out.println(" SELECT THE NON-STRIKER : ");
		innings.setNonStriker(new Batter(selectPlayer(teams[0]).getPlayerName()));
		System.out.println(" SELECT THE BOWLER : ");
		innings.setBowler(new Bowler(selectPlayer(teams[1])));
		innings.setTeam(teams);
		return innings;
	}

	private void results() {
		try {
		Thread.sleep(3000);
		}catch(Exception e) {}
		System.out.println("+-----------+-----------+--------------+-----------+");
		System.out.println("| 1. Dot    | 2. Run    | 3. Boundary  | 4. Six    |");
		System.out.println("+-----------+-----------+--------------+-----------+");
		System.out.println("| 5. Bye    | 6. Wide   | 7. No-Ball   | 8. Leg-Bye|");
		System.out.println("+-----------+-----------+--------------+-----------+");
		System.out.println("| 9. Bowled |10. Caught-|11. Run-Out   |12. LBW    |");
		System.out.println("|           |   Out     |              |           |");
		System.out.println("+-----------+-----------+--------------+-----------+");
	}

	// create specific selection both batsman and bowler
	private Player selectPlayer(Team team) {
		ArrayList<Player> playerList = team.getPlayerList();
		int serialNumber = 1, selectedPlayer;
		System.out.println(" TEAM : " + team.getName());
		for (Player player : playerList) {
			System.out.println(serialNumber + " : " + player.getPlayerName());
			serialNumber++;
		}
		selectedPlayer = getNumber("Player Number");
		return playerList.get(selectedPlayer - 1);
	}

	protected Player selectFielder() {
		System.out.println("\t SELECT THE FIELDER : \t");
		Player fielder = selectPlayer(scoreCard.getTeams()[1]);
		return fielder;
	}

	public void scoreView(Innings innings, ScoreBoard scoreCard) {
	    int len = Math.max(innings.getStriker().getBatsmanName().length(),
	            innings.getNonStriker().getBatsmanName().length());

	    System.out.println("\t\t\t+----------------------------------------+");
	   
	    System.out.println("\t\t\t+----------------------------------------+");
	    System.out.printf("\t\t\t| %-"+len +"s* - %4d (%5d)  ||| %7s - %4d (%5d)  |\n",
	            innings.getStriker().getBatsmanName(), innings.getStriker().getRuns(), innings.getStriker().getBalls(),
	            innings.getNonStriker().getBatsmanName(), innings.getNonStriker().getRuns(),
	            innings.getNonStriker().getBalls());

	    System.out.println("\t\t\t+----------------------------------------+");
	  

	    if (scoreCard.getTarget() == 0) {
	        System.out.printf("\t\t\t|    %5s    %d - %d  | %s / %d  |\n",
	                scoreCard.getTeams()[0].getName().substring(0, 3), scoreCard.getTotalRuns(), scoreCard.getWickets(),
	                scoreCard.getCurrentOvers(), scoreCard.getTotalOvers());
	    } else {
	        System.out.printf("\t\t\t|    %5s    %d - %d  | %s / %d  | --- | TARGET  :  %d  |\n",
	                scoreCard.getTeams()[0].getName().substring(0, 3), scoreCard.getTotalRuns(), scoreCard.getWickets(),
	                scoreCard.getCurrentOvers(), scoreCard.getTotalOvers(), scoreCard.getTarget());
	    }

	  
	    System.out.printf("\t\t\t| %6s |%5s - %d - %d |\n", innings.getBowler().getBowlerName(),
	            innings.getBowler().getOversBowled(), innings.getBowler().getWickets(),
	            innings.getBowler().getGivenRuns());
	    System.out.println("\t\t\t+----------------------------------------+");
	}

	public void changeBatsman(Innings innings, ScoreBoard score, String outType) {
		Batter outedBatter = innings.getStriker();
		outedBatter.setOutType(outType, innings.getBowler().getBowlerName());
		innings.setInningsBat(outedBatter);
		System.out.println(" SELECT NEW BATSMAN : ");
		innings.setStriker(new Batter(selectPlayer(score.getTeams()[0]).getPlayerName()));
	}

	public void changeBatsman(Innings innings, String outType, Player fielder) {
		Batter outedBatter = innings.getStriker();
		outedBatter.setOutType(outType, innings.getBowler().getBowlerName(), fielder.getPlayerName());
		innings.setInningsBat(outedBatter);
		System.out.println(" SELECT NEW BATSMAN : ");
		innings.setStriker(new Batter(selectPlayer(scoreCard.getTeams()[0]).getPlayerName()));

	}

	private void addStrikerandNonStriker(Innings innings) {
		innings.setInningsBat(innings.getStriker());
		innings.setInningsBat(innings.getNonStriker());

	}

	private void changeBowler(Innings innings1) {
		System.out.println(" SELECT NEW BOWLER : ");
		innings1.setBowler(new Bowler(selectPlayer(scoreCard.getTeams()[1])));

	}

	private void swapTeams() {
		this.scoreCard.setTeams(new Team[] { scoreCard.getTeams()[1], scoreCard.getTeams()[0] });
	}

	public int getScoredRuns() {
		return getNumber("Scored Runs");
	}

	private void startMessage() {
		System.out.println("\n\t LET'S START THE SCORING ... \n");
	}

	private void firstInnMessage() {
		System.out.println(" \t\t\t" + scoreCard.getTeams()[0].getName() + " WON THE TOSS and CHOOSE TO BAT FIRST \n");
	}

	private void secInnMessage() {
		System.out.println(" \t\t\t" + scoreCard.getTeams()[0].getName() + " COME TO CHASE THE TARGET \n");
	}

	public void freeHitMessage() {
		System.out.println("\t....  It is the FREE-HIT ....\n");

	}

	public void reBowlMessage() {
		System.out.println("\t....  It is the Re-Ball ....\n");

	}

	private void winningMessage() {
		if (scoreCard.getWickets() == 10 || scoreCard.getTarget() > scoreCard.getTotalRuns()) {
			System.out.println("\t\t *** *** *** " + scoreCard.getTeams()[0].getName() + " WON THE MATCH *** *** *** ");
		} else {
			
			System.out.println("\t\t *** *** *** " + scoreCard.getTeams()[1].getName() + " WON THE MATCH *** *** *** ");
		}
	}

}
