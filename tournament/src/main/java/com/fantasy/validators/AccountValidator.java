package com.fantasy.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fantasy.model.Account;

@Component
public class AccountValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Account account = (Account) target;
		
		// Test the validator works
		String firstname = account.getFirstname();
		if (firstname != null && firstname.equals("Garreth")) {
			errors.rejectValue("firstname", "n/a", "Garreth you are not allowed");
		}
	}
	
}
