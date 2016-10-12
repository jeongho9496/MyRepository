package ch06.exam01;

public class Example {
	//0823
	public static void main(String[] args) {	//실행을 하기 위해서 구현한 클래스, 프로그램 실행시 제일 처음에 실행하는 곳이므로 하나의 실행클래스만 필요하다.(설계도라 불리지 않음)
		
		Car myCar = new Car();	//car 객체 생성
		Tire myTire = new Tire();	//tire 객체 생성
		
		int a  = myCar.run(100, 200);
		
//		int b = myCar.m
		
		System.out.println(a);
	
	}

}
