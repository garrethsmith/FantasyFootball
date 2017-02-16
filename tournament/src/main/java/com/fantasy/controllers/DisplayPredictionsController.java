package com.fantasy.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantasy.dao.FixtureDAO;
import com.fantasy.model.Fixtures;

@Controller
public class DisplayPredictionsController {
	
	private FixtureDAO fixtureDao;
	
	// http://localhost:8080/tournament/createaccount.html
	@RequestMapping(value="/displayPredictions", method=RequestMethod.GET)
	public String accountCreated (Model model) {
		Fixtures fixtureList = new Fixtures(fixtureDao.getAllFixtures());
		model.addAttribute("fixtures", fixtureList);	
		
		return "displayPredictions";
	}

	public FixtureDAO getFixtureDao() {
		return fixtureDao;
	}

	public void setFixtureDao(FixtureDAO fixtureDao) {
		this.fixtureDao = fixtureDao;
	}

}
