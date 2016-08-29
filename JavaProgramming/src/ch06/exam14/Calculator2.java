package ch06.exam14;

public class Calculator2 {
	//0829
	//Field
	final int FIELD2;		//instance 필드 final 최종적인 -> final은 초기 값을 주어야 한다(한번 들어간 값은 바꿀수 없다) 값을 주지 않으면 생성자에서 마지막으로 한번 초기화 할수 있다.
	public Calculator2() {
		FIELD2 = 5;
	}
	
	static final int FIELD4;//static 필드 final은 초기 값을 주어야 한다(한번 들어간 값은 바꿀수 없다)값을 주지 않으면 static block에서 마지막으로 한번 초기화 할수 있다. 공용적으로 사용해야 할 때 사용.
	static{
		FIELD4 = 5;
	}
	//Constructor
	//Method
}
