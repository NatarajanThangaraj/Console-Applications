package com.natarajanthangaraj.cricketscoreboard.scorer;

import com.natarajanthangaraj.cricketscoreboard.DTO.Batter;
import com.natarajanthangaraj.cricketscoreboard.DTO.Innings;
import com.natarajanthangaraj.cricketscoreboard.DTO.Player;
import com.natarajanthangaraj.cricketscoreboard.DTO.ScoreBoard;

public class ScorerViewModel {
	private ScorerView scoreView;

	public ScorerViewModel(ScorerView scoreView) {
		this.scoreView = scoreView;
	}

	public void updateScore(int result, int ball, Innings innings, ScoreBoard score) {
		int run = 0;
		switch (result) {
		case 1 -> {// dot ball
			score.increaseBall();
			innings.getStriker().setBalls();
			innings.getBowler().increaseBalls();

		}
		case 2 -> {// singles
			run = scoreView.getScoredRuns();
			score.setTotalRuns(run);
			innings.getStriker().setRuns(run);
			innings.getStriker().setBalls();
			innings.getBowler().setGivenRuns(run);
			innings.getBowler().increaseBalls();
			score.increaseBall();
			changeStriker(run, innings);

		}
		case 3 -> {// boundary
			score.setTotalRuns(4);
			innings.getStriker().setFours();
			innings.getStriker().setBalls();
			innings.getBowler().setGivenRuns(4);
			innings.getBowler().increaseBalls();
			score.increaseBall();

		}
		case 4 -> { // sixers
			score.setTotalRuns(6);
			innings.getStriker().setRuns(6);
			innings.getStriker().setBalls();
			innings.getBowler().setGivenRuns(6);
			innings.getBowler().increaseBalls();
			score.increaseBall();

		}
		case 5 -> {// Bye
			run = scoreView.getScoredRuns();
			score.setTotalRuns(run);
			innings.getStriker().setBalls();
			score.setExtras(run);
			innings.getBowler().increaseBalls();
			score.increaseBall();

		}
		case 6 -> {// wide
			run = scoreView.getScoredRuns();
			score.setTotalRuns(run + 1);
			score.setExtras(run + 1);
			innings.getBowler().setGivenRuns(run + 1);

		}
		case 7 -> {// no-ball
			run = scoreView.getScoredRuns();
			score.setTotalRuns(run + 1);
			score.setExtras(run + 1);
			innings.getStriker().setRuns(run + 1);
			innings.getBowler().setGivenRuns(run + 1);

		}
		case 8 -> {// leg-bye
			run = scoreView.getScoredRuns();
			score.setTotalRuns(run);
			score.setExtras(run);
			innings.getStriker().setBalls();
			innings.getBowler().increaseBalls();
			score.increaseBall();

		}
		case 9 -> {// bowled
			wicketListener(innings, score);
			scoreView.changeBatsman(innings, score,"bowled");
		}
		case 10 -> {// Caught-Out
			wicketListener(innings, score);
			scoreView.changeBatsman(innings,"caught out", scoreView.selectFielder());
		}
		case 11 -> {// Run-out
			wicketListener(innings, score);
			scoreView.changeBatsman(innings,"run out", scoreView.selectFielder());
		}
		case 12 -> {// lbw
			wicketListener(innings, score);
			scoreView.changeBatsman(innings, score,"lbw");
		}

		}
		scoreView.scoreView(innings, score);

	}

	protected void changeStriker(int run, Innings innings) {
		if (run % 2 != 0) {
			Batter temp = innings.getStriker();
			innings.setStriker(innings.getNonStriker());
			innings.setNonStriker(temp);
		}

	}

	private void wicketListener(Innings innings, ScoreBoard score) {
		score.setWickets();
		score.increaseBall();
		innings.getBowler().setWickets();
		innings.getBowler().increaseBalls();
	}
}
