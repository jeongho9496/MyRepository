package ch08.exam01;

public class Television implements RemoteControl {	//구현클래스 생성
	//0831
	@Override	//컴파일러가 검사 하는 것 재정의 -> 인터페이스에 있는 메소드가 정확하게 들어갔는지 검사
	public void turnOn() {	
		//인터페이스는 기본 접근 제한자가 public 이므로 구현체 클래스도 public여야 한다. 좁은 범위인 protected, private, default불가
		System.out.println("티비를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("티비를 끔니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		System.out.println("현재 티비 볼륨: " + volume);
		
	}
	
	@Override
		public void setMute(boolean mute) {
			// TODO Auto-generated method stub
			RemoteControl.super.setMute(mute);
		}
}
