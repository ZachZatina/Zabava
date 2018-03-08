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
import com.gc.model.QuestDTO;
import com.gc.model.TaskDTO;
import com.gc.utils.FourSquareDAOImpl;
import com.gc.utils.GoogleMapsAPICred;

@Controller
public class QuestBuilderController {

	@RequestMapping("enter")
	public ModelAndView getAddress(Model model) {

		return new ModelAndView("enter", "message", "hello");
	}

	@RequestMapping("admin")
	public ModelAndView admin(@RequestParam("streetaddress") String streetAddress, @RequestParam("city") String city,
			@RequestParam("state") String state, Model model) {
		// presume this page will be called through submit on a login page

		String MAP_KEY = GoogleMapsAPICred.MAPS_API_KEY;
		String strAddress = formatAddress(streetAddress, city, state);
		// use formatAddress method to build the address from input, to pass to the API call

		String addressCall = "/maps/api/geocode/json?address=" + strAddress
				+ "&key=" + MAP_KEY;

		Double lat = 0.00;
		Double lng = 0.00;

		try {

			HttpClient http = HttpClientBuilder.create().build(); 
			HttpHost host = new HttpHost("maps.googleapis.com", 443, "https");
			HttpGet getPage = new HttpGet(addressCall);

			HttpResponse resp = http.execute(host, getPage);
			String jsonString = EntityUtils.toString(resp.getEntity());

			JSONObject json = new JSONObject(jsonString);
			
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
		model.addAttribute("mapkey", MAP_KEY);

		return new ModelAndView("admin", "message", "questID");
	}

	public static String formatAddress(String streetAddress, String city, String state) {

		String formatted = "";

		String formattedStreet = formatInput(streetAddress);
		String formattedCity = formatInput(city);
				
		formatted = formattedStreet + ",+" + formattedCity + ",+" + state;

		return formatted;

	}

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

	@RequestMapping("builder")
	public ModelAndView questBuilder(@RequestParam("lat") String lat, @RequestParam("lon") String lon,
			@RequestParam("questName") String questName, @RequestParam("radius") int radius,
			@RequestParam("limit") int limit, Model model) throws IOException {

		int questID = 0;

		if (lat.isEmpty()) {
			lat = "42.335953";
			lon = "-83.049774";
		}

		QuestDTO quest = new QuestDTO();
		quest.setLocation(lat + "," + lon);
		HibernateQuestDao dao = new HibernateQuestDao();
		questID = dao.addQuest(quest);

		ArrayList<TaskDTO> tasks = new ArrayList<TaskDTO>();
		tasks = FourSquareDAOImpl.getFSvenues(lat, lon, radius, limit);

		model.addAttribute("questName", questName);
		model.addAttribute("questID", questID);

		return new ModelAndView("builder", "tasks", tasks);
	}

}
