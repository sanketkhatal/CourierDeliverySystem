package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller


public class HomeController {
	
	public HomeController() {
		// TODO Auto-generated constructor stub
		System.out.println("In Constructor of HomeController");
	}
	
	@GetMapping("/")
	public String showHomePage() {
		return "/index";
	}
	
	
	
	
	
	
	

}
