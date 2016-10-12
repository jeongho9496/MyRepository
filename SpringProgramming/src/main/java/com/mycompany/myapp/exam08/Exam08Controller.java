package com.mycompany.myapp.exam08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/exam08")
public class Exam08Controller {
	//컨트롤러 추가시 서버 재시작
	//1006
	private static final Logger logger = LoggerFactory.getLogger(Exam08Controller.class);

	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam08/index";
	}
	
	@RequestMapping("/join")
	public String join(){
		logger.info("join 처리");
		return "redirect:/exam08/index";//재 요청 경로(뷰이름 아님)
	}
	
	@RequestMapping("/write")
	public String write(){
		logger.info("write 처리");
		return "redirect:/exam08/list";//재 요청 경로(뷰 이름 아님)
	}
	
	@RequestMapping("/list")
	public String list(){
		logger.info("list 처리");
		return "exam08/list";
	}
}
