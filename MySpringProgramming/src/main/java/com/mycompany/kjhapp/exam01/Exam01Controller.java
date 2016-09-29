package com.mycompany.kjhapp.exam01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam01")

public class Exam01Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam01Controller.class);
	
	@RequestMapping("/join")
	public String join(){
		logger.info("join 요청처리");
		return "exam01/join";
	}
	
	@RequestMapping("/login")
	public String login(){
		logger.info("login 요청처리");
		return "exam01/login";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		logger.info("logout 요청처리");
		return "exam01/logout";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw(){
		logger.info("withdraw 요청처리");
		return "exam01/withdraw";
	}
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청처리");
		return "exam01/index";
	}
	
	
	
	
}
