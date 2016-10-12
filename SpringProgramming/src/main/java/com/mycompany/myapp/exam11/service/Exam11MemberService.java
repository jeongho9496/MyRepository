package com.mycompany.myapp.exam11.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam11.dao.Exam11MemberDao;
import com.mycompany.myapp.exam11.dto.Member;

@Component
public class Exam11MemberService {
	//1012
	private static final Logger logger = LoggerFactory.getLogger(Exam11MemberService.class);
	
	public static final int LOGIN_SUCCESS = 0;			//결과 상수로 정의
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
	
	//DAO 주입
	@Autowired
	private Exam11MemberDao memberDao;
	
	public void join(Member member){
		logger.info("join 처리");
		memberDao.insert(member);	//데이터 베이스에 member정보 생성(저장)
		
	}
	public int login(String mid, String mpassword){
		logger.info("login 처리");
		Member member = memberDao.select(mid);	//mid값을 매개값으로 주면 select가 데이터베이스로 가서 mid가 있는지 조사(조회,검색)
		if(member == null) {
			return LOGIN_FAIL_MID;
		} else {
			if (member.getMpassword().equals(mpassword)) {
				return LOGIN_SUCCESS;
			} else {
				return LOGIN_FAIL_MPASSWORD;				
			}
		}
	}
}
