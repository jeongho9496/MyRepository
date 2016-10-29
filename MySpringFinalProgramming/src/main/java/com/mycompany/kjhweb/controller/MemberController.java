package com.mycompany.kjhweb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(){
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String mid, String mpassword, HttpSession session, Model model){
		int result = memberService.login(mid, mpassword);
		
		if (result == MemberService.LOGIN_FAIL_MPASSWORD) {
			model.addAttribute("error","LOGIN_FAIL_MPASSWORD");//모델에 결과값 저장
			return "member/loginForm";
		
		} else if(result == MemberService.LOGIN_FAIL_MID) {
			model.addAttribute("error","LOGIN_FAIL_MID");
			return "member/loginForm";
		
		} else {
		
			session.setAttribute("login", mid);//성공시 session에 저장			
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		logger.info("joinForm 처리");
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
