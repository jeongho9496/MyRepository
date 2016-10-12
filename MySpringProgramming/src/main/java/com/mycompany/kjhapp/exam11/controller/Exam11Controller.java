package com.mycompany.kjhapp.exam11.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.kjhapp.exam11.dto.Member;
import com.mycompany.kjhapp.exam11.service.Exam11BoardService;
import com.mycompany.kjhapp.exam11.service.Exam11MemberService;
import com.mycompany.kjhapp.exam11.dto.Board;


@Controller("MemberController")
@RequestMapping("/exam11")
public class Exam11Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam11Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 실행");
		return "exam11/index";
	}
	
	@Autowired	//field 주입
	private Exam11MemberService memberService;
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.GET)//get방식으로 요청시 실행
	public String memberJoinForm(){
		logger.info("memberJoinForm(GET) 처리");
		return "exam11/memberJoinForm";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)//post방식으로 요청시 실행
	public String memberJoin(Member member){//commend 객체
		logger.info("memberJoin(POST) 처리");
		
		logger.info("mid : " + member.getMid());
		logger.info("mname : " + member.getMname());
		logger.info("mpassord : " + member.getMpassword());
		logger.info("memail : " + member.getMemail());
		logger.info("mtel : " + member.getMtel());
		logger.info("mjob : " + member.getMjob());
		logger.info("mskill[] : " + Arrays.toString(member.getMskill()));//Arrays.toString()=>배열의 들어온 값을 읽어 온다.
		logger.info("maddress1 : " + member.getMaddress1());
		logger.info("maddress2 : " + member.getMaddress2());
		logger.info("mbirth : " + member.getMbirth());
		
		memberService.join(member);
		
		return "redirect:/exam11/memberLogin";
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.GET)//get방식으로 요청시 실행
	public String memberLoginForm(){
		logger.info("memberLoginForm(GET) 처리");
		return "exam11/memberLoginForm";
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)//post방식으로 요청시 실행
	public String memberLogin(String mid, String mpassword){
		logger.info("memberLogin(POST) 처리");
		logger.info("mid : " + mid);
		logger.info("mpassword : " + mpassword);
		
		int result = memberService.login(mid, mpassword);
		if(result == Exam11MemberService.LOGIN_SUCCESS){			
			logger.info("Login 성공");
			return "redirect:/exam11/index";			
		} else if(result == Exam11MemberService.LOGIN_FAIL_MID){
			logger.info("Login 실패 - ID_FAILD");
			return "redirect:/exam11/memberLogin";//요청 경로			
		} else	{
			logger.info("Login 실패 - PASSWORD_FAILD");
			return "redirect:/exam11/memberLogin";
		}
	}
	
	@RequestMapping("/memberLogout")
	public String memberLogOut(){
		logger.info("memberLogout 처리");
		return "redirect:/exam11/index";
	}
	
	@Autowired
	private Exam11BoardService boardService;
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.GET)
	public String boardWriteForm(){
		logger.info("boardWriteForm 처리");
		return "exam11/boardWriteForm";
	}
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
	public String boardWrite(Board board){
		logger.info("boardWrite 처리");
		boardService.write(board);
		return "redirect:/exam11/index";
	}
	
	@RequestMapping("/boardList")
	public String boardList(Model model){
		logger.info("boardList 처리");
		List<Board> list = boardService.getList();
		model.addAttribute("boardlist", list);// request에 boardlist 이름으로 list 저장
		return "exam11/boardList";
	}
	
	
}
