package ch09.exam05;

public class A {
	
	int field = 0; 
	static int field2 =2;
	
	B b1 = new B();		//사용가능
	static B b = new B();//사용가능
	
	public A(){
//		B b = new B();
	}
	
	void method(){
		B b = new B();
	}
	
	static void method2(){
		B b = new B();
	}
	
	public static class B{	//A객체없이 실행가능하므로 객체 있는 곳 이든 없는 곳이든 사용 가능하다.
		//static가 들어간 멤버는 객체 없이 실행가능 하게 된다. 그러므로 중첩 클래스가 인스턴스이면 상위 클래스 객체가 있을때 실행 할 수 있는 클래스가 되므로 멤버들은 static(정적멤버) 올수 없다.
		int field1;
		static int field2;
		void method1(){
			//field = 2;	// int field = 0은 A객체가 있어야 하므로 실행불가 
			field2 = 2;	// static이므로 실행가능	
		}
		static void method2(){}
		
	}	
}
