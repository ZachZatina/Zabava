package com.gc.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@Controller
public class QuestBuilderController {

	@RequestMapping("builder")
	public ModelAndView questBuilder(@RequestParam("lat") String lat, @RequestParam("lon") String lon,
			@RequestParam("questName") String questName, @RequestParam("radius") int radius,
			@RequestParam("limit") int limit, Model model) throws IOException {
		
		int questID=0;
		int taskID=0;
		
		// in case our GeoCode isn't working
		if (lat.isEmpty()) {
			lat = "42.335953";
			lon = "-83.049774";
		}
		
		
		/*
		 * Build a QuestDTO object and put it in the DB, retrieving the QuestID
		 */
		QuestDTO quest = new QuestDTO();
		quest.setLocation(lat + "," + lon);
		HibernateQuestDao questDao = new HibernateQuestDao();
		questID = questDao.addQuest(quest);

		ArrayList<TaskDTO> tasks = new ArrayList<TaskDTO>();
		tasks = FourSquareDAOImpl.getFSvenues(lat, lon, radius, limit);

		/*
		 * Add Quest Name and ID to model to use them in the builder page
		 */
		model.addAttribute("questName", questName);
		model.addAttribute("questID", questID);
		
		/*
		 * Create tasks for each point we're given by the FourSquare query
		 */
		for (int i=0;i<tasks.size();i++) {
			tasks.get(i).setQuestID(questID);
			TaskDAOImpl taskDao = new TaskDAOImpl();
			taskID = taskDao.addTask(tasks.get(i));
			tasks.get(i).setTaskID(taskID);
		}

		return new ModelAndView("builder", "tasks", tasks);
	}
	
	@RequestMapping("postqa")
	public void saveQuestAnswers(@RequestParam("taskID") int taskID, @RequestParam("taskdesc") String taskDesc, @RequestParam("taskanswer") String taskAnswer) {
		
		/*
		 * Load the task to be updated.
		 * Set the fields to the new values.
		 * Update the DB.
		 */		
		TaskDTO task = new TaskDAOImpl().getTask(taskID);
		task.setTaskDesc(taskDesc);
		task.setTaskAnswer(taskAnswer);
		
		TaskDAOImpl update = new TaskDAOImpl();
		update.updateTask(task);
	}

}
