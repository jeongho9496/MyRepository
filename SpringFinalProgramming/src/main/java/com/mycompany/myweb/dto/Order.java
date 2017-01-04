package com.mycompany.myweb.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//이명진
public class Order {
	
	private String ogid;//주문 아이디(문자열 기본키)
	private int ogtotalprice;//총 주문 금액
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ogtime;//주문 날짜(중요!)
	private String user_id;//일반 회원 아이디
	private String sid;//매장 회원 아이디
	private String oghowpay;//주문 결재방법
	
	public String getOgid() {
		return ogid;
	}
	public void setOgid(String ogid) {
		this.ogid = ogid;
	}
	public int getOgtotalprice() {
		return ogtotalprice;
	}
	public void setOgtotalprice(int ogtotalprice) {
		this.ogtotalprice = ogtotalprice;
	}
	public Date getOgtime() {
		return ogtime;
	}
	public void setOgtime(Date ogtime) {
		this.ogtime = ogtime;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getOghowpay() {
		return oghowpay;
	}
	public void setOghowpay(String oghowpay) {
		this.oghowpay = oghowpay;
	}
	
	
	
	
}
