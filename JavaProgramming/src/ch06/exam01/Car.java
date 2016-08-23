package ch06.exam01;	//package 선언

public class Car {	//다른 클래스에서 이용할 목적으로 설계되있는 클래스 => 라이브러리용 클래스(설계도)
	//0823
	public int run(int a, int b){
		int c = a+b;
		return c;
	}
	private int minus(int x, int y){
		int c = x-y;
		return c;
	}
}
