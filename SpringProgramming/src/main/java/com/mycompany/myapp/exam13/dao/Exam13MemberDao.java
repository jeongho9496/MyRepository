package com.mycompany.myapp.exam13.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam13.dto.Member;


@Component
public class Exam13MemberDao {
	//1025

	@Autowired
	private JdbcTemplate jdbcTemplate;//설정 파일(servlet-context)에서 만든 JdbcTemplate 주입
	
	public int insert(Member member){
		//insert 리턴은 1 or Exception
		String sql = "insert into member(mid, mname, mpassword, mage, mbirth) values(?,?,?,?,?) ";
		int rowNo = jdbcTemplate.update(
				sql,
				member.getMid(),
				member.getMname(),
				member.getMpassword(),
				member.getMage(),
				member.getMbirth()
				);
		return rowNo;
	}

	
	public Member selectByMid(String mid){
	
		String sql = "select mid, mname, mpassword, mage, mbirth from member where mid=?";
		List<Member> list = jdbcTemplate.query(
				sql,
				new Object[] {mid},
				new RowMapper<Member>(){//익명객체
						@Override
						public Member mapRow(ResultSet rs, int rowNum) throws SQLException {//행의 수만큼 실행하며 Member 객체를 만듬
																							//현재 행에 있는 데이트를 멤버객체에 넣는 코드 작성
								
							Member member = new Member();
							member.setMid(rs.getString("mid"));
							member.setMname(rs.getString("mname"));
							member.setMpassword(rs.getString("mpassword"));
							member.setMage(rs.getInt("mage"));
							member.setMbirth(rs.getDate("mbirth"));								
							return member;
					}
				}
		);
		
		
		return (list.size()!=0) ? list.get(0) : null;
	}
	/*
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
	}*/
}
