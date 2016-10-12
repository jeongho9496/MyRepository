package com.mycompany.myapp.exam11.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam11.dto.Member;

@Component	//관리객체
public class Exam11MemberDao {
	//1012
	
	private static final Logger logger = LoggerFactory.getLogger(Exam11MemberDao.class);
	
	public void insert(Member member){
		logger.info("insert 처리");
	}
	
	public Member select(String mid){
		logger.info("select 처리");
		return null;
	}
}
