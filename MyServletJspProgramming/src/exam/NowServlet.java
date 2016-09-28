package exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {
	//Servlet Class
	//필드
	private String location;
	
	//생성자
	public NowServlet(){
		System.out.println("NowServlet 객체 생성");
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		location = getInitParameter("location");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();//문자열 데이터를 출력 -> 웹브라우저에 데이터를 전송하기위해
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
