package com.mycompany.myapp.exam07;

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
}
