package com.fantasy.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantasy.model.Fixture;
import com.fantasy.utils.HibernateSessionFactory;

public class FixtureDAO {
	
	HibernateSessionFactory sessionFactory;
	
	public void loadFixtures (List<Fixture> fixtureList) {
		System.out.println("Loading fixtures not in DB");
		for (Fixture f: fixtureList) {
			System.out.println("Entering id " + f.getId());
		}
		
		Session session = sessionFactory.getSession ();
	    Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			for (Fixture f: fixtureList)
				session.save(f); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	public List<Fixture> getAllFixtures () {
		Session session = sessionFactory.getSession();
				
		Query q = session.createQuery("from Fixture");
		List<?> f= q.getResultList();
		
		return (List<Fixture>) f;
	}

	public HibernateSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(HibernateSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
