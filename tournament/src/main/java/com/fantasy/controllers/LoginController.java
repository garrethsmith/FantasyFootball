package com.fantasy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fantasy.dao.AccountDAO;
import com.fantasy.model.Login;
import com.fantasy.validators.LoginValidator;

@Controller
@SessionAttributes(value="user")
public class LoginController {
	
	@Autowired
	LoginValidator loginValidator;
	
	@Autowired
	AccountDAO accountDao;
	
	// http://localhost:8080/tournament/login.html
	@RequestMapping(value="/login")
	public String showLogin (@Valid @ModelAttribute ("login") Login login,
			BindingResult result, Model model) {
											
		return "login";
	}
	
	@RequestMapping(value="/displayFixtures", method=RequestMethod.POST)
	public String doLogin (@Valid @ModelAttribute ("login") Login login, 
			BindingResult result, Model model) {
				
		loginValidator.validate(login, result);
		
		if (result.hasErrors())
			return "login";
		
		model.addAttribute("user", accountDao.getAccountByEmailHb(login.getUsername()));
		
		return "redirect:displayPredictions.html";
	}

	public void setLoginValidator(LoginValidator loginValidator) {
		this.loginValidator = loginValidator;
	}

	public void setAccount(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}
	
}
