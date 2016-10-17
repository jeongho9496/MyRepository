package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1014
		//어떤 JDBC Driver를 사용할 것인가(JDBC Driver 로딩)
		//Class.forName("oracle.jdbc.driver.OracleDriver");//8i,9i 등 전 버전에서 사용
		Class.forName("oracle.jdbc.OracleDriver");
		
		//연결 요청을 해서 연결 객체를 얻기
		//DriverManager.getConnection(String url, String user, String password) => Connection정보를 얻기 위함.(Connection 리턴)
		//url - ip,port,db명이 들어감 user - user명 passpwd - 비밀번호
		/*Where the URL is of the form:
			jdbc:oracle:<drivertype>:@<database>
			The following example connects user scott with password tiger to a database with SID orcl through port 1521 of host myhost, using the Thin driver.
			Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@myhost:1521:orcl", "scott", "tiger");
			Specifying a Databse URL That Includes User Name and Password */
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@106.253.56.123:1521:orcl", "kosauser2", "kosa12345");

		//SQL문을 보내고 실행시킴
		String sql = "select * from emp";
		PreparedStatement pstmt = conn.prepareStatement(sql);//PreparedStatement : 실행할 준비가 되면 준비된 객체를 얻음
		ResultSet rs = pstmt.executeQuery();// resultset(결과 값)으로 리턴
		
		//결과셋(resultset)에서 한행 씩 읽기
		while (rs.next()) {//next : 커서를 한칸씩 내리는 역할 데이터가 있으면 : true, 없으면 : false
			String empno = rs.getString("empno");
			String ename = rs.getString("ename");
			System.out.println(empno+" : "+ename);
			
		}
		System.out.println("DB 출력완료");
		//JDBC 관련 객체 닫기(메모리 리소스 해제)
		rs.close();
		pstmt.close();
		conn.close();
		
		
	}
}
