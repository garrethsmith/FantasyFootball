package com.fantasy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.persistence.Query;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.fantasy.model.Account;
import com.fantasy.utils.HibernateSessionFactory;


public class AccountDAO {
	
	private HibernateSessionFactory sessionFactory;
	
	public List<Account> getAllAccounts (){
		Session session = sessionFactory.getSession();
		
		Query q = session.createQuery("from Account");
		List<?> f= q.getResultList();
		
		return (List<Account>) f;
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
	
	private Account getAccountByEmailHb (String email) {	
		Session session = sessionFactory.getSession ();
	    //Account account = (Account) session.get(Account.class, email); 
	    //session.close(); 
		
	    Criteria critera = session.createCriteria(Account.class).add(Restrictions.eq("email", email));
	    Object obj = critera.uniqueResult();
	    session.close(); 
	    
	    if(obj == null) return new Account();
	    else return ((Account)obj);
	}
	
	public Account getAccountById (int id) {	
		Session session = sessionFactory.getSession ();
		
	    Criteria critera = session.createCriteria(Account.class).add(Restrictions.eq("id", id));
	    Object obj = critera.uniqueResult();
	    session.close(); 
	    
	    if(obj == null) return new Account();
	    else return ((Account)obj);
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
