package com.medSoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		//return "view/welcome";
		return "welcome";
	}
	
	@RequestMapping("/home")
	public String home() {
		//return "view/welcome";
		return "home";
	}
	
}
