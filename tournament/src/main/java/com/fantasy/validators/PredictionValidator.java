package com.fantasy.validators;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fantasy.dao.PredictionDAO;
import com.fantasy.model.Account;
import com.fantasy.model.Prediction;

@Component
public class PredictionValidator implements Validator {
	
	@Autowired
	PredictionDAO dao;

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Prediction prediction = (Prediction) target;
	
		if (!Pattern.matches("^[0-9]{1,2}[-][0-9]{1,2}$", prediction.getPrediction())) {
			errors.reject("Score not in correct format 'nn-nn'");
		}
	}
	
	public PredictionDAO getDao() {
		return dao;
	}
	
	public void setDao(PredictionDAO dao) {
		this.dao = dao;
	}
	
}
