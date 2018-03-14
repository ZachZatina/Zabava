package com.gc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.controller.dao.CreatorDAOImpl;
import com.gc.controller.dao.HibernateQuestDao;
import com.gc.controller.dao.TaskDAOImpl;
import com.gc.model.CreatorDTO;
import com.gc.model.QuestDTO;
import com.gc.model.TaskDTO;
import com.gc.utils.FourSquareDAOImpl;
import com.gc.utils.GoogleMapsAPICred;
import com.gc.utils.HibernateUtil;

/**
 * 
 * @authors Zabava
 *
 */

@Controller
public class QuestBuilderController {

	/**
	 * 
	 * @param model
	 * @return ModelAndView
	 * Display enter
	 */
	@RequestMapping("enter")
	public ModelAndView getAddress(@RequestParam("creatorid") int creatorID, Model model) {
		boolean addressValid = true;
		model.addAttribute("creatorID", creatorID);
		
		return new ModelAndView("enter", "valid", addressValid);
	}

	/**
	 * 
	 * @param streetAddress
	 * @param city
	 * @param state
	 * @param model
	 * @return ModelAndView
	 * Validate address input
	 * Retrieve lat and lon
	 * Routes lat, lon, and MAP_KEY to admin page
	 */
	@RequestMapping("admin")
	public ModelAndView admin(@RequestParam("streetaddress") String streetAddress, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("creatorid") int creatorID, Model model) {

		model.addAttribute("creatorID", creatorID);
		boolean addressValid = true;
		
		String MAP_KEY = GoogleMapsAPICred.MAPS_API_KEY;
		String strAddress = formatAddress(streetAddress, city, state);
		// use formatAddress method to build the address from input, to pass to the API
		// call

		String addressCall = "/maps/api/geocode/json?address=" + strAddress + "&key=" + MAP_KEY;

		Double lat = 0.00;
		Double lng = 0.00;

		try {

			HttpClient http = HttpClientBuilder.create().build();
			HttpHost host = new HttpHost("maps.googleapis.com", 443, "https");
			HttpGet getPage = new HttpGet(addressCall);

			HttpResponse resp = http.execute(host, getPage);
			String jsonString = EntityUtils.toString(resp.getEntity());

			JSONObject json = new JSONObject(jsonString);

		if (json.getJSONArray("results").length() == 0) {
			addressValid = false;
			model.addAttribute("valid", addressValid);
			return new ModelAndView("enter", "failmssg", "Invalid address. Please try again!");
		}
			
		// retrieve latitude and longitude, to build the map
			lat = json.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location")
					.getDouble("lat");
			lng = json.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location")
					.getDouble("lng");

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("lat", lat);
		model.addAttribute("lng", lng);

		return new ModelAndView("admin", "mapkey", MAP_KEY);
	}

	/**
	 * 
	 * @param streetAddress
	 * @param city
	 * @param state
	 * @return String
	 * Formats address for API call
	 */
	public static String formatAddress(String streetAddress, String city, String state) {

		String formatted = "";

		String formattedStreet = formatInput(streetAddress);
		String formattedCity = formatInput(city);

		formatted = formattedStreet + ",+" + formattedCity + ",+" + state;

		return formatted;

	}
	
	/**
	 * 
	 * @param input
	 * @return String
	 * Formats input for address 
	 */
	public static String formatInput(String input) {
		String result = "";
		input = input.trim();
		String[] components = input.split(" ");

		for (int i = 0; i < components.length; i++) {
			result += components[i];
			if (i != (components.length - 1)) {
				result += "+";
			}
		}
		return result;
	}


	/**
	 * 
	 * @param lat
	 * @param lon
	 * @param questName
	 * @param radius
	 * @param limit
	 * @param model
	 * @param creatorid
	 * @return ModelAndView
	 * @throws IOException
	 * Take input, make call to Foursquare to return json results
	 * Creates Quest object and Task objects and writes to database
	 */
	@RequestMapping("builder")
	public ModelAndView questBuilder(@RequestParam("lat") String lat, @RequestParam("lon") String lon,
			@RequestParam("questName") String questName, @RequestParam("radius") int radius,
			@RequestParam("limit") int limit, @RequestParam("creatorid") int creatorID, Model model) throws IOException {

		int questID = 0;
		int taskID = 0;
		ArrayList<TaskDTO> tasks = new ArrayList<TaskDTO>();

		// in case our GeoCode isn't working
		if (lat.isEmpty()) {
			lat = "42.335953";
			lon = "-83.049774";
		}
System.out.println("Builder -> CreatorID: " + creatorID);
		/*
		 * Build a QuestDTO object and put it in the DB, retrieving the QuestID
		 */
		QuestDTO quest = new QuestDTO();
		quest.setCreatorId((Integer) creatorID);
		//quest.setCreatorId(creatorID);
		quest.setQuestName(questName);
		quest.setLocation(lat + "," + lon);
		quest.setLocationId("");
		quest.setQuestCode(HibernateQuestDao.getQuestCode());
		HibernateQuestDao questDao = new HibernateQuestDao();
		questID = questDao.addQuest(quest);
		if (questID == 0) {
			System.out.println("Add Quest Failed");
		} else {

			tasks = FourSquareDAOImpl.getFSvenues(lat, lon, radius, limit);

			/*
			 * Add Quest Name and ID to model to use them in the builder page
			 */
			model.addAttribute("questName", questName);
			model.addAttribute("questID", questID);
			
			/*
			 * Create tasks for each point we're given by the FourSquare query
			 */
			for (int i = 0; i < tasks.size(); i++) {
				tasks.get(i).setQuestID(questID);
				TaskDAOImpl taskDao = new TaskDAOImpl();
				taskID = taskDao.addTask(tasks.get(i));
				tasks.get(i).setTaskID(taskID);
			}
		}
		return new ModelAndView("builder", "tasks", tasks);
	}
	
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
	/**
	 * 
	 * @param taskAndQuest
	 * @param model
	 * @return
	 */
	@RequestMapping("delete")
	public ModelAndView selectTasks(@RequestParam("taskandquest") String taskAndQuest,  Model model) {
		
		/*
		 * takes the string containing taskID and QuestID, parses and converts to int
		 */
		String parts[] = taskAndQuest.split(",");
		System.out.println(parts.length);
		String taskIDstr = parts[0];
		String questIDstr = parts[1];
		int taskID = Integer.parseInt(taskIDstr);
		int questID = Integer.parseInt(questIDstr);
		
		/*
		 * delete task for taskID
		 */
		
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTaskID(taskID);
		
		TaskDAOImpl taskDAO = new TaskDAOImpl();
		taskDAO.deleteTask(taskDTO);
		
		/*
		 * 	retrieve tasks with questID
		 */
	
		// FIXME: refactor
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria crit = session.createCriteria(TaskDTO.class);
		crit.add(Restrictions.eq("questID", questID));
		ArrayList<TaskDTO> taskList = (ArrayList<TaskDTO>) crit.list();
		tx.commit(); 
//		session.close();
				
		model.addAttribute("questID", questID);
		model.addAttribute("taskID", taskID);
				
		return new ModelAndView("builder", "tasks", taskList);
	}

	/**
	 * 
	 * @param taskIDs
	 * @param taskNames
	 * @param answers
	 * @return ModelAndView
	 * 
	 */
	@RequestMapping("showquest")
	public ModelAndView showQuest(@RequestParam("taskID") String[] taskIDs, @RequestParam("taskdesc") String[] taskNames,
			@RequestParam("taskanswer") String[] answers) {

		ArrayList<TaskDTO> tasks = new ArrayList<TaskDTO>();
		TaskDAOImpl dao = new TaskDAOImpl();

		String[] arrIDs = taskIDs;
		String[] arrNames = taskNames;
		String[] arrAnswers = answers;

		for (int i = 0; i < arrIDs.length; i++) {
			int ind = Integer.parseInt(arrIDs[i]);
			TaskDTO task = dao.getTask(ind);
			task.setTaskDesc(arrNames[i]);
			task.setTaskAnswer(arrAnswers[i]);

			dao.updateTask(task);
			tasks.add(task);

		}

		return new ModelAndView("showquest", "tasks", tasks);
	}
	
	@RequestMapping("adminlogin")
	public ModelAndView login() {
		
		return new ModelAndView("adminlogin","model","");
	}
	
	/**
	 * 
	 * @param creatorString ID String from Google Token (email address)
	 * @return Creator page with Array Table of created Quests and Creator ID
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@RequestMapping("creator")
	public ModelAndView loadCreatorPage(@RequestParam("creatorstring") String creatorString, Model model) throws ClassNotFoundException, SQLException {
		
		System.out.println(creatorString + " QuestBuilder.loadCreatorPage");
		//Take email string and look up creatorID
		CreatorDAOImpl daoCreator = new CreatorDAOImpl();
		CreatorDTO creator = daoCreator.getCreatorByEmail(creatorString);
		int creatorID = creator.getCreatorID();
		System.out.println(creatorID);
		// Pass creatorid to next page
		model.addAttribute("creatorID", creatorID);
		
		HibernateQuestDao daoQuest = new HibernateQuestDao();
		ArrayList<QuestDTO> quests = new ArrayList<QuestDTO>();
		quests = daoQuest.getQuestsByCreator(creatorID);		
		
		return new ModelAndView("creator","quests",quests);
		
	}
	
}