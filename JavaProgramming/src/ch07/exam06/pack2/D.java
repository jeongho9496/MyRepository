package ch07.exam06.pack2;

import ch07.exam06.pack1.A;

//0829
public class D extends A{
	//protected
	//Field
	//A a = new A(); -> 상속과 관련되있지 않다.
	
	//Constructor
	D(){
		super();		// 부모 생성자 호출
		this.field = 5;	// 부모 A 클래스에서 물려 받은 필드
		this.method();	// 부모 A 클래스에서 물려 받은 메소드
	}
	
	//Method
	
	
}
