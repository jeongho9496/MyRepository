package ch07.exam07;

public class Example {
	public static void main(String[] args) {
		//0830
		A a;
		a = new B();
		a = new C();
		
		B b;
		b = new B();
//		b = new C(); -> 상관 성이 없으므로 실행 안됨
	}
}
