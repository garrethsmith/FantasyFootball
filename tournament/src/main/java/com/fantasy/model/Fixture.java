package com.fantasy.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fixture {
	
	private int gameid;
	private String homeTeam;
	private String awayTeam;
	private Date kickOff;
	private String matchResult;
	private String round;
	private List<Prediction> predictions = new ArrayList<Prediction>();
	
	public Fixture () {}
	
	public Fixture (int id, String homeTeam, String awayTeam, 
			Date kickOff, String matchResult, String round) {
		setGameid(id);
		setHomeTeam(homeTeam);
		setAwayTeam(awayTeam);
		setKickOff(kickOff);
		setMatchResult(matchResult);
		setRound(round);
	}
	
	public int getGameid() {
		return gameid;
	}

	public void setGameid(int gameid) {
		this.gameid = gameid;
	}

	public String getHomeTeam() {
		return homeTeam;
	}
	
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam.trim();
	}
	
	public String getAwayTeam() {
		return awayTeam;
	}
	
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam.trim();
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
		this.matchResult = matchResult.trim();
	}
	
	public String getRound() {
		return round;
	}
	
	public void setRound(String round) {
		this.round = round.trim();
	}
	
	public List<Prediction> getPredictions() {
		return predictions;
	}

	public void setPredictions(List<Prediction> predictions) {
		this.predictions = predictions;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fixture) 
			if (this.gameid == ((Fixture) obj).getGameid())
				return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
