package ch09.exam12;

public class AnonymousTest {
	
	//Field
	private RemoteControl rc = new RemoteControl() {//필드 익명 클래스
	};
	
	//Constructor
	public AnonymousTest() {
		RemoteControl rc = new RemoteControl() {	//로컬 변수 익명 클래스
		};
	}
	//Method
	public void method1(RemoteControl rc){
		
	}
	
	public void method2(){
		method1(new RemoteControl(){});	//메소드 매개변수
	}
	
	
	
}
