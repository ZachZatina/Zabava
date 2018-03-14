package com.gc.controller.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.gc.model.CreatorDTO;
import com.gc.utils.CreatorDAO;
import com.gc.utils.JDBCUtil;

public class CreatorDAOImpl implements CreatorDAO {
	
	private SessionFactory factory;

	@Override
	public List<CreatorDTO> getAllCreators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreatorDTO getCreator(int creatorID) {
		Session session = factory.openSession();
		CreatorDTO creator = (CreatorDTO)session.get(CreatorDTO.class, creatorID);
		session.close();
		return creator;
	}
	
	public CreatorDTO getCreatorByEmail(String email) throws ClassNotFoundException, SQLException {
		
		int creatorID;
		System.out.println(email + " CreatorDAOImpl.getCreatorByEmail");
		try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		Session session = factory.openSession();
		System.out.println("Session Opened. Just before Get Creator");
		CreatorDTO creator = new CreatorDTO();
		
		Criteria cr = session.createCriteria(CreatorDTO.class);
		cr.add(Restrictions.eq("email", email));
		@SuppressWarnings("unchecked")
		ArrayList<CreatorDTO> results = (ArrayList<CreatorDTO>) cr.list();
		int found = results.size();
		System.out.println("Creators Found: " + found);
		if (found == 1) {
		creator = results.get(0);
		}
		else {
		//creator.setEmail(email);
		System.out.println("About to save new Creator");
		//creatorID = (Integer) session.save(creator);
		creatorID = JDBCUtil.addCreatorJDBC(email);
		System.out.println("New Creator Saved");
		creator.setCreatorID(creatorID);
		creator.setEmail(email);
		results = (ArrayList<CreatorDTO>) cr.list();
		found = results.size();
		System.out.println("Creators Found: " + found);
		}
		
		session.close();
		System.out.println("Email Search Complete: " + email);
		return creator;
	}

	@Override
	public void updateCreator(CreatorDTO creator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCreator(CreatorDTO creator) {
		// TODO Auto-generated method stub
		
	}
	
public int addCreator(String email) {
		CreatorDTO creator = new CreatorDTO();
		creator.setEmail(email);
			
		try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		Session session = factory.openSession();
	      Transaction tx = null;
	      Integer creatorID = 0;
	      
	      try {
	         tx = session.beginTransaction();
	        creatorID = (Integer) session.save(creator); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return creatorID;
		
	}


}
