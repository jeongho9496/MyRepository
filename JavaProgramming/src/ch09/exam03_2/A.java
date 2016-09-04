package ch09.exam03_2;

public class A {
	
	A() {	//기본 생성자
		System.out.println("A객체가 실행됨.");
	}
	
	class B{	//멤버 클래스 생성 클래스 안에 인스턴스 메소드, 필드만 사용가능
		B() {
			System.out.println("B객체가 실행됨");}
		int field1;
		void method1(){}
	}
	
	static class C{//정적 클래스 생성 인스턴스,정적 필드 메소드 모두 올수 있다.
		C() {
			System.out.println("C객체가 생성됨");
		}
		int field1;
		static int field2;
		void method1(){}
		static void method2(){}
		
	}
	
	void method(){	
		class D{	//로컬 클래스 생성 (객체 메소드 안의 클래스) 내부에 인스턴스 필드와 메소드만 올수 있다. 메소드 실행 할때 메소드 내에 객체 생성
			public D() {
				// TODO Auto-generated constructor stub
				System.out.println("D객체가 실행됨.");
			}
			int field1;
			void method1(){
				
			}
		}
		
		D d = new D();	//메소드 내에 객체 생성
		d.field1 = 3;
		d.method1();
	}
}
