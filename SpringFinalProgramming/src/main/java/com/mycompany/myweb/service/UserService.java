package com.mycompany.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.UserDao;
import com.mycompany.myweb.dto.User;

/*작성자: 이윤주*/

@Component
public class UserService {
	//1026,1027
	//db에 있는 내용가 사용자가 입력한 내용이 같은지만 비교 하는 메소드 dao,dto만 service에서 작업할수 있게 한다.
	//나머지는 controller에서 구현한다.
	
	//3가지 경우가 발생할 경우 상수 지정을 하여 구분한다.
	//2가지 경우가 발생항 경우 예외 처리가 하나 있울 시 메소드를 void로 작성한다.
	//예외가 아닌 실패일 경우 상수 값으로 리턴 값을 받는다.
	public static final int JOIN_SUCCESS=0;
	public static final int JOIN_FAIL=1;
	
	public static final int LOGIN_SUCCESS=0;
	public static final int LOGIN_FAIL_USER_ID=1;
	public static final int LOGIN_FAIL_USER_PW=2;	

	public static final int LOGOUT_SUCCESS=0;
	public static final int LOGOUT_FAIL=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int DROPOUT_SUCCESS=0;
	public static final int DROPOUT_FAIL=1;
	
	@Autowired
	private UserDao userDao;
	
	public int join(User user){
		//예외처리를 하면 안된다.
		userDao.insert(user);
		return JOIN_SUCCESS;
	}
	
	public int login(String user_id, String user_pw){
		
		//회원 로그인
		User user = userDao.selectByUser_id(user_id);//사용자가 작성한 아이디로 DB에 있는 회원정보를 가져온다.
		if (user == null) {
			//디비에 멤버가 없다.
			return LOGIN_FAIL_USER_ID;
		} 
		
		if(user.getUser_pw().equals(user_pw) == false){
			//디비에 있는 비밀번호와 다름.
			return LOGIN_FAIL_USER_PW;
		}
		
		return LOGIN_SUCCESS;
	}
	
	public int logout(String user_id){
		//회원 로그아웃
		return LOGOUT_SUCCESS;
	}
	
	public String findUser_id(String user_email){
		//회원 아이디 찾기
		return userDao.selectByUser_email(user_email);
	}
	
	
	public String findUser_pw(String user_id, String user_email){
		//회원 패스워드 찾기
		User user = userDao.selectByUser_id(user_id);
		if(user == null) return null;
		if(user.getUser_email().equals(user_email) == false) return null;
		return user.getUser_pw();
	}
	
	public User info(String user_id,String user_pw){
		//회원 정보
		User user = userDao.selectByUser_id(user_id);
		if (user.getUser_pw().equals(user_pw) == false) return null;
		
		return user;
		
	}
	public int modify(User user){
		//1027
		//회원 수정
		User dbUser = userDao.selectByUser_id(user.getUser_id());//db에 있는 member를 가져옴
		if (dbUser.getUser_pw().equals(user.getUser_pw()) == false) {
			return MODIFY_FAIL;
		}//비밀번호 체크
		
		int row = userDao.update(user);
		if(row != 1) {return MODIFY_FAIL;}
		return MODIFY_SUCCESS;
	}
	public int dropout(String user_id, String user_pw){
		//회원 탈퇴
		User user = userDao.selectByUser_id(user_id);
		if (user.getUser_pw().equals(user_pw) == false) {return DROPOUT_FAIL;}
		userDao.delete(user_id);
		logout(user_id);
		
		return DROPOUT_SUCCESS;
	}
	
	public boolean isUser_id(String user_id){
		//기존 회원 아이디 있는지 체크
		User user = userDao.selectByUser_id(user_id);
		if (user==null) {
			return false;
		}//기존 회원 아이디가 없다.
		return true;
	}	
}
