package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gc.model.TaskDTO;
import com.gc.utils.HibernateUtil;

public class QuestController {
	
	public ArrayList<TaskDTO> generateQuestList() {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session sess = sessFact.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(TaskDTO.class);
		ArrayList<TaskDTO> taskList = (ArrayList<TaskDTO>) crit.list();
		tx.commit();
		sess.close();
		return taskList;
	}
	
//	@RequestMapping 
//	public ModelAndView saveQuest(QuestDTO questDto) {
//		QuestDao questDao = new HibernateQuestDao(); 
//		questDao.updateQuest(questDto);
//	
//		return ModelAndView("", "", "");
//	}

}
