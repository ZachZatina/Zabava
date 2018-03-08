package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.model.QuestDTO;
import com.gc.model.TaskDTO;
import com.gc.utils.GoogleMapsAPICred;
import com.gc.utils.HibernateUtil;

@Controller
public class QuestController {
	
	public static ArrayList<TaskDTO> generateQuestList(int questId) {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session sess = sessFact.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(TaskDTO.class);
		crit.add(Restrictions.eq("questID", questId));
		// restrict to tasks associated with the questID
		
		ArrayList<TaskDTO> taskList = (ArrayList<TaskDTO>) crit.list();
		tx.commit();
		sess.close();
		return taskList;
	}	
	
	@RequestMapping("quest")
	public ModelAndView map(@RequestParam("code") String code, Model model) {

		model.addAttribute("code", code); // to display
		
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session sess = sessFact.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(QuestDTO.class);
		crit.add(Restrictions.eq("questCode", code));
		// use code to retrieve Quest
		ArrayList<QuestDTO> questList = (ArrayList<QuestDTO>) crit.list();
		tx.commit();
		sess.close();
		
		int questId = questList.get(0).getQuestId();
		model.addAttribute("questId", questId); // to display
		
		ArrayList<TaskDTO> taskList = QuestController.generateQuestList(questId);
		
		System.out.println(taskList.size());
		
		ArrayList<String> latList = new ArrayList<String>();
		ArrayList<String> longList = new ArrayList<String>();
		
		for(int i = 0; i < taskList.size(); i++) {
			latList.add(taskList.get(i).getLat());
			longList.add(taskList.get(i).getLon());
		}
		
		String mapCode = "<script>\n" + 
				"\n" + 
				"      function initMap() {\n" + 
				"\n";
				for(int i = 0; i < latList.size(); i++ ) {
					mapCode += "        var set" + String.valueOf(i) + " = {lat: " + latList.get(i) + ", lng: " + longList.get(i) + "};\n";
				}
				
		String mapCenter = "{lat: 42.33645874, lng: -83.04835879}";
		
		String mapScript = "https://maps.googleapis.com/maps/api/js?key=" + GoogleMapsAPICred.MAPS_API_KEY + "&callback=initMap";
	
				model.addAttribute("tList", taskList);
				model.addAttribute("mScript", mapScript);
		
		return new ModelAndView("quest", "mapIn", mapCenter);
	}
	
	
	@RequestMapping("/completequest")
	public ModelAndView completeQuest(@RequestParam("input") String input, @RequestParam("questId") int questId, Model model) {
		ArrayList<TaskDTO> taskList = QuestController.generateQuestList(questId);
		System.out.println(input);

		String[] inputAnswers = input.split(",");
		String[] adminAnswers = new String[taskList.size()];
		for(int i = 0; i < taskList.size(); i++) {
			adminAnswers[i] = taskList.get(i).getTaskAnswer();
		}
		model.addAttribute("uAnswers", inputAnswers);
		return new ModelAndView("completequest", "aAnswers", adminAnswers);
	}

}
