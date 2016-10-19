package ch08.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Member;

public class MemberDao {
	// 1019
	//삽입
	public void insert(Member member) {
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "INSERT INTO MEMBER(MID, MNAME, MAGE, MBIRTH)" + " VALUES(?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMname());
			pstmt.setInt(3, member.getMage());
			pstmt.setDate(4, new Date(member.getMbirth().getTime()));// Date는 import java.sql.Date로 설정 여기서만 사용
			
			int rowNo = pstmt.executeUpdate(); // 정상적인 상태면 1을 리턴 아닐경우 Exception리턴
			// executeUpdate() 데이터 생성, 삭제, 수정 할때 사용
			// executeQuery() 데이터 조회(select) 할때만 사용
			
			if (rowNo == 1) {
				System.out.println("저장 성공");
			}
			pstmt.close();
			
		} catch (Exception e) {
			// JDBC로 발생할수 있는 예외는 거의 SQLException이다.
			System.out.println("저장 성공");
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	
	//수정
	public void update(Member member){
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "update member set mage=?, mbirth=? where mid=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getMage());
			pstmt.setDate(2, new Date(member.getMbirth().getTime()));
			pstmt.setString(3, member.getMid());
			
			int rowNo = pstmt.executeUpdate();	//1이상의 값 => 1개 이상의 행이 수정 or 
												//0 => 어떤 행도 수정되지 않았음
												//예외 => 코드 오류
						
			if (rowNo >= 1) {
				System.out.println("수정 성공");
			} else if(rowNo == 0){
				System.out.println("수정된 행이 없음");
			}
			pstmt.close();
			
		} catch (Exception e) {
			// JDBC로 발생할수 있는 예외는 거의 SQLException이다.
			System.out.println("수정 실패");
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	//삭제
	public void deleteByMid(String mid){
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "delete member where mid=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mid);
			
			int rowNo = pstmt.executeUpdate();	//1이상의 값 => 1개 이상의 행이 수정 or 
												//0 => 어떤 행도 수정되지 않았음
												//예외 => 코드 오류
						
			if (rowNo >= 1) {
				System.out.println(rowNo+"개 삭제 성공");
			} else if(rowNo == 0){
				System.out.println("삭제 행이 없음");
			}
			pstmt.close();
			
		} catch (Exception e) {
			// JDBC로 발생할수 있는 예외는 거의 SQLException이다.
			System.out.println("삭제 실패");
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
