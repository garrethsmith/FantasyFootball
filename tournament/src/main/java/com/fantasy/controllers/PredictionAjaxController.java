package com.fantasy.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fantasy.jsonmodel.PredictionPojo;
import com.fantasy.model.Prediction;

@RestController
public class PredictionAjaxController {
	
	//@RequestMapping(value = "/setPrediction.html", consumes = MediaType.APPLICATION_JSON_VALUE,
	//	method = RequestMethod.POST, headers="Accept=application/json")
	
	@RequestMapping (value = "/setPrediction.html", method = RequestMethod.POST)
	public Prediction setUserPrediction(@RequestBody PredictionPojo prediction) {
		Prediction result = new Prediction();
		
		System.out.println("AJAX call made in controller");
		
		return result;
	}
	
	@RequestMapping (value = "/setPredictionString.html", method = RequestMethod.POST)
	public String setUserPredictionString(@RequestBody String prediction) {
		Prediction result = new Prediction();
		
		System.out.println("AJAX call made in controller value " + prediction);
		
		return "completed";
	}

}
