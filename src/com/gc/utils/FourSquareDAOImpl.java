package com.gc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

import com.gc.model.TaskDTO;
import com.gc.model.foursquareobjs.FourSquare;
import com.gc.model.foursquareobjs.Group;
import com.gc.model.foursquareobjs.Item;
import com.gc.model.foursquareobjs.Venue;
import com.google.gson.Gson;

/* 
 * This class opens a connection to the FourSquare API and 
 * retrieves a list of venues as a FourSquare Object. 
 * The classes for the JSON import (via GSON) are in 
 * com.gc.model.foursquareobjs
 */
/**
 * @author Ben Fogt
 *
 */

public class FourSquareDAOImpl {

	public ArrayList<Venue> venueList;

	/*
	 * Method to get data from FourSquare with list of 50 closest places to a fixed
	 * location (ll). This returns a FourSquare Object which has layer upon layer of
	 * objects and lists, all connected to our classes in the
	 * com.gc.model.foursquareobjs package.
	 */

	public FourSquare getFS(String lat, String lon, int distance, int limit) throws IOException {

		/*
		 * Variables to make the API call. The final variables come from the
		 * FourSquareAPICred class in utils. As of now (3/5) we need build the methods
		 * that call this so that we can send the ll, section, and radius variables.
		 */

		String CLIENT_ID = FourSquareAPICred.CLIENT_ID;
		String CLIENT_SECRET = FourSquareAPICred.CLIENT_SECRET;
		String ll = lat + "," + lon;

		// Section is the type of venues to return. topPicks returns a mix of them.
		String section = "topPicks";
		// Radius is in Meters.
		int radius = distance;
		// Version is the date that we want the API to be fixed to.
		// Any API changes after this date will not effect this code.
		String VERSION = FourSquareAPICred.VERSION;

		// Build the string for the URL. addRequestProperty didn't work
		// so we're building the string using the variables from FourSquareAPICred
		// The credentials files are hidden from Git, so make sure you have a copy
		// from Slack.
		String urlParams = "?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&ll=" + ll + "&section="
				+ section + "&radius=" + radius + "&limit=" + limit + "&v=" + VERSION;

		URL url = new URL("https://api.foursquare.com/v2/venues/explore" + urlParams);

		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		// Console print to verify the URL in case of an error 400/410
		// System.out.println(con);

		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String json = reader.readLine();
		Gson gson = new Gson();

		// This is where the donuts are made. This call Deserializes the JSON response
		// from FourSquare into objects corresponding to our classes in
		// com.gc.model.foursquareobjs.
		FourSquare fsObj = gson.fromJson(json, FourSquare.class);

		return fsObj;
	}
	

	/* 
	 * Get the JSON data from FourSquare and loop through it to produce an array of
	 * TaskDTO objects with the data we need for the Task table. 
	 */
	public static ArrayList<TaskDTO> getFSvenues(String lat, String lon, int distance, int limit) throws IOException {
		
		FourSquareDAOImpl dao = new FourSquareDAOImpl();
		
		FourSquare fsObj = dao.getFS(lat, lon, distance, limit);
		ArrayList<Group> groups = (ArrayList<Group>) fsObj.getResponse().getGroups();
		ArrayList<Item> items = (ArrayList<Item>) groups.get(0).getItems();
		ArrayList<TaskDTO> locations = new ArrayList<TaskDTO>();
		for (int i=0; i<items.size();i++ ) {
			TaskDTO task = new TaskDTO();
			task.setLat(items.get(i).getVenue().location.lat.toString());
			task.setLon(items.get(i).getVenue().location.lng.toString());
			task.setLocationName(items.get(i).getVenue().name);
			task.setLocationID(items.get(i).getVenue().id);
			task.setAddress(items.get(i).getVenue().location.formattedAddress.get(0));
			task.setCsz(items.get(i).getVenue().location.formattedAddress.get(1));
			
			locations.add(task);			
		}
		return locations;
	}

}
