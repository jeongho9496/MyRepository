package com.mycompany.kjhweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mycompany.kjhweb.dto.Member;

@Component
public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Member member){
		String sql = "insert into member(mid, mname, mpassword, maddress, mtel, memail) "
				+ "values(?,?,?,?,?,?)";
		
		int row = jdbcTemplate.update(
				sql,
				member.getMid(),
				member.getMname(),
				member.getMpassword(),
				member.getMaddress(),
				member.getMtel(),
				member.getMemail()
				);
		return row;
	}
}
