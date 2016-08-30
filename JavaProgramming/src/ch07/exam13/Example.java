package ch07.exam13;

public class Example {

	public static void main(String[] args) {
		//Phone phone = new Phone();	//객체 생성 불가
		SmartPhone p1 = new SmartPhone();
		p1.number = "010-4728-9496";
		p1.ring();
		p1.sendVoice();
		p1.receiveVoice();
		p1.internet();
		
		HomePhone p2 = new HomePhone();
		p2.number = "02-123-1234";
		p2.ring();
		p2.sendVoice();
		p2.receiveVoice();
		p2.address = "서울시 송파구 가락도 IT벤처 타워 서관 12층";

	}

}
