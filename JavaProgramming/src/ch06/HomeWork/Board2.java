package ch06.HomeWork;

public class Board2 {
	//0829 vo class
	private int bno;
	private String writer;
	private String title;
	private String content;
	private int count;
	
	public Board2(int bno, String writer, String title, String content, int count) {
		// TODO Auto-generated constructor stub
		this.bno = bno;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.count = count;
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	

}
