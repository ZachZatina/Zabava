package com.gc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gc.utils.GoogleMapsAPICred;

/**
 * @author alexbrozovich
 *
 */

@Controller
public class HomeController {
	@RequestMapping("/")
	public ModelAndView home() {	
		
		return new ModelAndView("index", "message", "success");
	}
	
//	@RequestMapping("quest")
//	public ModelAndView quest() {
//		return new ModelAndView("quest","message","success");
//
//	}
	@RequestMapping("quest")
	public ModelAndView map() {
		String mapCode = "<script>\n" + 
				"\n" + 
				"      function initMap() {\n" + 
				"\n" + 
				"        var grandCircus = {lat: 42.335953, lng: -83.049772};\n" + 
				"        var GCParking = {lat:42.336034, lng: -83.050234};\n" + 
				"        var test = {lat:43.336034, lng: -84.050234};\n" + 
				"\n" + 
				"        var map = new google.maps.Map(document.getElementById('map'), {\n" + 
				"\n" + 
				"          zoom: 16,\n" + 
				"\n" + 
				"          center: grandCircus\n" + 
				"\n" + 
				"        });\n" + 
				"\n" + 
				"        var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"          position: grandCircus,\n" + 
				"\n" + 
				"          map: map\n" + 
				"\n" + 
				"        });\n" + 
				"\n" + 
				"         var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"          position: GCParking,\n" + 
				"\n" + 
				"          map: map\n" + 
				"\n" + 
				"        });\n" + 
				"        var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"        position: test,\n" + 
				"\n" + 
				"        map: map\n" + 
				"\n" + 
				"});\n" + 
				"\n" + 
				"      }\n" + 
				"\n" + 
				"    </script>\n" + 
				"\n" + 
				"    <script async defer\n" + 
				"\n" + 
				"    src=\"https://maps.googleapis.com/maps/api/js?key=" + GoogleMapsAPICred.MAPS_API_KEY + "ap\">\n" + 
				
				"\n" + 
				"    </script>";
		
		return new ModelAndView("quest", "mapIn", mapCode);
	}
}
