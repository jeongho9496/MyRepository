package com.mycompany.kjhweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.kjhweb.dao.MemberDao;
import com.mycompany.kjhweb.dto.Member;


@Component
public class MemberService {
	
	public static final int JOIN_SUCCESS=0;
	public static final int JOIN_FAIL=1;
	
	public static final int LOGIN_SUCCESS=0;
	public static final int LOGIN_FAIL_MID=1;
	public static final int LOGIN_FAIL_MPASSWORD=2;	

	public static final int LOGOUT_SUCCESS=0;
	public static final int LOGOUT_FAIL=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int WITHDRAW_SUCCESS=0;
	public static final int WITHDRAW_FAIL=1;
	
	@Autowired
	private MemberDao memberDao;
	
	public int join(Member member){
		//예외처리를 하면 안된다.
		memberDao.insert(member);
		return JOIN_SUCCESS;
	}
	
	public int login(String mid, String mpassword){
		
		//회원 로그인
		Member member = memberDao.selectByMid(mid);//사용자가 작성한 아이디로 DB에 있는 회원정보를 가져온다.
		if (member == null) {
			//디비에 멤버가 없다.
			return LOGIN_FAIL_MID;
		} 
		
		if(member.getMpassword().equals(mpassword) == false){
			//디비에 있는 비밀번호와 다름.
			return LOGIN_FAIL_MPASSWORD;
		}
		
		return LOGIN_SUCCESS;
	}
	
	public int logout(String mid){
		//회원 로그아웃
		return LOGOUT_SUCCESS;
	}
	
	public boolean isMid(String mid){
		//기존 회원 아이디 있는지 체크
		Member member = memberDao.selectByMid(mid);
		if (member==null) {
			return false;
		}//기존 회원 아이디가 없다.
		return true;
	}	
}
