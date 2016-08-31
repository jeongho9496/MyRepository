package ch08.exam06;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.Driver(bus);
		driver.Driver(taxi);
	}
}
