package com.mycompany.myapp.exam03;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.exam02.Exam02Controller;

//0929
@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam03Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청처리");
		return "exam03/index";
	}
	
	@RequestMapping("/join")
	public String join(Member member){//Member => 커맨드 객체
		logger.info("join 요청처리");
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
		return "exam03/index";
	}
}
