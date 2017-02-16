package com.fantasy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantasy.dao.AccountDAO;
import com.fantasy.model.Account;
import com.fantasy.utils.KeyGenerator;
import com.fantasy.validators.AccountValidator;

@Controller
public class NewAccountController {
	
	@Autowired
	AccountDAO dao;
		
	@Autowired(required=true) @Qualifier(value="accountValidator")
	AccountValidator accountValidator;
	
	@Autowired
	KeyGenerator generator;
	
	// http://localhost:8080/tournament/createaccount.html
	@RequestMapping(value="/createaccount")
	public String createAccount (@Valid @ModelAttribute ("account") Account account,
			BindingResult result, Model model) {
									
		return "createaccount";
	}
	
	@RequestMapping(value="/accountcreated", method=RequestMethod.POST)
	public String accountCreated (@Valid @ModelAttribute ("account") Account account, 
			BindingResult result, Model model) {
		
		accountValidator.validate(account, result);
		
		if (result.hasErrors())
			return "createaccount";
		
		account.setId(generator.generateAccountId());
		dao.createAccountHb (account);
			
		return "accountcreated";
	}

	public AccountValidator getAccountValidator() {
		return accountValidator;
	}

	public void setAccountValidator(AccountValidator accountValidator) {
		this.accountValidator = accountValidator;
	}

	public AccountDAO getDao() {
		return dao;
	}

	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}

	public KeyGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(KeyGenerator generator) {
		this.generator = generator;
	}
	
}
