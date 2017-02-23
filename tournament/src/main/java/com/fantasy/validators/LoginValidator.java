package com.fantasy.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fantasy.dao.AccountDAO;
import com.fantasy.model.Account;
import com.fantasy.model.Login;

@Component
public class LoginValidator implements Validator {
	
	@Autowired
	AccountDAO dao;

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Login login = (Login) target;
		
		if (!dao.doesAccountExistHb((Account) new Account(login.getUsername()))) {
			errors.rejectValue("username", "n/a", "Have you registered ?");
		}

	}
	
	public AccountDAO getDao() {
		return dao;
	}
	
	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}
	
}
