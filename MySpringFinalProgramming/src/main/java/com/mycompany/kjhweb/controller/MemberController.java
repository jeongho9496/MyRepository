package com.mycompany.kjhweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.kjhweb.dto.Member;
import com.mycompany.kjhweb.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberController {
	//1026
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		logger.info("joinForm 처리");
		System.out.println("aaa");
		return "member/joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member){
		try {
			int result = memberService.join(member);
			logger.info("회원가입 성공");
			return "redirect:/";
		} catch (Exception e) {
			logger.info("회원가입 실패");
			return "member/joinForm";
		}
		
	}
	
}
