package com.mycompany.myapp.exam08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.exam04.Exam04Controller;

@Controller
@RequestMapping("/exam08")
public class Exam08Controller {
	//1006
	private static final Logger logger = LoggerFactory.getLogger(Exam04Controller.class);

	
	@RequestMapping("/index")
	public String index(){
		return "exam08/index";
	}
	
	@RequestMapping("/join")
	public String join(){
		return "exam08/index";
	}
}
