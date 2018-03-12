package com.gc.controller;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.gc.controller.dao.HibernateQuestDao;
import com.gc.controller.dao.TaskDAOImpl;
import com.gc.model.QuestDTO;
import com.gc.model.TaskDTO;
import com.gc.utils.FourSquareDAOImpl;
import com.gc.utils.GoogleMapsAPICred;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential.AccessMethod;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

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
	public ModelAndView getAddress(Model model) {
		boolean addressValid = true;
		
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
			@RequestParam("state") String state, Model model) {

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
			System.out.println("Exception e");
//			addressValid = false;
//			model.addAttribute("valid", addressValid);
//			return new ModelAndView("enter", "failmssg", "Invalid address. Please try again!");
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException");
//			addressValid = false;
//			model.addAttribute("valid", addressValid);
//			return new ModelAndView("enter", "failmssg", "Invalid address. Please try again!");
			
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
	 * @return ModelAndView
	 * @throws IOException
	 * Take input, make call to Foursquare to return json results
	 * Creates Quest object and Task objects and writes to database
	 */
	@RequestMapping("builder")
	public ModelAndView questBuilder(@RequestParam("lat") String lat, @RequestParam("lon") String lon,
			@RequestParam("questName") String questName, @RequestParam("radius") int radius,
			@RequestParam("limit") int limit, Model model) throws IOException {

		int questID = 0;
		int taskID = 0;
		ArrayList<TaskDTO> tasks = new ArrayList<TaskDTO>();

		// in case our GeoCode isn't working
		if (lat.isEmpty()) {
			lat = "42.335953";
			lon = "-83.049774";
		}

		/*
		 * Build a QuestDTO object and put it in the DB, retrieving the QuestID
		 */
		QuestDTO quest = new QuestDTO();
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

	@RequestMapping("tokensignin") 
	public ModelAndView tokenSignin(String token) {
		System.out.println(token);
		
		
		
		return new ModelAndView("adminlogin","message",token);
	}
	
}