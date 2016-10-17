package ch02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1017
		Class.forName("oracle.jdbc.OracleDriver");//JDBC 드라이버를 메모리에 로딩 방법1
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1", "kosa12345");
		
		/*방법2
		 * Driver oracleDriver = new OracleDriver();
		DriverManager.registerDriver(oracleDriver);
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1", "kosa12345");*/
	
		//매개변수화된 SQL문
		String sql = "select empno,ename,sal*12+nvl(comm,0) as yearsal from emp" 
					+" where sal>? and deptno=?"//칸 이동시 앞이든 뒤든 띄어쓰기를 해야한다.
					+" order by yearsal desc";//(시험?)
		PreparedStatement pstmt = conn.prepareStatement(sql);//실행준비를 만든 메소드
		pstmt.setInt(1, 400);//.setString(값을 넣을 인덱스 번호(1부터 시작), 연결 코드);
		pstmt.setInt(2, 30);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			 int empno = rs.getInt("empno");
			 String ename = rs.getString("ename");
			 int yearsal = rs.getInt("yearsal");
			 System.out.println(empno+" "+ename+":"+yearsal);
		}
		
		rs.close();
		pstmt.close();
		conn.close();//돈과 관련 되기 때문에 꼭 종료를 해줘야 한다.
	}
}
