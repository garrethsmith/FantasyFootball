package com.fantasy.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fantasy.dao.AccountDAO;
import com.fantasy.model.Account;

@Component
public class AccountValidator implements Validator {
	
	@Autowired
	AccountDAO dao;

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Account account = (Account) target;
	
		if (dao.doesAccountExistHb(account)) {
			errors.rejectValue("email", "n/a", "Email address already registered");
		}
	}
	
	public AccountDAO getDao() {
		return dao;
	}
	
	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}
	
}
