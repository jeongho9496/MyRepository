package com.mycompany.myweb.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StoreEvent {
	
	private int bmajor;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private String estartperiod;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private String elastperiod;
    private String etitle;
    private String econtents;
    /*private String esavedfile;
    private String emimetype;*/
    private String sid;
    private int mid;
    private String imageLarge;
    
    
    
	public String getImageLarge() {
		return imageLarge;
	}
	public void setImageLarge(String imageLarge) {
		this.imageLarge = imageLarge;
	}
	public StoreEvent(int bmajor, String estartperiod, String elastperiod, String etitle, String econtents, String sid, String imageLarge) {
		//노티 데이터 파일
		this.bmajor = bmajor;
		this.estartperiod = estartperiod;
		this.elastperiod = elastperiod;
		this.etitle = etitle;
		this.econtents = econtents;
		this.sid = sid;
		this.imageLarge = imageLarge;
	}
	public int getBmajor() {
		return bmajor;
	}
	public void setBmajor(int bmajor) {
		this.bmajor = bmajor;
	}
	public String getEstartperiod() {
		return estartperiod;
	}
	public void setEstartperiod(String estartperiod) {
		this.estartperiod = estartperiod;
	}
	public String getElastperiod() {
		return elastperiod;
	}
	public void setElastperiod(String elastperiod) {
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
	/*public String getEsavedfile() {
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
	}*/
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
