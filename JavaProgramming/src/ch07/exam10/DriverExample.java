package ch07.exam10;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		//다형성
		driver.dirver(new Vehicle());
		driver.dirver(new Bus());
		driver.dirver(new Taxi());
		

	}

}
