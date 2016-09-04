package ch08.exam06;

public class DriverExample {
	// 0831
	public static void main(String[] args) {
		Driver driver = new Driver();	//객체생성
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.Driver(bus);
		driver.Driver(taxi);
	}
}
