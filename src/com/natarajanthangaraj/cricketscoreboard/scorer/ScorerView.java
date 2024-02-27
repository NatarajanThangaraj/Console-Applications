package com.natarajanthangaraj.cricketscoreboard.scorer;

import java.util.ArrayList;

import com.natarajanthangaraj.cricketscoreboard.BaseView;
import com.natarajanthangaraj.cricketscoreboard.DTO.Batter;
import com.natarajanthangaraj.cricketscoreboard.DTO.Bowler;
import com.natarajanthangaraj.cricketscoreboard.DTO.Innings;
import com.natarajanthangaraj.cricketscoreboard.DTO.Player;
import com.natarajanthangaraj.cricketscoreboard.DTO.ScoreBoard;
import com.natarajanthangaraj.cricketscoreboard.DTO.Team;

public class ScorerView extends BaseView {
	public ScorerViewModel scorerViewModel;

	public ScorerView() {
		this.scorerViewModel = new ScorerViewModel(this);

	}

	public void startScoring(ScoreBoard scoreCard) {
		int totalOvers = scoreCard.getTotalOvers();
		int currentOvers = 0;
		int result = 0;
		startMessage();
		Innings innings1 = inningsInitialize(scoreCard.getTeams());
		inn: while (currentOvers < totalOvers) {
			for (int ball = 1; ball < 7; ball++) {
				results();
				// System.out.println(" Result of the "+ball+" ball : ");
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
			endOfOver(innings1, scoreCard);
		}
		endOfInnings(innings1, scoreCard);

	}

	private void endOfOver(Innings innings1, ScoreBoard scoreCard) {
		scorerViewModel.changeStriker(0, innings1);
		changeBowler(innings1, scoreCard);

	}

	private void endOfInnings(Innings innings1, ScoreBoard scoreCard) {

	}

	private Innings inningsInitialize(Team[] teams) {
		Innings innings = new Innings();
		System.out.println(" SELECT THE STRIKER : ");
		innings.setStriker(new Batter(selectPlayer(teams[0]).getPlayerName()));
		System.out.println(" SELECT THE NON-STRIKER : ");
		innings.setNonStriker(new Batter(selectPlayer(teams[0]).getPlayerName()));
		System.out.println(" SELECT THE BOWLER : ");
		innings.setBowler(new Bowler(selectPlayer(teams[1]).getPlayerName()));
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

	protected Player selectFielder(ScoreBoard score) {
		System.out.println("\t SELECT THE FIELDER : \t");
		Player fielder = selectPlayer(score.getTeams()[1]);
		return fielder;
	}

	private void startMessage() {
		System.out.println("\n\t LET'S START THE SCORING ... \t");
	}

	public void scoreView(Innings innings, ScoreBoard score) {
		int len=Math.max(innings.getStriker().getBatsmanName().length(), innings.getNonStriker().getBatsmanName().length());
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.printf("\t\t\t| %"+len+"s - %d (%d)  ||| %s - %d (%d) |",
				innings.getStriker().getBatsmanName(),
				innings.getStriker().getRuns(),
				innings.getStriker().getBalls(),
				innings.getNonStriker().getBatsmanName(), 
				innings.getNonStriker().getRuns(),
				innings.getNonStriker().getBalls());
		System.out.println("\t\t\t+---------------------------------------+\n\n");
		System.out.println("\t\t\t\t+==========================+");
		System.out.printf("\t\t\t\t|%s    %d - %d  | %s / %d |",
				score.getTeams()[0].getName().substring(0,3),
				score.getTotalRuns(),
				score.getWickets() ,
				score.getCurrentOvers(),
				score.getTotalOvers());
		System.out.println("\t\t\t\t+==========================+\n\n");
		System.out.println("\t\t\t\t+--------------------+");
		System.out.printf("\t\t\t | %s |%s - %d - %d |\n",
				innings.getBowler().getBowlerName(),
				innings.getBowler().getOversBowled(),
				innings.getBowler().getWickets(),
				innings.getBowler().getGivenRuns() );
		System.out.println("\t\t\t+--------------------+");
//		System.out.println("\t\t\t+------------------------------------------------+");
//		System.out.printf("\t\t\t| %-3s* - %-1d (%-1d) ||| %-3s - %-1d (%d)|\n", innings.getStriker().getBatsmanName(),
//				innings.getStriker().getRuns(), innings.getStriker().getBalls(),
//				innings.getNonStriker().getBatsmanName(), innings.getNonStriker().getRuns(),
//				innings.getNonStriker().getBalls());
//		System.out.printf("\t\t\t| %-5d -%-5d %-5s |\n", score.getTotalRuns(),score.getWickets() ,score.getCurrentOvers());
//		
//		System.out.println("\t\t\t+------------------------------------------------+");

	}

	public void changeBatsman(Innings innings, ScoreBoard scoreCard,String outType) {
		Batter outedBatter = innings.getStriker();
		outedBatter.setOutType(outType, innings.getBowler().getBowlerName());
		innings.setInningsBat(outedBatter);
		System.out.println(" SELECT NEW BATSMAN : ");
		innings.setStriker(new Batter(selectPlayer(scoreCard.getTeams()[0]).getPlayerName()));
	}
	public void changeBatsman(Innings innings,ScoreBoard scoreCard ,String outType, Player fielder) {
		Batter outedBatter = innings.getStriker();
		outedBatter.setOutType(outType, innings.getBowler().getBowlerName(),fielder.getPlayerName());
		innings.setInningsBat(outedBatter);
		System.out.println(" SELECT NEW BATSMAN : ");
		innings.setStriker(new Batter(selectPlayer(scoreCard.getTeams()[0]).getPlayerName()));
		
	}

	private void changeBowler(Innings innings1, ScoreBoard scoreCard) {
		Bowler currentBowler = innings1.getBowler();
		innings1.setInningsBowl(currentBowler);
		System.out.println(" SELECT NEW BOWLER : ");
		innings1.setBowler(new Bowler(selectPlayer(scoreCard.getTeams()[1]).getPlayerName()));

	}

	public int getScoredRuns() {
		return getNumber("Scored Runs");
	}

	public void freeHitMessage() {
		System.out.println("\t....  It is the FREE-HIT ....\t");

	}

	public void reBowlMessage() {
		System.out.println("\t....  It is the Re-Ball ....\t");

	}

	

}
