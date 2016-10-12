package ch06.exam16.pack1;

public class A {
	//0829
	//Field
	private int field1;	//클래스 안에서 사용 가능
	int field2;			//같은 패키지 내에서 사용 가능
	public int field3;	//전체 사용가능
	
	//Constructor
	private A(){}						
	A(int field1){}
	public A(int field1, int field2){}
	
	//Method
	private void method1(){}
	void method2(){}
	public void method3(){}
}
