package com.mycompany.kjhapp.exam03;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	//0929
	
	private static final Logger logger = LoggerFactory.getLogger(Exam03Controller.class);

	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청처리");
		return "exam03/index";
	}
	
	@RequestMapping("/join")
	public String join(Member member){
		logger.info("join 요청처리");
		logger.info("mid" + member.getMid());
		logger.info("mname" + member.getMname());
		logger.info("mpassword" + member.getMpassword());
		logger.info("memail" + member.getMemail());
		logger.info("mtel" + member.getMtel());
		logger.info("mjob" + member.getMjob());
		logger.info("mskill" + Arrays.toString(member.getMskill()));
		logger.info("maddress1" + member.getMaddress1());
		logger.info("maddress2" + member.getMaddress2());
		logger.info("mbirth" + member.getMbirth());
		return "exam03/index";
	}
}
