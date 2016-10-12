package ch06.exam12;

public class Car {
	//0829
	int speed;
	
	void run(){
		System.out.println(speed + "으로 달립니다.");
	}
	
	public static void main(String[] args) {
		Car myCar = new Car();
		
		for (int i = 10; i <= 100; i += 10) {
			
			myCar.speed = i;
			myCar.run();
			
		}
		
	}
}
