package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.model.TaskDTO;
import com.gc.utils.GoogleMapsAPICred;
import com.gc.utils.HibernateUtil;

@Controller
public class QuestController {
	
	public static ArrayList<TaskDTO> generateQuestList() {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session sess = sessFact.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(TaskDTO.class);
		ArrayList<TaskDTO> taskList = (ArrayList<TaskDTO>) crit.list();
		tx.commit();
		sess.close();
		return taskList;
	}
	
	@RequestMapping("quest")
	public ModelAndView map(Model model) {
		ArrayList<TaskDTO> taskList = QuestController.generateQuestList();

		String mapCenter = "{lat: 42.33645874, lng: -83.04835879}";
		
		String mapScript = "https://maps.googleapis.com/maps/api/js?key=" + GoogleMapsAPICred.MAPS_API_KEY + "&callback=initMap";
	
				model.addAttribute("tList", taskList);
				model.addAttribute("mScript", mapScript);
		
		return new ModelAndView("quest", "mapIn", mapCenter);
	}
	@RequestMapping("/completequest")
	public ModelAndView completeQuest(@RequestParam("input") String input, Model model) {
		ArrayList<TaskDTO> taskList = QuestController.generateQuestList();
		String[] inputAnswers = input.split(",");
		String[] adminAnswers = new String[taskList.size()];
		for(int i = 0; i < taskList.size(); i++) {
			adminAnswers[i] = taskList.get(i).getTaskAnswer();
		}
		model.addAttribute("uAnswers", inputAnswers);
		return new ModelAndView("completequest", "aAnswers", adminAnswers);
	}

}
