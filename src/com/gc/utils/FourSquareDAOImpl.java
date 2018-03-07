package com.gc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
import com.gc.model.foursquareobjs.FourSquare;
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

	public FourSquare getFS(String lat, String lon, int distance) throws IOException {

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
				+ section + "&radius=" + radius + "&v=" + VERSION;

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

}
