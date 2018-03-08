package com.gc.controller.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gc.model.QuestDTO;
import com.gc.utils.QuestDao;

public class HibernateQuestDao implements QuestDao {
	
	private static SessionFactory factory;

	@Override
	public List<QuestDTO> getAllQuests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestDTO getQuest(int questId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateQuest(QuestDTO quest) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteQuest(QuestDTO quest) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveQuest(QuestDTO quest) {
		// TODO Auto-generated method stub
		
	}
	
	public int addQuest(QuestDTO quest) {
System.out.println("Welcome to the HibernateQuestDAO");

		try {
			factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		System.out.println("QuestDAO: Step 0");
		Session session = factory.openSession();
		Transaction tx = null;
	      int questID = 0;
	      
	      try {
	         tx = session.beginTransaction();
	         questID = (Integer) session.save(quest); // Captures the AutoIncremented QuestID
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return questID;
		
	}

}
