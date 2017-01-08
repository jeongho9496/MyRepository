package com.mycompany.empweb.dto;

import org.springframework.web.multipart.MultipartFile;

public class Sphoto {
	
	private int spic_id;			//sphoto id(시퀀스)
	private String spic_savedfile;	//매장 사진 세이브 파일
	private String spic_mimetype;	//매장 사진 확장자
	private MultipartFile[] photo;// 파일 정보를 대입 받음
	private String sid;				//매장 아이디(시퀀스)
	
	
	public MultipartFile[] getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile[] photo) {
		this.photo = photo;
	}
	public int getSpic_id() {
		return spic_id;
	}
	public void setSpic_id(int spic_id) {
		this.spic_id = spic_id;
	}
	public String getSpic_savedfile() {
		return spic_savedfile;
	}
	public void setSpic_savedfile(String spic_savedfile) {
		this.spic_savedfile = spic_savedfile;
	}
	public String getSpic_mimetype() {
		return spic_mimetype;
	}
	public void setSpic_mimetype(String spic_mimetype) {
		this.spic_mimetype = spic_mimetype;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	
}
