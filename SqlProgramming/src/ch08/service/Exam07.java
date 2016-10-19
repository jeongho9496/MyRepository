package ch08.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exam07 {
	//1019
	public static void main(String[] args) {
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			//트랜잭션 작업을 시작
			conn.setAutoCommit(false);	//JDBC는 기본으로 AutoCommit을 사용하기 때문에
										//conn.setAutoCommit(false)으로 트랜잭션 작업을 시작해야함. 
			
			//출금작업
			String sql1 = "update account set abalance=abalance-10000 where ano = '111-111'";//연산식에서 ?를 사용할 수 없음
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			int rowNo1 = pstmt1.executeUpdate(); //행의 개수를 받아 int rowNo에 담는다.
			pstmt1.close();
			
			//입금작업
			String sql2 ="update account set abalance=abalance+10000 where ano = '111-113'";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			int rowNo2 = pstmt2.executeUpdate();
			pstmt2.close();
			
			//작업확인
			if (rowNo1 == 1 && rowNo2 == 1) {
				conn.commit();
				System.out.println("계좌이체 성공함");
			} else {
				conn.rollback();
				System.out.println("계좌가 존재 하지 않아 실패");
			}
			
		} catch (Exception e) {
			// JDBC로 발생할수 있는 예외는 거의 SQLException이다.
			try {conn.rollback();} catch (SQLException e1) {}
			System.out.println("예외 롤백");
			
			
		} finally {
			try {
				conn.setAutoCommit(true);//ConnectionPool에서 사용
				System.out.println("AutoCommit활성");
				conn.close();} catch (SQLException e) {}
		}
	}

}
