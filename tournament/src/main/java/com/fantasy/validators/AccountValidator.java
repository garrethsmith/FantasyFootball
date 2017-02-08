package com.fantasy.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fantasy.model.AccountDAO;

@Component
public class AccountValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return AccountDAO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		AccountDAO account = (AccountDAO) target;
		
		// Test the validator works
		String firstname = account.getFirstname();
		if (firstname != null && firstname.equals("Garreth")) {
			errors.rejectValue("firstname", "n/a", "Garreth you are not allowed");
		}
	}
	
}
