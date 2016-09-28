package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {
	//필드
	private String location;
	
	//생성자
	public NowServlet() {
		//클라이언트가 최초로 요청할때 생성자를 처음 실행하고 재사용된다
		System.out.println("NowServlet 객체 생성");
	}
	
	//초기화 메소드
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("NowServlet 초기화");
		location = config.getInitParameter("location");	//<param value> 값이 리턴된다. 값을 받아온다. 받아온 값은 doGet(). doPost()에서 사용 할수 있다.
	}
	
	//0928
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet() = Client가 GET방식의 요청이 있을때 doGet()가 실행
		//HttpServletRequest request, HttpServletResponse response -> Tomcat이 만듬
		//throws ServletException, IOException -> 예외처리
		//URL로 접근하는 방식은 GET방식
		
		//System.out.println("doGet() 실행");
		response.setContentType("text/html; charset=UTF-8");//헤더행의 Content-Type에 넣어줌
		//response.setHeader("ContentType", "text/html; charset=UTF-8");
		
		//OutputStream os = response.getOutputStream();//여러가지 데이터를 보낼때 사용	요청 HTTP의 본문에 실려서 들어감
		PrintWriter out = response.getWriter();//println() 사용하기 위해 설정. 문자 보낼때만 사용	요청. 응답HTTP의 본문에 실려서 들어감
		out.println("<html>");
		out.println("<head><title> 현재시간 </title></head>");
		out.println("<body>");
		out.println("현재 "+location+"시간은 : ");
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		out.println(simpleDate.format(new Date()));
		out.println("입니다.");
		out.println("</body></html>");//끝태그 항시 작성
	}

}
