package com.mycompany.myweb.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Member;
import com.mycompany.myweb.service.MemberService;

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
			model.addAttribute("error","LOGIN_FAIL_MPASSWORD");
			return "member/loginForm";
		
		} else if(result == MemberService.LOGIN_FAIL_MID) {
			model.addAttribute("error","LOGIN_FAIL_MID");
			return "member/loginForm";
		
		} else {
			session.setAttribute("login", mid);//성공시 session에 저장			
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/findMid", method=RequestMethod.GET)
	public String findMidForm(){
		
		return "member/findMidForm";
	}
	
	@RequestMapping(value="/findMid", method=RequestMethod.POST)
	public String findMid(String memail,Model model,HttpSession session){
		String mid = memberService.findMid(memail);
		if (mid == null) {
			model.addAttribute("error", "이메일이 존재하지 않음");//값을 바로 .jsp에 넘김
			return "member/findMidForm";
		}
		session.setAttribute("findMid", mid);
		return "redirect:/member/login";//get방식으로 넘김
	}
	
	@RequestMapping(value="/findMpassword", method=RequestMethod.GET)
	public String findMpasswordForm(){
		
		return "member/findMpasswordForm";
	}
	
	@RequestMapping(value="/findMpassword", method=RequestMethod.POST)
	public String findMpassword(String mid, String memail,Model model,HttpSession session){
		String Mpassword = memberService.findMpassword(mid, memail);
		if (Mpassword == null) {
			model.addAttribute("error", "이메일및 아이디가 존재하지 않음");//값을 바로 .jsp에 넘김
			return "member/findMpasswordForm";
		}
		session.setAttribute("findMpassword", Mpassword);
		return "redirect:/member/login";//get방식으로 넘김
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		return "member/joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member){
		try{
			
			int result = memberService.join(member);
			return "redirect:/member/login";
		}catch (Exception e) {
			return "member/joinForm";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		String mid = (String) session.getAttribute("login");//로그인한 mid를 session에서 받음
		int result = memberService.logout(mid);
		if (result == MemberService.LOGOUT_SUCCESS) {
			session.removeAttribute("login");
		}
		return "redirect:/";
	}
	
	@RequestMapping("/info")
	public String info(String mpassword, HttpSession session, Model model){
		String mid = (String) session.getAttribute("login");//로그인한 mid를 session에서 받음
		Member member = memberService.info(mid, mpassword);
		model.addAttribute("member", member);
		return "member/info";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw(HttpSession session){
		return "member/index";
	}

	
}
