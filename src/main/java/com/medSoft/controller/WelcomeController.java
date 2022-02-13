package com.medSoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		return "jsp/welcome.jsp";
	}
	
	@RequestMapping("/home")
	public String home() {
		//return "view/welcome";
		return "jsp/home.jsp";
	}
	
}
