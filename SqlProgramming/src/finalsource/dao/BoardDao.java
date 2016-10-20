package finalsource.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import finalsource.dto.Board;

public class BoardDao {
	//1019
	
	private Connection conn;
	public void setConn(Connection conn){
		this.conn = conn;
	}
	
	public int insert(Board board) throws SQLException{
		//insert 리턴은 1 or Exception
		String sql = "insert into board(bno, btitle, bcontent, bwriter, bhitcount, bdate)"
					+" values(seq_board_bno.nextval,?,?,?,0,sysdate)";
		//(seq_board_bno.nextval,?,?,?,0,sysdate) 게시판 날짜는 현재시간으로 하고 조회는 처음에 무조건 0이므로 지정해준다
		//seq_board_bno.nextval 자동으로 숫자 증가
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		
		return rowNo;
	}
	
	public Board selectByBno(int bno) throws SQLException{
		//1개의 행을 가져옴
		//데이터가 없으면 null리턴
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate from board where bno = ?";
		Board board = null;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			
			board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBdate(rs.getDate("bdate"));
		}
		
		rs.close();
		pstmt.close();
		
		return board;
	}
	
	public List<Board> selectByBtitle(String btitle) throws SQLException{
		//여러개의 행을 가져올때(중복)
		//데이터가 없으면 비어있는 List객체 리턴
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate from board where btitle like ?";
		List<Board> list = new ArrayList<>();	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+btitle+"%");
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			Board board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBdate(rs.getDate("bdate"));
			
			list.add(board);
		}
		
		rs.close();
		pstmt.close();
		
		return list;
	}
	
	public int update(Board board) throws SQLException{
		//수정된 행수 리턴
		
		String sql = "update board set btitle=?, bcontent=?, bwriter=?, bhitcount=?, bdate=? where bno=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		pstmt.setInt(4, board.getBhitcount());
		pstmt.setDate(5, new Date(board.getBdate().getTime()));
		pstmt.setInt(6, board.getBno());
		
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		
		return rowNo;
	}
	
	public int deleteByBno(int bno) throws SQLException{
		//삭제된 행수 리턴
		
		String sql = "delete from board where bno=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		
		return rowNo;
	}
}
