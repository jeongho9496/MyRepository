package ch06.HomeWork;

public class Board {
	//0829과제
	private int bno;		//게시번호
	private String writer;	//작성자
	private String title;	//제목
	private String content;	//내용
	private int count;		//조회수
	
	Board(){}
	Board(int bno, String writer, String title, String content, int count){
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
