package com.gc.controller;

import java.io.IOException;
import java.util.ArrayList;
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
	public ModelAndView admin(@RequestParam("address") String address, Model model) {
		// presume this page will be called through submit on a login page
		
		String strAddress = address;
		
		model.addAttribute("address", strAddress);

		String mapkey = GoogleMapsAPICred.MAPS_API_KEY;
		
		model.addAttribute("mapkey", mapkey);
		
		return new ModelAndView("admin", "message", "questID");
	}

	@RequestMapping("builder")
	public ModelAndView questBuilder(@RequestParam("lat") String lat, @RequestParam("lon") String lon,
			@RequestParam("questName") String questName, @RequestParam("radius") int radius,
			@RequestParam("limit") int limit, Model model) throws IOException {
		
		int questID=0;
		
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
