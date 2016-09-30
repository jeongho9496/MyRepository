package com.mycompany.myapp.exam06;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.exam05.Exam05Controller;

@Controller
@RequestMapping("/exam06")
public class Exam06Controller {
	//0930
		private static final Logger logger = LoggerFactory.getLogger(Exam06Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam06/index";
	}
	
	@RequestMapping("/method1")
	public String method1(HttpServletRequest request){//HttpServletRequest 요청 Http에 대한 모든 내용을 가지고 있다.
		//ex) 요청방식(GET||POST), 요청경로, 헤더행, 본문 등등...
		//Tomcat이 HttpServletRequest 구현객체를 만들어줌
		logger.info("method1 요청 처리");
		
		//클라이언트의 IP얻기
		logger.info("WebClient ip -> " + request.getRemoteAddr());//요청한 클라이언트의 주소를 받음
		
		//클라이언트 브라우저 종류 얻기
		logger.info("WebClient 종류 -> " + request.getHeader("User-Agent"));//헤더 정보를 얻어냄
		if (request.getHeader("User-Agent").contains("Chrome")) {
			logger.info("브라우저 종류:크롬");
			
		} else if (request.getHeader("User-Agent").contains("Trident/7.0")) {	//Trident/7.0 => IE 11
			logger.info("브라우저 종류:인터넷 익스플로러 11");
			
		} else if(request.getHeader("User-Agent").contains("MSIE")){
			logger.info("브라우저 종류:인터넷 익스플로러 10이하");
			
		}
		
		//요청 파라미터 값
		logger.info("mid: "+ request.getParameter("mid"));
		logger.info("mname: "+ request.getParameter("mname"));
		
		//쿼리 문자열 얻기
		logger.info("쿼리 문자열: "+request.getQueryString());
		logger.info("요청 URI: "+request.getRequestURI());//port버전까지는 생략
		logger.info("요청 URL: "+request.getRequestURL());//IP포함 전체가 나온다
		logger.info("요청 방식: "+request.getMethod());//요청 방식 얻어온다.
		logger.info("시스템 파일 경로: "+request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg"));
		
		
		return "exam06/index";
	}
}
