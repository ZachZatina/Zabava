package com.gc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("quest")
	public ModelAndView quest() {
		return new ModelAndView("quest","message","success");

	}
}
