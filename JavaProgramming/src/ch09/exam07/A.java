package ch09.exam07;

public class A { // 클래스 내부에서는 생성자, 필드, 메소드 순서 상관 하지 않는다.
	// 0901
	int field = 5;

	public void method() {
		this.field = 10;	//A 필드 값 초기화
		class B {
			
			int field = 10; // 내부classB의 필드
			
			B() {//B클래스 생성자
				field = 20;
				this.field = 30;//B필드값 초기화
				A.this.field = 40;//A객체의 필드값 초기화
			}
			
		}
		
		B b = new B();
		System.out.println("B의 필드 : " + b.field);
		System.out.println("A의 필드 : " + field);

	}
}
