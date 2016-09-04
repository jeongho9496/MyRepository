package ch08.exam04;

public class Car {
	// 0831
	/*Tire frontLeftTire = new HankookTire();
	Tire frontRightTire = new HankookTire();
	Tire backLeftTire = new HankookTire();
	Tire backRightTire = new HankookTire();
	*/
	
	Tire[] tires = {	//타이어 인터페이스 타입 배열 생성
			new HankookTire(),	//Tire 인터체이스 구형하는 객체
			new HankookTire(),
			new HankookTire(),
			new HankookTire()
	};
	
 	/*void run(){
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
	}*/
	
	void run(){
		for (Tire tire : tires) {	//향상된 for문
			tire.roll();			//해당 객체에서 재정의한 roll 실행
		}
	}
}
