package ch07.exam13;

public abstract class Phone {
	public String number;
	public abstract void ring();
	
	public void sendVoice(){
		System.out.println("음성을 전송합니다.");
	}
	
	public void receiveVoice(){
		System.out.println("음성을 수신합니다.");
	}
	
}
