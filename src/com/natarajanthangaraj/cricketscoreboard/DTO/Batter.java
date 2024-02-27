package com.natarajanthangaraj.cricketscoreboard.DTO;

public class Batter {
	private String batsmanName;
	private int runs;
	private int balls;
	private int fours;
	private int sixes;
	private String outType;

	public Batter(String playerName) {
		this.batsmanName = playerName;
	}

	public String getBatsmanName() {
		return batsmanName;
	}

	public void setBatsmanName(String batsmanName) {
		this.batsmanName = batsmanName;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs += runs;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls() {
		this.balls++;
	}

	public int getFours() {
		return fours;
	}

	public void setFours() {
		this.fours++;
		this.runs += 4;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes() {
		this.sixes++;
		this.runs += 6;
	}

	public String getOutType() {
		return outType;
	}

	public void setOutType(String outType, String bowler) {
		switch (outType) {
		case "bowled" -> {
			this.outType = " b " + bowler;
		}
		case "lbw" -> {
			this.outType = " [ LBW ] " + bowler;
		}
		default -> {
			this.outType = "*";
		}
		}

	}

	public void setOutType(String outType, String bowler, String fielder) {
		switch (outType) {
		case "caught out" -> {
			this.outType = " c " + fielder + "  " + " b " + bowler;
		}
		case "run out" -> {
			this.outType = " [ Run Out ]" + fielder;
		}
		case "stumped" -> {
			this.outType = " St " + fielder + " b " + bowler;
		}
		}

	}

}
