package com.fantasy.controllers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantasy.dao.AccountDAO;
import com.fantasy.dao.FixtureDAO;
import com.fantasy.dao.PredictionDAO;
import com.fantasy.model.Fixture;
import com.fantasy.model.Prediction;

@Controller
public class DisplayPredictionsController {

	@Autowired
	private FixtureDAO fixtureDao;
	
	@Autowired
	private PredictionDAO predictionDao;
	
	@Autowired
	private AccountDAO accountDao;
	
	// http://localhost:8080/tournament/displayPredictions.html
	@RequestMapping(value="/displayPredictions", method=RequestMethod.GET)
	public String accountCreated (Model model) {
		List<Fixture> fixtures = fixtureDao.getAllFixturesSorted();
		List<Prediction> predictions = predictionDao.getAllPredictions();
		
		// Populated predictions for each fixture
		// TODO: Must be a better way of doing this
		for (Fixture f: fixtures) {
			int gameid = f.getGameid();
			List<Prediction> fixturePredictions = new ArrayList<Prediction>();
			
			for (Prediction p: predictions){
				if (gameid == p.getGameid()) {
					p.setName(accountDao.getAccountById(p.getId()).getFirstname());
					fixturePredictions.add(p);
				}
			}
			
			f.setPredictions(fixturePredictions);
		}
				
		model.addAttribute("fixtures", fixtures);
		model.addAttribute("users", accountDao.getAllAccounts());
		// Should be set through login screen now
		// model.addAttribute("user", accountDao.getAccountById(id));

		return "displayPredictions";
	}

	public FixtureDAO getFixtureDao() {
		return fixtureDao;
	}

	public void setFixtureDao(FixtureDAO fixtureDao) {
		System.out.println("Setting " + fixtureDao);
		this.fixtureDao = fixtureDao;
	}

	public PredictionDAO getPredictionDao() {
		return predictionDao;
	}

	public void setPredictionDao(PredictionDAO predictionDao) {
		System.out.println("Setting " + predictionDao);
		this.predictionDao = predictionDao;
	}

	public AccountDAO getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDAO accountDao) {
		System.out.println("Setting " + accountDao);
		this.accountDao = accountDao;
	}

}
