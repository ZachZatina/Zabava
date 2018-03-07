package com.gc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gc.utils.GoogleMapsAPICred;
import com.gc.model.TaskDTO;
import com.gc.utils.HibernateUtil;
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
		ArrayList<TaskDTO> taskList = QuestController.generateQuestList();
		System.out.println(taskList.size());
		ArrayList<String> latList = new ArrayList<String>();
		ArrayList<String> longList = new ArrayList<String>();
		for(int i = 0; i < taskList.size(); i++) {
			latList.add(taskList.get(i).getLat());
			longList.add(taskList.get(i).getLon());
		}
//		latList.add("42.335953");
//		longList.add("-83.049772");
//		latList.add("42.336034");
//		longList.add("-83.050234");
//		latList.add("43.446034");
//		longList.add("-84.050234");
		String mapCode = "<script>\n" + 
				"\n" + 
				"      function initMap() {\n" + 
				"\n";
				for(int i = 0; i < latList.size(); i++ ) {
					mapCode += "        var set" + String.valueOf(i) + " = {lat: " + latList.get(i) + ", lng: " + longList.get(i) + "};\n";
				}

				
				mapCode += "\n" + 
				"        var map = new google.maps.Map(document.getElementById('map'), {\n" + 
				"\n" + 
				"          zoom: 16,\n" + 
				"\n" + 
				"          center: set0\n" + 
				"\n" + 
				"        });\n" + 
				"\n" + 
				"        var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"          position: set0,\n" + 
				"\n" + 
				"          map: map\n" + 
				"\n" + 
				"        });\n" + 
				"\n" + 
				"         var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"          position: set1,\n" + 
				"\n" + 
				"          map: map\n" + 
				"\n" + 
				"        });\n" + 
				"        var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"        position: set2,\n" + 
				"\n" + 
				"        map: map\n" + 
				"\n" + 
				"});\n" + 
				"        var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"        position: set3,\n" + 
				"\n" + 
				"        map: map\n" + 
				"\n" + 
				"});\n" + 
				"        var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"        position: set4,\n" + 
				"\n" + 
				"        map: map\n" + 
				"\n" + 
				"});\n" + 
				"        var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"        position: set5,\n" + 
				"\n" + 
				"        map: map\n" + 
				"\n" + 
				"});\n" + 
				"        var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"        position: set6,\n" + 
				"\n" + 
				"        map: map\n" + 
				"\n" + 
				"});\n" + 
				"        var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"        position: set7,\n" + 
				"\n" + 
				"        map: map\n" + 
				"\n" + 
				"});\n" + 
				"        var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"        position: set8,\n" + 
				"\n" + 
				"        map: map\n" + 
				"\n" + 
				"});\n" + 
				"        var marker = new google.maps.Marker({\n" + 
				"\n" + 
				"        position: set9,\n" + 
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
				"    src=\"https://maps.googleapis.com/maps/api/js?key=" + GoogleMapsAPICred.MAPS_API_KEY + "&callback=initMap\">\n" + 
				
				"\n" + 
				"    </script>";
//		
		return new ModelAndView("quest", "mapIn", mapCode);
	}
}
