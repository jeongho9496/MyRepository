package ch08.exam07;

public class Driver {	//운전자 클래스
	//0831
	//Field
	//Constructor
	//Method
	public void drive(Vehicle vehicle){	//인터페이스 타입 매개변수
		if (vehicle instanceof Bus) {
			
			Bus bus = (Bus)vehicle;
			bus.checkFare();
		}else {
			System.out.println("택시는 공짜");
		}
		vehicle.run();
		
	}
}
