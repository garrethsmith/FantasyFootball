package com.fantasy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fantasy.model.AccountDAO;
import com.fantasy.validators.AccountValidator;

@Controller
public class NewAccountController {
		
	@Autowired(required=true) @Qualifier(value="accountValidator")
	AccountValidator accountValidator;
	// http://localhost:8080/tournament/createaccount.html
	@RequestMapping(value="/createaccount")
	public String createAccount (@Valid @ModelAttribute ("account") AccountDAO account,
			BindingResult result) {
			
		accountValidator.validate(account, result);
				
		return "createaccount";
	}

	public AccountValidator getAccountValidator() {
		return accountValidator;
	}

	public void setAccountValidator(AccountValidator accountValidator) {
		this.accountValidator = accountValidator;
	}
	
}
