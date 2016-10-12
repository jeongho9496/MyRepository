package ch06.exam07;

public class Board {
	//0824
	// Field
	int bno;
	String title;
	String content;
	String writer;
	int hitcount;

	// Constructor Overloading 생성자가 여러개 있는 경우를 말함
	// 조건 매개변수의 수와 매개변수의 타입이 달라야 한다.
	Board() {
	}

	Board(int bno) {
		//this => 객체 자기 자신
		//매개변수조건을 만족하는 생성자 호출
		//this 생성자 위에 다른 코드들은 오면 안된다.
		this(bno, null, null, null, 0);
		//초기화 코드를 줄이기 위해 사용
	}

	Board(int bno, String title) {
		this(bno, title, null, null, 0);
		
	}
	
	Board(String title, int bno) {
//		this(bno, title, null, null, 0);
	}

	Board(int bno, String title, String content) {
		this(bno, title, content, null, 0);
		
	}
	
	Board(int bno, String title, String content, String writer) {
		this(bno, title, content, writer, 0);
		
	}
	
	Board(int bno, String title, String content, String writer, int hitcount) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hitcount = hitcount;
		
	}	
	// 객체 생성하는 방법을 6가지로 만들때 매개변수 값을 달리 하여 상황에 맞는 객체를 설정한다.
	// Method
}
