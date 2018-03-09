package com.gc.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gc.controller.dao.HibernateQuestDao;
/**
 * @author Alex Brozovich, Zach Zatina, Ben Fogt, Andrew Calabro-Cavin
 *
 */

@Controller
public class HomeController {
	
	/**
	 * 
	 * @param model
	 * @return String index - directs to index page
	 * 
	 */
	@RequestMapping("/")
	public String index(Model model) {	
		boolean codeValid = true;
		model.addAttribute("valid", codeValid);
		
		return "index";
	}

}
