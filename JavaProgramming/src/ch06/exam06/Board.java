package ch06.exam06;

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
	Board() {}

	Board(int bno) {}

	Board(int bno, String title) {}
	
	Board(String title, int bno) {}

	Board(int bno, String title, String content) {}
	
	Board(int bno, String title, String content, String writer) {}
	
	Board(int bno, String title, String content, String writer, int hitcount) {}	
	// 객체 생성하는 방법을 6가지로 만들때 매개변수 값을 달리 하여 상황에 맞는 객체를 설정한다.
	// Method
}
