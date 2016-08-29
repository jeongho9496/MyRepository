package ch06.exam14;

public class Calculator4 {
	//0829
	//Field
	
	static final double PI = 3.14;
	//static 필드 final은 초기 값을 주어야 한다(한번 들어간 값은 바꿀수 없다)값을 주지 않으면 static block에서 마지막으로 한번 초기화 할수 있다.
	//공용적으로 사용해야 할 때 사용. //상수는 대문자로 하느게 관례
	static{

	}
	//Constructor
	//Method
	
	public static void main(String[] args) {
		double pi = Calculator4.PI;
	}
}
