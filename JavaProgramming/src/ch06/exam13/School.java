package ch06.exam13;

public class School {
	//0829
	//Field
	private static School singleton = new School();	//static으로 School 타입 필드를 설정하고 자기자신을 생성자로 불러온다.
	
	//Constructor
	private School(){	//private -> 접근 제한자 외부에서 접근하지 못하게 한다. 즉 외부에서 생성자 호출을 못하게 막는다.
		
	}
	
	//Method
	static School getInstance() {
		return singleton;	//singleton으로 생성된 객체 번지의 값을 리턴으로 받는다. 그러면 외부에서 메소드 호출시 한번 지정된 private static 필드의 값을 사용 할 수 있다.
	}
}
