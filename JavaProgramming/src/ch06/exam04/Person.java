package ch06.exam04;

public class Person {
	//0824
	//Field
	String name;
	String gender;
	int age;
	double height;
	boolean married;
	
	//Constructor
	Person(String name, String gender, int age, double height){	//매개변수는 필드명과 같게 해야 가독성이 좋다. 값을 받아서 필드 값을 초기화한다 
		this.name = name;	//this : 현재 나의 객체 필드값
		this.gender = gender;
		this.age = age;
		this.height = height;
	}
	
	//Method
}
