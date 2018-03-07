package com.gc.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.model.TaskDTO;
import com.gc.utils.FourSquareDAOImpl;

@Controller
public class QuestBuilderController {
	
	
	@RequestMapping("builder")
	public ModelAndView questBuilder(@RequestParam("lat") String lat, @RequestParam("lon") String lon, @RequestParam("questName") String questName, @RequestParam("radius") int radius, @RequestParam("limit") int limit, Model model) throws IOException {
if (lat.isEmpty()) {
	lat = "42.335953";
	lon = "-83.049774";
}

ArrayList<TaskDTO> tasks = new ArrayList<TaskDTO>();
tasks = FourSquareDAOImpl.getFSvenues(lat,lon,radius,limit);
		
		
		return new ModelAndView("editQuest","tasks",tasks);
	}
	
	


}
