package ch08.exam03;

public class Example {
	// 0831
	public static void main(String[] args) {
		
		Television tv = new Television();	
		RemoteControl rc = tv;
		rc.setMute(true);					//default method -> 객체가 있어야 실행 가능
		rc.setVolume(200);
		
		RemoteControl.changeBattery();
	}

}
