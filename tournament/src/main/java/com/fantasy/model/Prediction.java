package com.fantasy.model;

import java.io.Serializable;
import java.util.Objects;

public class Prediction implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int id;
	private int gameid;
	private String prediction;
	
	public Prediction () {}
	
	public Prediction (int id, int gameid) {
		this.id = id;
		this.gameid = gameid;
	}
	
	public Prediction (int id, int gameid, String prediction) {
		this.id = id;
		this.gameid = gameid;
		this.prediction = prediction;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getGameid() {
		return gameid;
	}
	
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
	
	public String getPrediction() {
		if (prediction != null) {
			return prediction.trim();
		} else {
			return null;
		}
	}
	
	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Prediction) 
			if (this.gameid == ((Prediction) obj).getGameid())
				if (this.id == ((Prediction) obj).getId())
					return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getGameid());
	}

}
