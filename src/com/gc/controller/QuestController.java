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

/**
 * 
 * @author Andrew Calabro-Cavin, Ben Fogt, Zach Zatina, Alex Brozovich
 *
 */

@Controller
public class QuestController {
	
/**
 * 
 * @param questId
 * @return ArrayList taskList list of tasks
 */
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
	
//	@RequestMapping("/")
//	public String index(Model model) {	
//		boolean codeValid = true;
//		model.addAttribute("valid", codeValid);
//		
//		return "index";
//	}
	
	/**
	 * 
	 * @param code
	 * @param model
	 * @return ModelAndView 
	 * validate questCode
	 * create taskList, pass to quest page
	 * get map center point, pass to map on quest page
	 */
	@RequestMapping("quest")
	public ModelAndView map(@RequestParam("code") String code, Model model) {

		boolean codeValid = true;
		code = code.toUpperCase();
		model.addAttribute("code", code); // to display
		
		
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session sess = sessFact.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(QuestDTO.class);
		crit.add(Restrictions.eq("questCode", code));
		// use code to retrieve Quest
		ArrayList<QuestDTO> questList = (ArrayList<QuestDTO>) crit.list();
		
		if (questList.size() == 0) {
			codeValid = false;
			model.addAttribute("valid", codeValid);
			tx.commit();
//			sess.close();
			return new ModelAndView("index", "failmssg", "That code is not valid. Please try again!");
		}
		
		tx.commit();
//		sess.close();
		
		int questId = questList.get(0).getQuestId();
		model.addAttribute("questId", questId); // to display
		
		ArrayList<TaskDTO> taskList = QuestController.generateQuestList(questId);
		
		String questLoc = questList.get(0).getLocation();
		String[] qLocation = questLoc.split(",");
				
		String mapCenter = "{lat: " + qLocation[0].toString() + ", lng: " + qLocation[1].toString() + "}";
		
		String mapScript = "https://maps.googleapis.com/maps/api/js?key=" + GoogleMapsAPICred.MAPS_API_KEY + "&callback=initMap";
		
				model.addAttribute("tList", taskList);
				model.addAttribute("mScript", mapScript);
		
		return new ModelAndView("quest", "mapIn", mapCenter);
	}
	
	/**
	 * 
	 * @param input
	 * @param questId
	 * @param model
	 * @return ModelAndView
	 * Takes in user responses, puts into String Array
	 * Sends this and adminAnswers to completequest page
	 */
	@RequestMapping("/completequest")
	public ModelAndView completeQuest(@RequestParam("input") String[] input, @RequestParam("questId") int questId, Model model) {
		ArrayList<TaskDTO> taskList = QuestController.generateQuestList(questId);
		System.out.println(input);

		String[] inputAnswers = input;
		String[] adminAnswers = new String[taskList.size()];
		for(int i = 0; i < taskList.size(); i++) {
			adminAnswers[i] = taskList.get(i).getTaskAnswer();
		}
		model.addAttribute("uAnswers", inputAnswers);
		return new ModelAndView("completequest", "aAnswers", adminAnswers);
	}

}
