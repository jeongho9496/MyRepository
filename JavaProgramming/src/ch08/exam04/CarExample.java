package ch08.exam04;

public class CarExample {
	// 0831
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car();
		
		myCar.run();
		
//		myCar.frontLeftTire = new KumHoTire();
//		myCar.frontRightTire = new KumHoTire();
		myCar.tires[0] = new KumHoTire();
		myCar.tires[1] = new KumHoTire();
		
		myCar.run();
	}

}
