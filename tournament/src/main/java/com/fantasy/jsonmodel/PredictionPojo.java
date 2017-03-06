package com.fantasy.jsonmodel;

// No longer needed at result submitted through String

@Deprecated
public class PredictionPojo {

	private String id;
	private String value;
	
	
	public PredictionPojo () {}
	
	public PredictionPojo (String id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}
