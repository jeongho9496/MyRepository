package ch06.exam08;

public class Calculator {
	//0824
	
	// Field
	// Constructor
	// Method
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