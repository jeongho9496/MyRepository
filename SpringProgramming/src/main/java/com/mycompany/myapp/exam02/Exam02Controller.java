package com.mycompany.myapp.exam02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.exam01.Exam01Controller;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	//0929
	private static final Logger logger = LoggerFactory.getLogger(Exam02Controller.class);
	
	@RequestMapping("/index")//@RequestMapping("/~") =>/~ 식의 요청이 들어 오면 실행
	public String index(){
		logger.info("index 요청 처리");
		return "exam02/index";
	}
	
	/*@RequestMapping("/join")//== @RequestMapping(value="/join")
	public String join(String mid, String mname, String mage){
		//.jsp의 파라미터 값이 매개변수로 들어감 단, 메소드의 매개변수 이름과 파라미터 이름이 일치해야 한다.
		logger.info("join 요청 처리");
		logger.info("mid : "+mid);
		logger.info("mname : "+mname);
		logger.info("mage : "+ mage);
		return "exam02/index";
	}*/
	
	@RequestMapping("/join")//== @RequestMapping(value="/join")
	public String join(Member member){//요청시 객체에 .jsp파라미터 값이 들어감
		//.jsp의 파라미터 값이 매개변수로 들어감 단, 메소드의 매개변수 이름과 파라미터 이름이 일치해야 한다.
		logger.info("join 요청 처리");
		logger.info("mid : "+member.getMid());
		logger.info("mname : "+member.getMname());
		logger.info("mage : "+ member.getMage());
		return "exam02/index";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("id")String mid, @RequestParam("password")String mpassword){
		//@RequestParam("") -> 파라미터의 이름과 매개변수가 다를 경우 사용 파라미터 값을 매개변수 값으로 바꾼다.
		logger.info("login 요청 처리");
		logger.info("mid : "+mid);
		logger.info("mpassword : "+mpassword);
		return "exam02/index";
	}
	
	@RequestMapping("/order")
	public String order(int pid, String pname, String pprice, String pcompany){//들어오는 매개변수의 순서가 달라도 이름만 같으면 스프링프레임워크가 자동으로 변수명과 같게 만들어 준다.
		logger.info("order 요청 처리");
		logger.info("pid : "+pid);//모든 데이터는 문자로 들어 오지만 스프링 프레임워크가 중간에서 타입에 맞게 변환 해준다.(boolean 타입은 제외한다.)
		logger.info("pname : "+pname);
		logger.info("pprice : "+pprice);
		logger.info("pcompany : "+pcompany);
		return "exam02/index";
	}
	
	@RequestMapping("/write")
	public String writer(@RequestParam(defaultValue = "1")int bno, 
														String title, 
														String content, 
						@RequestParam(defaultValue = "0")int hitcount){
		//매개변수로 받을 데이터가 없고 매개변수타입이 String이 아니면 예외가 나옴. => default 값(@RequestParam(defaultValue = "1"))을 주어 해결한다.
		logger.info("write 요청 처리");
		logger.info("bno : "+bno);//모든 데이터는 문자로 들어 오지만 스프링 프레임워크가 중간에서 타입에 맞게 변환 해준다.(boolean 타입은 제외한다.)
		logger.info("title : "+title);
		logger.info("content : "+content);
		logger.info("hitcount : "+hitcount);
		return "exam02/index";
		}
		
	@RequestMapping("/update")
	public String update(@RequestParam(defaultValue = "1")int bno, 
														String title, 
														String content, 
						@RequestParam(value="count",defaultValue="0")int hitcount){//@RequestParam에 2가지 정보가 필요하다면 (value="파라미터 변수명",defaultValue="기본값 설정")이런 식으로 작성
		logger.info("update 요청 처리");
		logger.info("bno : "+bno);
		logger.info("title : "+title);
		logger.info("content : "+content);
		logger.info("hitcount : "+hitcount);
		return "exam02/index";
	}
	
	@RequestMapping("/send")
	public String send(Board board){//객체로 넘겨진 데이터를 받음
		logger.info("send 요청 처리");
		logger.info("bno : "+board.getBno());
		logger.info("title : "+board.getTitle());
		logger.info("content : "+board.getContent());
		logger.info("hitcount : "+board.getHitcount());
		return "exam02/index";
	}
}
