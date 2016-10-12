package com.mycompany.myapp.exam04;

public class Member {
	//0929
	private String mid;
	private String mname;
	private int mpassword;
	private String memail;
	private String mtel;
	private String mjob;
	private String[] mskill;	//필드에 여러개가 들어가는 경우 배열로 생성
	private String maddress1;
	private String maddress2;
	private String mbirth;
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
	public int getMpassword() {
		return mpassword;
	}
	public void setMpassword(int mpassword) {
		this.mpassword = mpassword;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getMjob() {
		return mjob;
	}
	public void setMjob(String mjob) {
		this.mjob = mjob;
	}
	public String[] getMskill() {
		return mskill;
	}
	public void setMskill(String[] mskill) {
		this.mskill = mskill;
	}
	public String getMaddress1() {
		return maddress1;
	}
	public void setMaddress1(String maddress1) {
		this.maddress1 = maddress1;
	}
	public String getMaddress2() {
		return maddress2;
	}
	public void setMaddress2(String maddress2) {
		this.maddress2 = maddress2;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	
}
