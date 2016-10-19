package ch08.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Board;

public class BoardDao {
	//1019
	public void insert(Board board){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "insert into board(bno, btitle, bcontent, bwriter, bhitcount, bdate) "
						+ "values(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());	//인덱스 번호 다르면 에러
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setString(4, board.getBwriter());
			pstmt.setInt(5, board.getBhitcount());
			pstmt.setDate(6, new Date(board.getBdate().getTime()));
			
			int rowNo = pstmt.executeUpdate();
			if (rowNo == 1) {
				System.out.println("저장 성공");
			}
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("저장 실패");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Board board) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			//btitle, bcontent, bwriter, bhitcount, bdate
			String sql = "update board set btitle=?, bcontent=?, bwriter=?, bhitcount=?, bdate=? where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setInt(4, board.getBhitcount());
			pstmt.setDate(5, new Date(board.getBdate().getTime()));
			pstmt.setInt(6, board.getBno());
			
			int rowNo = pstmt.executeUpdate();
			if (rowNo >= 1) {
				System.out.println(rowNo + "개 수정 성공");
			} else if(rowNo == 0){
				System.out.println("수정 할 행이 없음");
			}
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("수정 실패");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteByBno(int bno) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "delete board where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			
			int rowNo = pstmt.executeUpdate();
			if (rowNo >= 1) {
				System.out.println(rowNo + "개 삭제 성공");
			} else if(rowNo == 0){
				System.out.println("삭제 할 행이 없음");
			}
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("삭제 실패");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
