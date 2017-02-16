package com.fantasy.model;

import java.util.ArrayList;
import java.util.List;

public class Fixtures {
	
	private List<Fixture> fixtures = new ArrayList<Fixture>();
	
	public Fixtures () {}
	
	public Fixtures (List<Fixture> f) {
		setFixtures(f);
	}
	
	public List<Fixture> getFixtures() {
		return fixtures;
	}

	public void setFixtures(List<Fixture> fixtures) {
		this.fixtures = fixtures;
	}
}
