package com.mycompany.myapp.exam05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
	//0930
	//1004 void 메소드 (setContentType부분)
	private static final Logger logger = LoggerFactory.getLogger(Exam05Controller.class);

	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청처리");
		return "exam05/index";
	}
	
	//메소드 리턴타입
	@RequestMapping("/index2")
	public ModelAndView index2(){	//ModelAndView
		logger.info("index2 요청처리");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exam05/index");
		return mav;
	}
	
	@RequestMapping("/index3")
	public void index3(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		//void 메소드 안에서 응답을 직접 만들어 보낼때 사용 (jsp를 거치지 않음)
		//매개변수에 HttpServletResponse response 가 들어가있으면 Spring이 자동으로 response 객체를 만든다. 
		//직접 응답을 만들어서 보내고 싶을때 사용 ex)1. 파일데이터(binaryData) 보낼때 주로 사용 2. html이 아닌 데이터만 보낼때
		logger.info("index3 요청처리");
		
		response.setContentType("image/jpeg");//type 설정
		
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg");
		InputStream is = new FileInputStream(filePath);
		OutputStream os = response.getOutputStream();
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while((byteNum = is.read(values))!=-1){
			os.write(values, 0, byteNum);
		}
		os.flush();
		is.close();
		//outputstream tomcat에서 제어하기 때문에 os.close 할 필요 없다.
		
	}
	
}
