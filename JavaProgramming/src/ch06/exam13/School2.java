package ch06.exam13;

public class School2 {
	//0829
	//Field
	private static School2 singleton = new School2();
	
	//Constructor
	private School2(){
		
	}
	
	//Method
	static School2 getInstance() {
		return singleton;
	}
}
