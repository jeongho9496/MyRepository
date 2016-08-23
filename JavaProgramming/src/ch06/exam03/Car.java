package ch06.exam03;

public class Car {	// 설계도
	//0823
	//Field
	String company = "현대자동차";	//문자열 저장
	
	//Constructor => 객체를 만들때(생성)만 실행
	Car() {	//{} 중괄호 안은 어떤 실행을 하고 있다로 생각
		System.out.println("Car() 실행됨");	//클래스에있는 공통적인 조건이 아닌 해당 클래스에서만 사용 하는 조건을 지정해 줄때 생성자 안에 조건 사용.
//		Integer.parseInt("a");				//ex) 자동차를 설계도에서 만들고 자동차 도색은 그 이후에 각각의 차에 도색한다.
	}
	//Method
	void run(){
		System.out.println("run() 실행됨");
	}
	
}
