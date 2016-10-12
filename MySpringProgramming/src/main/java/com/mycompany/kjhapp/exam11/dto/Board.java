package com.mycompany.kjhapp.exam11.dto;

public class Board {//커맨드 객체.(사실상 VO(Value Object)가 정확)
	
	private String bwriter;
	private String btitle;
	private String bcontent;
	
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	
}
