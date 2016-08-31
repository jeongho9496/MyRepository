package ch08.exam01;

public class Example {
	//0831
	public static void powerOn(RemoteControl rc){	//audio, tv 객체에 따라 값이 변동 됨 => 다형성
		rc.turnOn();
	}
	
	
	
	public static void main(String[] args) {
		
		int max = RemoteControl.MAX_VOLUME;	//인터페이스 상수 객체 생성 없이 접근가능
		int min = RemoteControl.MIN_VOLUME;
		
		//RemoteControl.turnOn();
		//RemoteControl.setVolume(int volume);	//추상메소드 객체 생성 없이 접근 불가능
		//RemoteControl.setMute(boolean mute);	//default 메소드 객체 생성 없이 접근 불가능

		RemoteControl.changeBattery();		//인터페이스 정적 메소드 객체 생성 없이 사용가능
		
		Television tv = new Television();	//객체 직접이용
		tv.turnOn();
		
		RemoteControl rc = new Television();	//인터페이스 변수에 티비의 객체를 전달
		rc.turnOn();
		rc.turnOff();
		
		Audio audio = new Audio();
		
		rc = audio;
		rc.turnOn();
		rc.turnOff();
		
		System.out.println("------------------------------------------------");
		powerOn(new Television());
		System.out.println("------------------------------------------------");
		powerOn(new Audio());
		
	}

}
