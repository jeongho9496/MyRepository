package ch06.exam08;

public class Calculator {
	//0824
	
	// Field
	// Constructor
	// Method 객체의 동작에 해당하는 중괄호 {}블록을 말한다. 객체간의 데이터 전달의 수단이다. 외부로부터 매개값을 받을 수도 있고, 실행 후 어떤 값을 리턴할 수 있다.
	void powerOn(){
		System.out.println("전원을 켭니다.");
	}
	int plus(int x, int y){
		int result = x+y;
		return result;
	}
	double divide(int x, int y){
		double result = (double)x/(double)y;
		return result;
	}
	void powerOff(){
		System.out.println("전원을 끕니다.");
	}
}
