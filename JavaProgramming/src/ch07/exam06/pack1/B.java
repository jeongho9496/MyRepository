package ch07.exam06.pack1;
//0829
public class B {
	//Field
	/*A a;
	a = new A();*/ //-> 실행 문 이므로 실행 불가
	A a = new A();	//선언문 실행가능
	
	//Constructor
	B(){
		
		A a = new A();	//A a -> 로컬 변수
		a.field = 10;
		a.method();
		
	}
	//Method
	void method(){
		
		A a = new A();	//A a -> 로컬 변수
		
	}
}
