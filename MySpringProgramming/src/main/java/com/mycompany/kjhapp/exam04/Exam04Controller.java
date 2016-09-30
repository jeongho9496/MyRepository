package com.mycompany.kjhapp.exam04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam04Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("kjhapp/index() 요청처리");
		return "exam04/index";
	}
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String boardForm(){
		logger.info("boardForm GET 요청처리");
		return "exam04/BoardForm";
	}
	
	@RequestMapping(value="/board1", method=RequestMethod.POST)
	public String board(Board board){
		logger.info("board POST 요청처리");
		logger.info("title : " + board.getMtitle());
		logger.info("content : " + board.getMcontent());
		logger.info("category : " + board.getMcategory());
		logger.info("file : " + board.getMfile());
		return "exam04/index";
	}
	
}
