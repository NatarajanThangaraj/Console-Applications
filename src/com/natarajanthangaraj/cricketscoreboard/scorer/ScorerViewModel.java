package com.natarajanthangaraj.cricketscoreboard.scorer;

import com.natarajanthangaraj.cricketscoreboard.DTO.Innings;
import com.natarajanthangaraj.cricketscoreboard.DTO.ScoreBoard;

public class ScorerViewModel {
 private ScorerView scoreView;
	public ScorerViewModel( ScorerView scoreView) {
		this.scoreView=scoreView;
	}

	public void updateScore(int result, int ball, Innings innings, ScoreBoard score) {
		switch(result) {
		case 1->{// dot ball
			score.setCurrentOvers(score.getCurrentOvers()+"."+ball);
			innings.getStriker().setBalls();
			scoreView.scoreView(innings,score);
			// yet to bowler
		}
		}
		
	}

}
