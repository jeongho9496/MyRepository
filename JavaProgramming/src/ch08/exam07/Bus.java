package ch08.exam07;

public class Bus implements Vehicle{	//인터페이스로 구현하는 클래스
	// 0831
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
	
	public void checkFare() {	//인터페이스와 상관 없는 메소드
		System.out.println("승차 요금을 체크합니다.");
	}
	
}
