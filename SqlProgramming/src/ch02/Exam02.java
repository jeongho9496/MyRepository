package ch02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1017
		Class.forName("oracle.jdbc.OracleDriver");//JDBC 드라이버를 메모리에 로딩 방법1
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1", "kosa12345");
		
		/*방법2
		 * Driver oracleDriver = new OracleDriver();
		DriverManager.registerDriver(oracleDriver);
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1", "kosa12345");*/
	
		//매개변수화된 SQL문
		String sql = "select * from emp where ename like ?";//?->앞으로 어떤 값이 들어온다. 문자열 일부분은 ? 처리 할수 없다 ex) '%?%'
		PreparedStatement pstmt = conn.prepareStatement(sql);//실행준비를 만든 메소드
		pstmt.setString(1, "%성%");//.setString(값을 넣을 인덱스 번호(1부터 시작), 연결 코드);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			 int empnoIndex = rs.getInt(1);//컬럼의 순번
			 String empno = rs.getString("empno");//"empno"컬럼 가져오기
			 String ename = rs.getString("ename");
			 Date date = rs.getDate("HIREDATE");
			 System.out.println(empno+" "+ename+":"+date);
		}
		
		
		rs.close();
		pstmt.close();
		conn.close();//돈과 관련 되기 때문에 꼭 종료를 해줘야 한다.
	}
}
