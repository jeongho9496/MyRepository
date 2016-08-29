package ch07.exam01;

public class Machine {
	//0829
	//Field
	public String kind;
	public String maker;
	
	
	//Constructor
	public Machine(){
		System.out.println("Machine() 실행됨");
	}
	//Method
	public void turnOn(){
		System.out.println(maker + " : " + kind + " powerOn");
	}
	
	public void turnOff(){
		System.out.println(maker + " : " + kind + " powerOff");
		
	}
}
