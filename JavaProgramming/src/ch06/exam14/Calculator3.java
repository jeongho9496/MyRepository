package ch06.exam14;

public class Calculator3 {
	//0829
	//Field
	final int FIELD2;		//instance 필드 final 최종적인 -> final은 초기 값을 주어야 한다(한번 들어간 값은 바꿀수 없다) 값을 주지 않으면 생성자에서 마지막으로 한번 초기화 할수 있다.
	
	public Calculator3(int field2) {
		this.FIELD2 = field2;	//객체 마다 값이 다를때 사용 객체 a : 5 객체 B : 10 이 한번 씩만 필요한경우 //ex) 주민 번호, 아이디
	}
	
	//Constructor
	//Method
	
	public static void main(String[] args) {
		Calculator3 ca1 = new Calculator3(5);
		Calculator3 ca2 = new Calculator3(7);
		
		System.out.println(ca1.FIELD2);
		System.out.println(ca2.FIELD2);
	}
}
