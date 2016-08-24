package ch06.exam06;

public class CarExample {
	public static void main(String[] args) {
		Car car1 = new Car();
		car1.model = "제네시스";
		System.out.println(car1.company);
		System.out.println(car1.model);
		System.out.println();
		
		Car car2 = new Car("아반떼");
		System.out.println(car2.company);
		System.out.println(car2.model);
		System.out.println();
		
		Car car3 = new Car("모닝", "blue");
		System.out.println(car3.company);
		System.out.println(car3.model);
		System.out.println(car3.color);
		System.out.println();
		
		Car car4 = new Car("제네시스 쿠페", "sliver",350);
		System.out.println(car4.company);
		System.out.println(car4.model);
		System.out.println(car4.color);
		System.out.println(car4.maxSpeed);
		
	}

}
