package com.fantasy.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fantasy.dao.AccountDAO;
import com.fantasy.model.Account;

public class KeyGenerator {
	
	private AccountDAO accountDao;
	private int key;
	
	public void init () throws Exception {
		List<Account> accounts = accountDao.getAllAccounts();
		
		for (Account a: accounts) {
			if (a.getId() > getKey()) {
				setKey(a.getId());
			}
		}
	}
	
	public int generateAccountId () {
		setKey(key+10);
		return getKey();
	}

	public AccountDAO getAccountDao() {
		return accountDao;
	}

	@Autowired
	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
