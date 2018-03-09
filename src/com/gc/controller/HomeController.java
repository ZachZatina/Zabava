package com.gc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String index(Model model) {	
		boolean codeValid = true;
		model.addAttribute("valid", codeValid);
		
		return "index";
	}

}
