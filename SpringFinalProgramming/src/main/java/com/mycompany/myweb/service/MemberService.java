package com.mycompany.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MemberDao;
import com.mycompany.myweb.dto.Member;

@Component
public class MemberService {
	//1026,1027
	//db에 있는 내용가 사용자가 입력한 내용이 같은지만 비교 하는 메소드 dao,dto만 service에서 작업할수 있게 한다.
	//나머지는 controller에서 구현한다.
	
	//3가지 경우가 발생할 경우 상수 지정을 하여 구분한다.
	//2가지 경우가 발생항 경우 예외 처리가 하나 있울 시 메소드를 void로 작성한다.
	//예외가 아닌 실패일 경우 상수 값으로 리턴 값을 받는다.
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
		Member member = memberDao.selectByMid(mid);//멤버를 가져온다.
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
	public String findMpassword(String mid, String memail){
		//회원 패스워드 찾기
		Member member = memberDao.selectByMid(mid);
		if(member == null) return null;
		if(member.getMemail().equals(memail) == false) return null;
		return member.getMpassword();
	}
	public String findMid(String memail){
		//회원 아이디 찾기
		return memberDao.selectByMemail(memail);
	}
	public Member info(String mid,String mpassword){
		//회원 정보
		Member member = memberDao.selectByMid(mid);
		if (member.getMpassword().equals(mpassword) == false) return null;
		
		return member;
		
	}
	public int modify(Member member){
		//1027
		//회원 수정
		Member dbMember = memberDao.selectByMid(member.getMid());//db에 있는 member를 가져옴
		if (dbMember.getMpassword().equals(member.getMpassword()) == false) {
			return MODIFY_FAIL;
		}//비밀번호 체크
		
		int row = memberDao.update(member);
		if(row != 1) {return MODIFY_FAIL;}
		return MODIFY_SUCCESS;
	}
	public int withdraw(String mid, String mpassword){
		//회원 탈퇴
		Member member = memberDao.selectByMid(mid);
		if (member.getMpassword().equals(mpassword) == false) {return WITHDRAW_FAIL;}
		memberDao.delete(mid);
		logout(mid);
		
		return WITHDRAW_SUCCESS;
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
