package com.natarajanthangaraj.cricketscoreboard.application;

import com.natarajanthangaraj.cricketscoreboard.DTO.ScoreBoard;
import com.natarajanthangaraj.cricketscoreboard.scorer.ScorerView;

public class ApplicationViewModel {
 private ApplicationView applicationView;
 // itu need ahhh...direct application view la irunthu send panniralamey
 private final ScorerView scorer=new ScorerView();
	public ApplicationViewModel(ApplicationView applicationView) {
		this.applicationView=applicationView;
	}
	public void startScoring(ScoreBoard scoreCard) {
		scorer.startScoring(scoreCard);
		
	}

}
