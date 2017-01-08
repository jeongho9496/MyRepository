package com.mycompany.empweb.dto;

import org.springframework.web.multipart.MultipartFile;

public class Store {
	//김정호 1114 수정
	private String sid;		//매장등록 회원아이디(아이디)
	private String semail;	//회원이메일(디비 저장할 주소)
	private String semail1; //회원 이메일(아이디)
	private String semail2; //회원 이메일(@주소)
	
	private String spw;		//회원비밀번호
	private String sname;	//매장이름
	private String slocal;	//매장 지점명
	private String saddr;	//매장 주소
	private String stel;	//매장 전화번호
	
	private String sopen;	//매장 오픈 시간
	private String sclosed;	//매장 닫는 시간
	
	private int sbeacon;	//비콘 번호
	
	private MultipartFile[] sphoto; //매장 사진 
	
	 
	public MultipartFile[] getSphoto() {
		return sphoto;
	}
	public void setSphoto(MultipartFile[] sphoto) {
		this.sphoto = sphoto;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSemail1() {
		return semail1;
	}
	public void setSemail1(String semail1) {
		this.semail1 = semail1;
	}
	public String getSemail2() {
		return semail2;
	}
	public void setSemail2(String semail2) {
		this.semail2 = semail2;
	}
	public String getSpw() {
		return spw;
	}
	public void setSpw(String spw) {
		this.spw = spw;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSlocal() {
		return slocal;
	}
	public void setSlocal(String slocal) {
		this.slocal = slocal;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	public String getSopen() {
		return sopen;
	}
	public void setSopen(String sopen) {
		this.sopen = sopen;
	}
	public String getSclosed() {
		return sclosed;
	}
	public void setSclosed(String sclosed) {
		this.sclosed = sclosed;
	}
	public int getSbeacon() {
		return sbeacon;
	}
	public void setSbeacon(int sbeacon) {
		this.sbeacon = sbeacon;
	}

	
}
