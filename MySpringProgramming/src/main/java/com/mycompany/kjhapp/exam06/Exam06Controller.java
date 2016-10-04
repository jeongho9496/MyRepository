package com.mycompany.kjhapp.exam06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam06")
public class Exam06Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam06Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam06/index";
	}
	
	@RequestMapping("/method1")
	public String method1(HttpServletRequest request){//HttpServletRequest 요청 Http에 대한 모든 내용을 가지고 있다.
		//ex) 요청방식(GET||POST), 요청경로, 헤더행, 본문 등등...
		//Tomcat이 HttpServletRequest 구현객체를 만들어줌
		logger.info("method1 요청 처리");
		
		//클라이언트의 IP얻기
		logger.info("WebClient ip -> " + request.getRemoteAddr());//요청한 클라이언트의 주소를 받음
		
		//클라이언트 브라우저 종류 얻기
		logger.info("WebClient 종류 -> " + request.getHeader("User-Agent"));//헤더 정보를 얻어냄
		if (request.getHeader("User-Agent").contains("Chrome")) {
			logger.info("브라우저 종류:크롬");
			
		} else if (request.getHeader("User-Agent").contains("Trident/7.0")) {	//Trident/7.0 => IE 11
			logger.info("브라우저 종류:인터넷 익스플로러 11");
			
		} else if(request.getHeader("User-Agent").contains("MSIE")){
			logger.info("브라우저 종류:인터넷 익스플로러 10이하");
			
		}
		
		//요청 파라미터 값
		logger.info("mid: "+ request.getParameter("mid"));
		logger.info("mname: "+ request.getParameter("mname"));
		
		//쿼리 문자열 얻기
		logger.info("쿼리 문자열: "+request.getQueryString());
		logger.info("요청 URI: "+request.getRequestURI());//port버전까지는 생략
		logger.info("요청 URL: "+request.getRequestURL());//IP포함 전체가 나온다
		logger.info("요청 방식: "+request.getMethod());//요청 방식 얻어온다.
		logger.info("시스템 파일 경로: "+request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg"));//서버 시스템의 절대 경로 지정
		
		
		return "exam06/index";
	}
	
	@RequestMapping("/method2")
	public void method2(HttpServletRequest request,HttpServletResponse response) throws IOException{//response 추가
		/*response.setContentType("application/json; charset=UTF-8");//=> 시작행에서 Content-Type:application/json; charset=UTF-8로 응답을 보냄
		//OutputStream os = response.getOutputStream(); json 이 문자 형식이므로 PrintWriter가 더 편리함
		PrintWriter pw = response.getWriter();
		pw.println("{mid:'fall', mname:'한가을'}");
		pw.flush();
		pw.close();
		//Request,Response 객체는 일회성 이기 때문에 자동 flush(), close()가 된다.
*/		
		response.setContentType("image/jpeg");//Content-Type 설정
		
		String fileName = "사진2.jpg";
		fileName = URLEncoder.encode(fileName, "UTF-8"); //fileName(한글) UTF-8형식으로 변환
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");//첨부화일 만들기(다운로드)
		
		OutputStream os = response.getOutputStream();
		
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg");
		InputStream is = new FileInputStream(filePath);
		byte[] values =new byte[1024];
		int byteNum = -1;
		while ((byteNum = is.read(values)) != -1 ) {
			os.write(values, 0, byteNum);
		}
		os.flush();
		is.close();
		os.close();
	}
	
	@RequestMapping("/method3")
	public String method3(@RequestHeader("User-Agent") String userAgent){//RequestHeader("User-Agent") 헤더값을 가져온다.
		//RequestHeader 값 읽기
		if (userAgent.contains("Chrome")) {
			logger.info("브라우저 종류:크롬");
			
		} else if (userAgent.contains("Trident/7.0")) {	//Trident/7.0 => IE 11
			logger.info("브라우저 종류:인터넷 익스플로러 11");
			
		} else if(userAgent.contains("MSIE")){
			logger.info("브라우저 종류:인터넷 익스플로러 10이하");
			
		}
		return "exam06/index";
	}
}
