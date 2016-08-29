package ch07.exam05;

public class Machine {
	//0829
	
	public void work(){
		System.out.println("Machine-work() 실행됨");
	}
	
	public final void powerOn(){	//final 메소드 -> 해당 메소드가 최종적인 메소드 이다 -> 자식쪽에서 재정의(overriding)할수 없다. 즉 상속불가!
		System.out.println("전원을 연결 합니다.");
	}
	
	public void powerOff(){
		System.out.println("전원을 끊습니다.");
	}
	
}
