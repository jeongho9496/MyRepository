package ch08.exam07;

public class DriverExample {

	public static void main(String[] args) {
//		Vehicle vehicle = new Bus();
		
//		vehicle.run();	//bus의 checkFare 사용 못함
		
//		Bus bus = (Bus)vehicle;	//강제 타입 변환
//		bus.checkFare();		//메소드 사용 가능
//		bus.run();
		
		Driver driver = new Driver();
		driver.drive(new Bus());
		driver.drive(new Taxi());
	}

}
