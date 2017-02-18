package com.fantasy.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantasy.model.Prediction;
import com.fantasy.utils.HibernateSessionFactory;


public class PredictionDAO {
	
	private HibernateSessionFactory sessionFactory;
	
	public List<Prediction> getAllPredictions () {
		Session session = sessionFactory.getSession ();
		
	    Query q = session.createQuery("from Prediction");
		List<?> p = q.getResultList();
		session.close();
		
		return ((List<Prediction>) p);
	}
	
	public HibernateSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(HibernateSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
