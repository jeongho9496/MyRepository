package finalsource.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import finalsource.dto.Member;

public class MemberDao {
	//1019
	//Connection 주입
	private Connection conn;
	//하나의 Connection으로 연결하기 위함.
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public int insert(Member member) throws SQLException{
		//insert 리턴은 1 or Exception
		String sql = "insert into member(mid, mname, mpassword, mage, mbirth) values(?,?,?,?,?) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMid());
		pstmt.setString(2, member.getMname());
		pstmt.setString(3, member.getMpassword());
		pstmt.setInt(4, member.getMage());
		pstmt.setDate(5, new Date(member.getMbirth().getTime()));

		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		
		return rowNo;
	}
	
	public Member selectByMid(String mid) throws SQLException{
		//1개의 행을 가져옴
		//데이터가 없으면 null리턴
		String sql = "select mid, mname, mpassword, mage, mbirth from member where mid=?";
		Member member = null;
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			
			member = new Member();
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMpassword(rs.getString("mpassword"));
			member.setMage(rs.getInt("mage"));
			member.setMbirth(rs.getDate("mbirth"));
		}
		
		rs.close();
		pstmt.close();
		
		return member;
	}
	
	public List<Member> selectByMname(String mname) throws SQLException{
		//여러개의 행을 가져올때(중복)
		//데이터가 없으면 비어있는 List객체 리턴
		String sql = "select mid, mname, mpassword, mage, mbirth from member where mname like ?";
		List<Member> list = new ArrayList<>();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+mname+"%");
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			Member member = new Member();
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMpassword(rs.getString("mpassword"));
			member.setMage(rs.getInt("mage"));
			member.setMbirth(rs.getDate("mbirth"));
			list.add(member);
			
		}
		
		rs.close();
		pstmt.close();
		
		return list;
	}
	
	public int update(Member member) throws SQLException{
		//수정된 행수 리턴
		String sql = "update member set mname=?, mpassword=? ,mage=?, mbirth=? where mid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMname());
		pstmt.setString(2, member.getMpassword());
		pstmt.setInt(3, member.getMage());
		pstmt.setDate(4, new Date(member.getMbirth().getTime()));
		pstmt.setString(5, member.getMid());
		
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		
		return rowNo;//업데이트된 행수 return
	}
	
	public int deleteByMid(String mid) throws SQLException{
		//삭제된 행수 리턴
		String sql = "delete member where mid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		
		return rowNo;//최대 1개만 지워짐.
	}
}
