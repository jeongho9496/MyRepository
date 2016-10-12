package com.mycompany.myapp.exam04;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	//0930
	private static final Logger logger = LoggerFactory.getLogger(Exam04Controller.class);

	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청처리");
		return "exam04/index";
	}
	
	@RequestMapping(value = "/join" , method=RequestMethod.GET)	//value로 요청하면서 요청타입이 method 방식일때
	//method=RequestMethod.GET => 간단한 형식만 보낸다. 문자만 보낼수있음. 데이터 양이 제한되있다. 본문에 데이터가 없다. 시작행에 파라미터로 데이터 들어간다. 보안에 취약하다.
	//ex) GET/exam04/join? mid=~&mname=~
	public String joinForm(){
		
		logger.info("joinForm 요청처리");
		return "exam04/joinform";
	}
	
	@RequestMapping(value = "/join" , method=RequestMethod.POST)
	//method=RequestMethod.POST => 어떤 데이터도 보낼수 있다. 데이터 양에 제한이 없다. 시작행에 요청 경로만 들어가고 본문에 데이터가 들어간다. 보안에 강함
	//ex) POST/exam04/join
	public String join(Member member){
		
		logger.info("join 요청처리");
		logger.info("mid : " + member.getMid());
		
		/*String name = member.getMname();
		try {
			name = new String(name.getBytes("8859_1"),"UTF-8");//한글이 필요한 경우 해당
		} catch (UnsupportedEncodingException e) {}
		*/
		logger.info("mname : " + member.getMname());
		logger.info("mpassord : " + member.getMpassword());
		logger.info("memail : " + member.getMemail());
		logger.info("mtel : " + member.getMtel());
		logger.info("mjob : " + member.getMjob());
		logger.info("mskill[] : " + Arrays.toString(member.getMskill()));//Arrays.toString()=>배열의 들어온 값을 읽어 온다.
		logger.info("maddress1 : " + member.getMaddress1());
		logger.info("maddress2 : " + member.getMaddress2());
		logger.info("mbirth : " + member.getMbirth());
		return "exam04/index";//redirect:/exam04/index => Return시 redirect로 변경을 안하면 주소가 바뀌지 않는 forward로 응답한다.
	}
	
	
	@RequestMapping(value = "/write" , method=RequestMethod.GET)
	public String writeForm(){
		logger.info("writeForm 요청처리");
		return "exam04/writeform";
	}
	
	//@RequestMapping("/write") //method가 없으면 GET,POST둘다 받을수 있다.
	@RequestMapping(value = "/write", method=RequestMethod.POST) //method가 없으면 GET,POST둘다 받을수 있다.
	public String write(String btitle, String bcontent){
		logger.info("write 요청 처리");
		logger.info("btitle: " + btitle);
		logger.info("bcontent: "+ bcontent);
		
		return "exam04/index";
	}
	
}
