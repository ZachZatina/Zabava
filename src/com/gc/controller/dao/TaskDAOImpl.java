package com.gc.controller.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gc.model.QuestDTO;
import com.gc.model.TaskDTO;
import com.gc.utils.HibernateUtil;
import com.gc.utils.FourSquareDAOImpl;
import com.gc.utils.TaskDAO;

public class TaskDAOImpl implements TaskDAO {
	
	private static SessionFactory factory;

	/**
	 * 
	 */
	public TaskDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<TaskDTO> getAllTasks() {
		return null;
	}

	@Override
	public TaskDTO getTask(int taskID) {
		Session session = factory.openSession();
		TaskDTO task = (TaskDTO)session.get(TaskDTO.class, taskID);
//		session.close();
		return task;
	}

	@Override
	public void saveTask(TaskDTO task) {
	}

	@Override
	public void updateTask(TaskDTO task) {
		System.out.println(task.getLocationName());
//		try {
//	         factory = new Configuration().configure().buildSessionFactory();
//	      } catch (Throwable ex) { 
//	         System.err.println("Failed to create sessionFactory object." + ex);
//	         throw new ExceptionInInitializerError(ex); 
//	      }
		
		Session session = factory.openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
			 session.update(task); 
	         tx.commit();
	         
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
//	         session.close(); 
	      }	
	}
	
	public int addTask(TaskDTO task) {
		
		FourSquareDAOImpl dao = new FourSquareDAOImpl();
		String photoURL = null;
		try {
			photoURL = dao.getFSImage(task.getLocationID());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("PhotoURL: " + photoURL);
		task.setTaskPhotoURL(photoURL);
		
//		try {
//	         factory = new Configuration().configure().buildSessionFactory();
//	      } catch (Throwable ex) { 
//	         System.err.println("Failed to create sessionFactory object." + ex);
//	         throw new ExceptionInInitializerError(ex); 
//	      }
//		
		Session session = factory.openSession();
	      Transaction tx = null;
	      int taskID = 0;
	      
	      try {
	         tx = session.beginTransaction();
	        taskID = (Integer) session.save(task); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
//	         session.close(); 
	      }
	      return taskID;
		
	}
	

	@Override
	public void deleteTask(TaskDTO task) {
		
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(task);
		tx.commit();
//		session.close();
		
		return;	
		
	}
	
	

}
