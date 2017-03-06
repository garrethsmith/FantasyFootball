package com.fantasy.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fantasy.dao.PredictionDAO;
import com.fantasy.model.Prediction;
import com.fantasy.validators.PredictionValidator;

@RestController
public class PredictionAjaxController {
	
	PredictionDAO predictionDao;
	PredictionValidator predictionValidator;
	
	//@RequestMapping(value = "/setPrediction.html", consumes = MediaType.APPLICATION_JSON_VALUE,
	//	method = RequestMethod.POST, headers="Accept=application/json")
	
	@RequestMapping (value = "/setPrediction.html", method = RequestMethod.POST)
	public String setUserPrediction(@RequestBody String prediction, BindingResult result, Model model) {
		JSONObject json = new JSONObject(prediction);		
		Integer id = new Integer(json.getString("id").substring(0, json.getString("id").lastIndexOf('-')));
		Integer gameid = new Integer(json.getString("id").substring(json.getString("id").lastIndexOf('-')+1, json.getString("id").length()));
	
		Prediction p = new Prediction(id.intValue(), gameid.intValue(), json.getString("value").trim());
		
		predictionValidator.validate(p, result);
		
		if (result.hasErrors())
			return "Validation fail";
		
		if (predictionDao.updatePrediction(p))
			return json.toString();
		
		return "FAILURE";
	}
	
	@RequestMapping (value = "/setPredictionString.html", method = RequestMethod.POST)
	public String setUserPredictionString(@RequestBody String prediction) {
		Prediction result = new Prediction();
		
		updatePrediction (result);
		
		return "completed";
	}
	
	private boolean updatePrediction (Prediction p) {
		return true;
	}

	public PredictionDAO getPredictionDao() {
		return predictionDao;
	}
	
	@Autowired
	public void setPredictionDao(PredictionDAO predictionDao) {
		this.predictionDao = predictionDao;
	}

	public PredictionValidator getPredictionValidator() {
		return predictionValidator;
	}

	@Autowired
	public void setPredictionValidator(PredictionValidator predictionValidator) {
		this.predictionValidator = predictionValidator;
	}
	
}
