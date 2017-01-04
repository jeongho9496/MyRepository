package com.mycompany.myweb.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

//보나 20161110
//승훈 20161116 (etitle추가)

public class Event {
	private int eid;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date estartperiod;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date elastperiod;
	private String etitle;
	private String econtents;
	private MultipartFile photo;
	private String esavedfile;
	private String emimetype;
	private String sid;
	private int mid;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public Date getEstartperiod() {
		return estartperiod;
	}
	public void setEstartperiod(Date estartperiod) {
		this.estartperiod = estartperiod;
	}
	public Date getElastperiod() {
		return elastperiod;
	}
	public void setElastperiod(Date elastperiod) {
		this.elastperiod = elastperiod;
	}
	
	public String getEtitle() {
		return etitle;
	}
	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}
	public String getEcontents() {
		return econtents;
	}
	public void setEcontents(String econtents) {
		this.econtents = econtents;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getEsavedfile() {
		return esavedfile;
	}
	public void setEsavedfile(String esavedfile) {
		this.esavedfile = esavedfile;
	}
	public String getEmimetype() {
		return emimetype;
	}
	public void setEmimetype(String emimetype) {
		this.emimetype = emimetype;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
}
