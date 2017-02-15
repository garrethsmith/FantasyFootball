package com.fantasy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.fantasy.model.Account;
import com.fantasy.utils.HibernateSessionFactory;


public class AccountDAO {
	
	HibernateSessionFactory sessionFactory;
	
	private Account getAccountByEmailHb (String email) {	
		Session session = sessionFactory.getSession ();
	    Account account = (Account) session.get(Account.class, email); 
	    session.close(); 
		
	    if(account == null) return new Account();
	    else return account;
	}
		
	public boolean doesAccountExistHb (Account account) {
		Account a = getAccountByEmailHb (account.getEmail());
		
		if (a.getEmail()!= null && a.getEmail().equals(account.getEmail()))
			return true;
		else 
			return false;
	}
	
	public void createAccountHb (Account account) {
		Session session = sessionFactory.getSession ();
	    Transaction tx = null;
	      
	    try{
		    tx = session.beginTransaction();
		    session.save(account); 
		    tx.commit();
	    } catch (HibernateException e) {
		    if (tx!=null) tx.rollback();
		    e.printStackTrace(); 
	    } finally {
	    	session.close(); 
	    }
	    
	    return;
	}
	
	//////////////////////////////////////////////////////
	// Below is access to DB via JDBC direct connection //
	///////////////////// RUBBISH :) /////////////////////

	JdbcTemplate jdbcTemplate;
	
	@Deprecated
	private class AccountRowMapper implements RowMapper<Object> {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account account = new Account ();
			account.setFirstname(rs.getString("firstname"));
			account.setSurname(rs.getString("surname"));
			account.setTeamname(rs.getString("teamname"));
			account.setEmail(rs.getString("email"));
			return account;
		}
	}
	
	@Deprecated
	public void createAccountSql (Account account) {
		String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
		
		Object[] params = new Object[] { account.getFirstname(), account.getSurname(), 
				account.getTeamname(), account.getEmail()};
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		int row = jdbcTemplate.update(sql, params, types);
		
		if (row != 1) 
			System.out.println("AccountDAO: Error in updating new account, row number incorrect");
	}
	
	@Deprecated
	public Account getAccountByEmailSql (String email) {		
		String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
		Account retrivedAccount= new Account();

		try {
			retrivedAccount = (Account) jdbcTemplate.queryForObject(sql, new Object[] { email }, new AccountRowMapper ());
		} catch (EmptyResultDataAccessException e) {}
		
		return retrivedAccount;
	}
	
	@Deprecated
	public boolean doesAccountExistSql (Account account) {
		Account a = getAccountByEmailSql(account.getEmail());
		
		if (a.getEmail()!= null && a.getEmail().equals(account.getEmail()))
			return true;
		else 
			return false;
	}
	
	@Autowired
	public void setDatasource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Autowired
	public void setSessionFactory(HibernateSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
