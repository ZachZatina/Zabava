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

	public FourSquare getFS() throws IOException {
		String CLIENT_ID = FourSquareAPICred.CLIENT_ID;
		String CLIENT_SECRET = FourSquareAPICred.CLIENT_SECRET;
		String ll = "42.3359321,-83.04993389999998";
		String section = "topPicks";
		String radius = "1000";
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
		//System.out.println(con);

		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String json = reader.readLine();
		Gson gson = new Gson();

		FourSquare fsObj = gson.fromJson(json, FourSquare.class);

		return fsObj;
	}

}
