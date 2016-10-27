package com.mycompany.kjhweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.kjhweb.dao.MemberDao;
import com.mycompany.kjhweb.dto.Member;


@Component
public class MemberService {
	public static final int JOIN_SUCCESS=0;
	public static final int JOIN_FAIL=1;
	
	@Autowired
	private MemberDao memberDao;
	
	public int join(Member member){
		//예외처리를 하면 안된다.
		memberDao.insert(member);
		return JOIN_SUCCESS;
	}
}
