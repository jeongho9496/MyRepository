package ch08.exam02;

public interface RemoteControl {
	//0831
	//Constant(상수) -> 인터페이스에서 필드는 반드시 상수만 온다. public static final 안써도 자동으로 추가해 준다.
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//Abstract Method(추상 메소드)	-> public abstract 자동 생성. 객체가 있어야 사용가능
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	//Default Method(디폴트 메소드) -> default 반드시 작성. public 자동 생성
	default void setMute(boolean mute){
		if (mute) {
			
			System.out.println("무음 처리합니다.");
		
		} else {

			System.out.println("무음 해제합니다.");
			
		}
	}
	
	//Static Method(정적 메소드) -> public 자동생성
	static void changeBattery(){
		System.out.println("건전지를 교체합니다.");
	}
}
