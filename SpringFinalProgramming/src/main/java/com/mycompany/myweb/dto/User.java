package com.mycompany.myweb.dto;

public class User {
	
	private String user_id;		//유저 아이디(아이디,식별)
	private String user_email;	//유저 이메일
	private String user_pw;		//유저 패스워드
	private String user_tel;	//유저 번호
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	
	
}
