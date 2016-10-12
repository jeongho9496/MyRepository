package com.mycompany.myapp.exam11.dto;

public class Board {
	//1012	Spring 관리 객체가 아니므로 (의존 객체가 아님) @Component를 붙히지 않는다.(매개변수로만 사용)
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
