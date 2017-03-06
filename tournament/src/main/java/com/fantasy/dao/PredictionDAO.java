package com.fantasy.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantasy.model.Account;
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
	
	public boolean updatePrediction(Prediction prediction) {
		Session session = sessionFactory.getSession ();
		Transaction tx = session.beginTransaction();
		
		Prediction find = new Prediction(prediction.getId(), prediction.getGameid());
		Prediction p = session.load(Prediction.class, find);
		String oldValue = p.getPrediction();
		p.setPrediction(prediction.getPrediction());
		tx.commit();
		
		System.out.println("updatePrediction: prediction updated for user " + p.getId() + " game " + p.getGameid() + 
				" from " + oldValue + " to " + prediction.getPrediction());
		
		return true;
	}
	
	public HibernateSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(HibernateSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
