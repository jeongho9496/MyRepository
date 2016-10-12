package ch06.exam12;

public class StaticMember {
	//0824
	//정적 멤버(클래스)
	//Static(정적) Field
	static String field;
	
	//Static Block -> 제일 먼저 호출(정적 필드, 메소드 사용하기 전에 실행)
	static{
		//정적 필드, 메소드 호출 가능
		System.out.println("static Block 실행");
		field = "자바";
	}
	
	//Static Method
	static void method(){
		
	}
	
	//static -> 객체 생성 없이 (new...) 사용할수 있음
}
