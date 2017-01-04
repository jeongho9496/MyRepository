package com.mycompany.myweb.dto;

//이명진
public class OrderItem {
	private int oid;//OrderItem 테이블 아이디
	private String ogid;//주문 아이디(참조)
	private int mid;//메뉴 아이디
	private int ordercount;//품목 수량
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOgid() {
		return ogid;
	}
	public void setOgid(String ogid) {
		this.ogid = ogid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}
	
	
	
	
}
