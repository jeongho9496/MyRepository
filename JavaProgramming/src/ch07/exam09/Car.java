package ch07.exam09;

public class Car {
	//0830
	/*Tire frontLeftTire = new Tire("앞왼쪽", 6);
	Tire frontRightTire = new Tire("앞오른쪽", 2);
	Tire backLeftTire = new Tire("뒤왼쪽", 3);
	Tire backRightTire = new Tire("뒤오른쪽", 4);*/
	
	Tire[] tires = {
		new Tire("앞왼쪽", 6),
		new Tire("앞오른쪽", 2),
		new Tire("뒤왼쪽", 3),
		new Tire("뒤오른쪽", 4)
	};	//Tire타입 객체 배열 필드
	
	int run(){
		System.out.println("[자동차가 달립니다.]");
		/*if (frontLeftTire.roll() == false) {
			stop();
			return 1;
		}
		if (frontRightTire.roll() == false) {
			stop();
			return 2;
		}
		if (backLeftTire.roll() == false) {
			stop();
			return 3;
		}
		if (backRightTire.roll() == false) {
			stop();
			return 4;
		}*/
		
		for (int i = 0; i < tires.length; i++) {
			if (tires[i].roll() == false) {
				stop();
				return i+1;//실행클래스에서 타이어 교체하기 위해 리턴값 반환
			}
		}
		return 0;
	}

	void stop() {
		// TODO Auto-generated method stub
		System.out.println("[자동차가 멈춤니다.]");
	}
}
