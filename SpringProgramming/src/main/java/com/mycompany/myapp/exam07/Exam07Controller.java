package com.mycompany.myapp.exam07;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam07")
public class Exam07Controller {
	//1004
	
	private static final Logger logger = LoggerFactory.getLogger(Exam07Controller.class);

	@RequestMapping("/index")
	public String index(){
		logger.info("index호출");
		return "exam07/index";
	}
	
	@RequestMapping("/method1")
	public String method1(HttpServletRequest request){//request는 응답시 없어진다(일회성)
		logger.info("method1호출");
		request.setAttribute("data1", "value1");//data1이름으로 된 객체에 value1 문자열 저장
		request.setAttribute("data2", "value2");//data2이름으로 된 객체에 value2 문자열 저장
		return "exam07/usedata";
	}
	
	@RequestMapping("/method2")
	public String method2(HttpSession session){
		logger.info("method2호출");
		session.setAttribute("data1", "value1");//data1이름으로 된 객체에 value1 문자열 저장
		session.setAttribute("data2", "value2");//data2이름으로 된 객체에 value2 문자열 저장
		return "exam07/usedata";
	}
	
	@RequestMapping("/method3")//**Spring에서 많이 사용
	public String method3(Model model){
		logger.info("method2호출");
		model.addAttribute("data1", "value1");//data1이름으로 된 객체에 value1 문자열 저장
		model.addAttribute("data2", "value2");//data2이름으로 된 객체에 value2 문자열 저장
		return "exam07/usedata";
	}
	
	//1006
	@RequestMapping("/method4")
	public String method4(Model model){
		Board board = new Board();
		board.setBno(1);
		board.setTitle("오늘은 목요일");
		board.setContent("실력을 키우도록 해요");
		board.setHitcount(3);
		model.addAttribute("board",board);//board객체 저장
		return "exam07/usedata";
	}
	
	@RequestMapping("/method5")
	public String method5(Model model){
		List<Board> list = new ArrayList<>();//컬랙션 생성
		for (int i=1; i <= 5; i++) {
			Board board = new Board();
			board.setBno(i);
			board.setTitle("제목"+i);
			board.setContent("내용"+i);
			board.setHitcount(1);
			list.add(board);//컬랙션에 board객체 저장
		}
		
		model.addAttribute("boardlist",list);//list(컬랙션)을 모델에 저장(생성)
		return "exam07/usedata";
	}
}
