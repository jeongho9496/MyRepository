package ch06.exam07;

public class Car {
	//0824
	String company = "현대 자동차";
	String model;
	String color;
	int maxSpeed;
	
	Car(){}
	
	Car(String model){
		this(model, null, 0);
	}
	Car(String model, String color){
		this(model, color, 0);
	}
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
