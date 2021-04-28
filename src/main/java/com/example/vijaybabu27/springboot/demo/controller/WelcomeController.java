package com.example.vijaybabu27.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.vijaybabu27.springboot.demo.service.LoginService;

@Controller
public class WelcomeController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", loginService.getLoggedInUserName());
		return "welcome";
	}
	
}
