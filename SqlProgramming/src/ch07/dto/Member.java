package ch07.dto;

import java.util.Date;

public class Member {
	//1018
	private String mid;
	private String mname;
	private int mage;
	private Date mbrith;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMage() {
		return mage;
	}
	public void setMage(int mage) {
		this.mage = mage;
	}
	public Date getMbrith() {
		return mbrith;
	}
	public void setMbrith(Date mbrith) {
		this.mbrith = mbrith;
	}
	
	
}
