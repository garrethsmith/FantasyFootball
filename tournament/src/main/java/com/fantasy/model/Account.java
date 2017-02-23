package com.fantasy.model;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;

public class Account {
	
	private int id;

	//TODO: Pull all annotated validation and put into AccountValidator
	
	@Size (min=3, max=15)
	private String firstname;
	
	@Size (min=3, max=15)
	private String surname;
	
	@Size (min=3, max=20)
	private String teamname;
	
	@Size (min=3, max=50) @Email
	private String email;
	
	public Account () {}
	
	public Account (String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname.trim();
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname.trim();
	}
	
	public String getTeamname() {
		return teamname;
	}
	
	public void setTeamname(String teamname) {
		this.teamname = teamname.trim();
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email.trim();
	}
		
}
