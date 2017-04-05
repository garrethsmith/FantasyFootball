package com.fantasy.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.resource.transaction.spi.TransactionStatus;
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
	
	public boolean doesPredictionExist (Prediction prediction) {
		Prediction p = getPrediction (prediction);
		
		if (p.getPrediction() != null) {
			System.out.println("Prediction game ID : User ID exists " + p.getGameid() + " : " + p.getId());
			return true;
		}
		else  {
			System.out.println("Prediction game ID : User ID does not exist " + p.getGameid() + " : " + p.getId());
			return false;
		}
	}
	
	private Prediction getPrediction (Prediction prediction) {	
		Session session = sessionFactory.getSession ();
		
	    Criteria critera = session.createCriteria(Prediction.class);
	    critera.add(Restrictions.eq("gameid", prediction.getGameid()));
	    critera.add(Restrictions.eq("id", prediction.getId()));
	    Object obj = critera.uniqueResult();
	    
	    session.close(); 
	    
	    if(obj == null) return new Prediction();
	    else return ((Prediction)obj);
	}
	
	public boolean updatePrediction(Prediction prediction) {
		Session session = sessionFactory.getSession ();
		Transaction tx = session.beginTransaction();
		
		Prediction find = new Prediction(prediction.getId(), prediction.getGameid());
		Prediction p = session.load(Prediction.class, find);
		String oldPred = p.getPrediction();
		p.setPrediction(prediction.getPrediction());
		
		tx.commit();
		session.close();
		
		System.out.println("updatePrediction: prediction updated for user " + p.getId() + " game " + p.getGameid() + 
				" from " + oldPred + " to " + prediction.getPrediction());
		
		return true;
	}
	
	public boolean insertPrediction (Prediction prediction) {
		Session session = sessionFactory.getSession ();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.save(prediction); 
			if (!tx.getStatus().equals(TransactionStatus.ACTIVE))
				tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace(); 
			
			return false;
		} finally {
			tx.commit();
			session.close();
		}
		
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
