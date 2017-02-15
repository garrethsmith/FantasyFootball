package com.fantasy.model;

import java.util.Date;

public class Fixture {
	
	private int id;
	private String homeTeam;
	private String awayTeam;
	private Date kickOff;
	private String matchResult;
	private String round;
	
	public Fixture () {}
	
	public Fixture (int id, String homeTeam, String awayTeam, 
			Date kickOff, String matchResult, String round) {
		this.id = id;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.kickOff = kickOff;
		this.matchResult = matchResult;
		this.round = round;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getHomeTeam() {
		return homeTeam;
	}
	
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	
	public String getAwayTeam() {
		return awayTeam;
	}
	
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	public Date getKickOff() {
		return kickOff;
	}
	
	public void setKickOff(Date kickOff) {
		this.kickOff = kickOff;
	}
	
	public String getMatchResult() {
		return matchResult;
	}
	
	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}
	
	public String getRound() {
		return round;
	}
	
	public void setRound(String round) {
		this.round = round;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fixture) 
			if (this.id == ((Fixture) obj).getId())
				return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
