package com.mycompany.myapp.exam13.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exam13.dto.Member;
import com.mycompany.myapp.exam13.service.Exam13Service;



@Controller
@RequestMapping("/exam13")
public class Exam13Controller {
	//1025
	
	private static final Logger logger = LoggerFactory.getLogger(Exam13Controller.class);
	
	@Autowired
	private Exam13Service exam13Service;
	
	@RequestMapping("/index")
	public String index() {
		logger.info("index 처리");
		return "exam13/index";
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String joinForm(){
		logger.info("joinForm 처리");
		return "exam13/joinForm";
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(Member member){//member에 사용자가 입력한 내용 담김
		logger.info("join 처리");
		exam13Service.join(member);
		return "redirect:/exam13/index";
	}
}
