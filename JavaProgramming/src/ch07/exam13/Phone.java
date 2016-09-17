package ch07.exam13;

public abstract class Phone {
	public String number;
	public abstract void ring();//추상메소드 형태만 있고 자식클래스에서 무조건 재정의 하여 사용해야 한다.
	
	public void sendVoice(){
		System.out.println("음성을 전송합니다.");
	}
	
	public void receiveVoice(){
		System.out.println("음성을 수신합니다.");
	}
	
}
