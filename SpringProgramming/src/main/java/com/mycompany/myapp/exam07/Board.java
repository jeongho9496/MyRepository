package com.mycompany.myapp.exam07;

public class Board {//커맨드 객체.(사실상 VO(Value Object)가 정확)
	//1006
	private int bno;//.jsp의 parameter 값과 무조건 일치해야한다. 순서가 바뀌어도 프레임워크가 자동으로 값은 이름을 찾아 값을 대입한다.
	private String title;
	private String content;
	private int hitcount;
	
	//getter, setter
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	
	
}
