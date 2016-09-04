package ch09.exam01;

public class Example {
	//0901
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();	//B클래스의 객체를 실행하려면 A의 객체를 먼저 실행해야 한다.
		A.B b = a.new B();
		
	}

}
