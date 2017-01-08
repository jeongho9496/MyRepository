package com.mycompany.empweb.dto;

import org.springframework.web.multipart.MultipartFile;
// 보나 
// 20161117 최종 수정
public class Menu {
	private int mid;
	private String mgroup;
	private String mname;
	private String hot_ice;
	private int mprice;
	private String mcontents;
	private MultipartFile photo;
	private String msavedfile;
	private String mmimetype;
	private String sid;
	
	public Menu(){};
	
	//김정호 안드로이드 테스트
	public Menu(int mid, String mgroup, String mname, String hot_ice, int mprice, String mcontents, String msavedfile,
			String sid) {
		super();
		this.mid = mid;
		this.mgroup = mgroup;
		this.mname = mname;
		this.hot_ice = hot_ice;
		this.mprice = mprice;
		this.mcontents = mcontents;
		this.msavedfile = msavedfile;
		this.sid = sid;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMgroup() {
		return mgroup;
	}
	public void setMgroup(String mgroup) {
		this.mgroup = mgroup;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getHot_ice() {
		return hot_ice;
	}
	public void setHot_ice(String hot_ice) {
		this.hot_ice = hot_ice;
	}
	public int getMprice() {
		return mprice;
	}
	public void setMprice(int mprice) {
		this.mprice = mprice;
	}
	public String getMcontents() {
		return mcontents;
	}
	public void setMcontents(String mcontents) {
		this.mcontents = mcontents;		
	}
	
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getMsavedfile() {
		return msavedfile;
	}
	public void setMsavedfile(String msavedfile) {
		this.msavedfile = msavedfile;
	}
	public String getMmimetype() {
		return mmimetype;
	}
	public void setMmimetype(String mmimetype) {
		this.mmimetype = mmimetype;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	
}
