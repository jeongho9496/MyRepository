package com.mycompany.kjhweb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//1025
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String index() {
		
		logger.info("index() 실행");	
		return "index";
	}
	
	@RequestMapping("/home")
	public String home() {
		
		logger.info("home() 실행");	
		return "home";
	}
	
}
