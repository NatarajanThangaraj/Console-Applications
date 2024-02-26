package com.natarajanthangaraj.cricketscoreboard.DTO;

import java.util.ArrayList;

public class Innings {
	private Batter striker;
	private Batter nonStriker;
	private Bowler bowler;
	private ArrayList<Batter> inningsBat = new ArrayList<>();
	private ArrayList<Bowler> inningsBowl = new ArrayList<>();
	public Batter getStriker() {
		return striker;
	}

	public void setStriker(Batter striker) {
		this.striker = striker;
	}

	public Batter getNonStriker() {
		return nonStriker;
	}

	public void setNonStriker(Batter nonStriker) {
		this.nonStriker = nonStriker;
	}

	public Bowler getBowler() {
		return bowler;
	}

	public void setBowler(Bowler bowler) {
		this.bowler = bowler;
	}
	public ArrayList<Batter> getInningsBat() {
		return inningsBat;
	}

	public void setInningsBat(ArrayList<Batter> inningsBat) {
		this.inningsBat = inningsBat;
	}

	public ArrayList<Bowler> getInningsBowl() {
		return inningsBowl;
	}

	public void setInningsBowl(ArrayList<Bowler> inningsBowl) {
		this.inningsBowl = inningsBowl;
	}


}
