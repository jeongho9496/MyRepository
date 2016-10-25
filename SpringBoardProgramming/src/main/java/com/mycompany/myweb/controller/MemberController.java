package com.mycompany.myweb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	//1025
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@RequestMapping("/")
	public String index() {
		
		logger.debug("home() 실행");	
		return "home";
	}
	
}
