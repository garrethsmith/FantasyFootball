package com.fantasy.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fantasy.dao.AccountDAO;
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
	
		// TODO: Prediction validation
		//if (dao.doesAccountExistHb(account)) {
			//errors.rejectValue("email", "n/a", "Email address already registered");
		//}
	}
	
	public PredictionDAO getDao() {
		return dao;
	}
	
	public void setDao(PredictionDAO dao) {
		this.dao = dao;
	}
	
}
