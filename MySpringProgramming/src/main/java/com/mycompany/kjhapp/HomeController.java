package com.mycompany.kjhapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String home() {
		
		logger.debug("home() 실행");
		
		return "home";
	}
	
	@RequestMapping("/news")
	public String news(){
		logger.debug("news() 실행");
		return "news";
	}
	
}
