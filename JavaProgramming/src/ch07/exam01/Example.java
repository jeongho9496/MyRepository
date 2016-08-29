package ch07.exam01;

public class Example {

	public static void main(String[] args) {
		//0829
		Car car = new Car();
		car.kind = "SUV";
		car.maker = "현대 자동차";
		
		Car car2 = new Car();
		car2.kind = "트럭";
		car2.maker = "기아 자동차";
		
		car.turnOn();
		car.turnOff();
		System.out.println();
		car2.turnOn();
		car2.turnOff();
		
		
	}

}
