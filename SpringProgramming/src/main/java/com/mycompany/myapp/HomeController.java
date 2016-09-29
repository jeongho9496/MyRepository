package com.mycompany.myapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//0927
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//LoggerFactory.getLogger(Class) -> logger구현객체를 가짐
	
	@RequestMapping("/")//context명 다음의 '/'가 들어가면 자동으로 실행
						//http://localhost:8080/myapp/ -> 맨 마지막'/'가 들어가 자동 실행
	
	public String index() {//메소드 이름은 중요하지 않다.
		
		//System.out.println("home() 실행1");//어디서 출력 된지 모름
		logger.debug("home() 실행");	//어디 클래스에서 출력 되는지 사용(오류 찾아 낼때 주로 사용)
		
		return "home";				//views의 .jsp파일명과 같아야 한다.
	}
	
}
