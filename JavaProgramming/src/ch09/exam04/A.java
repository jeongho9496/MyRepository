package ch09.exam04;

public class A {
	//0901
	int field;

//	static B b = new B();	//static(정적멤버)는 객체 생성 없이 실행할수 있지만 B 클래스는 A객체가 생성되어야 실행가능 하기 때문에 문법적으로 맞지 않다.
	
	public A(){	//생성자가 실행되기 전에 이미 객체가 만들어짐(빈 객체) 생성자는 만들어진 빈객체를 사용하기 위해 준비를 하는 것.
		this.field = field;
		
		B b = new B();	//객체가 먼저 실행 되있으므로 사용할수 있다.
	}
	
	void method(){
		B b = new B();
	}
	
	static void method2(){
//		B b = new B();	//static이므로 객체가 없이도 실행해야 하는 내용이 와야 하는데 B는 A객체에서 실행되기 때문에 선언 할수 없다
	}
	
	public class B{
		int field1;
		void method1(){}
	}	
}
