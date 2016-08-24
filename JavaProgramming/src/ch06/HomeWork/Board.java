package ch06.HomeWork;

public class Board {
	int bno;		//게시번호
	String writer;	//작성자
	String title;	//제목
	String content;	//내용
	int count;		//조회수
	
	Board(){}
	Board(int bno, String writer, String title, String content, int count){
		this.bno = bno;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.count = count;
	}
	

}
