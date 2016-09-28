package com.mycompany.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	//Controller로 취급
@RequestMapping("/member") //-> 공통적으로 적용시키는 부분을 작성
public class MemberController {
	//0928
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/join")//@RequestMapping("~") -> ("~")형식으로 URL이 들어오면 해당 메소드를 처리
	public String join(){
		logger.info("join 요청 처리");
		return "member/join";//-> views에 폴더 추가시 추가한 폴더명/.jsp 파일명을 추가한다.
	}
	
	@RequestMapping("/login")	//세부경로는 각각 따로 매핑한다.
	public String login(){
		logger.info("login 요청 처리");
		return "member/login";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		logger.info("logout 요청 처리");
		return "member/logout";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw(){
		logger.info("withdraw 요청 처리");
		return "member/withdraw";
	}
	
}
