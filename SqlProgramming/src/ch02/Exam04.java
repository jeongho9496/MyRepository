package ch02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam04 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1017
		Class.forName("oracle.jdbc.OracleDriver");//JDBC 드라이버를 메모리에 로딩 방법1
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1", "kosa12345");
		
	
		//부서명을 조건으로 해서 부서명 일부분을 입력했을 때
		//부서가 존재할 경우, 부서번호, 부서이름을 출력하고,
		//부서가 존재하지 않을 경우에는 "부서가 없음"을 출력하시오(시험)
		String sql = "select deptno, dname from dept where dname like ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);//실행준비를 만든 메소드
		pstmt.setString(1,"%개발%");
		ResultSet rs = pstmt.executeQuery();
		if (rs.next() == true) {
			do {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				System.out.println(deptno+" : "+dname);
			} while (rs.next());
		} else {
			System.out.println("부서없음");
		}
		
		rs.close();
		pstmt.close();
		conn.close();//돈과 관련 되기 때문에 꼭 종료를 해줘야 한다.
	}
}
