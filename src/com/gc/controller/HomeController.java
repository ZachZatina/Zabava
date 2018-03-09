package com.gc.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gc.controller.dao.HibernateQuestDao;
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

}
