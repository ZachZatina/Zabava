package com.gc.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gc.controller.dao.CreatorDAOImpl;
import com.gc.model.CreatorDTO;


@RestController
@RequestMapping("/secure")
public class SecurityController {
	
	private CreatorDAOImpl dao;

	@RequestMapping("/user/users")
	public String loginSuccess() {
		return "Login Successful!";
	}

	@RequestMapping(value = "tokensignin", method = RequestMethod.POST)
	public ModelAndView findByEmail(@RequestBody String email) {
		int creatorID = 0;
		try {
		creatorID = dao.getCreatorByEmail(email).getCreatorID();
		System.out.println("CreatorID: " + creatorID + " " + email);
		if (creatorID > 0) {
			System.out.println("Creator Lookup Success. " + email);
		} else {
		creatorID = dao.addCreator(email);	
		}
		}
		catch (Exception e) {
			System.out.println("Creator Lookup Failed. " + email);
		}
		
		return new ModelAndView("enter","creatorID",creatorID);
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public void updateCreator(@RequestBody CreatorDTO creator) {
		return;
	}
		
	
}