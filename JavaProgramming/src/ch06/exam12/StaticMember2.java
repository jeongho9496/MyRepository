package ch06.exam12;

public class StaticMember2 {
	//0829
	//정적 멤버(클래스)
	//Static(정적) Field
	static String field;
	String field2;	//인스턴스 필드
	
	//Static Block -> 제일 먼저 호출(정적 필드, 메소드 사용하기 전에 실행)
	static{
		//정적 필드, 메소드 호출 가능
		System.out.println("static Block 실행");
		field = "자바";
		
		StaticMember2 st2 = new StaticMember2();
		st2.field2 = "인스턴스 필드";
		
		System.out.println(st2.field2);
//		field2 = "자바"; -> 인스턴스 필드 이므로 객체 생성해야만 실행가능 static는 객체가 필요 없으므로 실행 불가
	}
	
	//Static Method
	static void method(){
		field = "자바";
//		field2 = "자바"; -> 겍체가 없으므로 실행 불가
	}
	
	void method2(){
		field = "자바";	//가능 static로 생성된 필드나 메소드는 객체 생성 되도 사용할 수 있다.
		field2 = "자바";	//가능
	}
	
	public static void main(String[] args) {
		//실행 클래스 -> 클래스 멤버에 속하지않음 jvm에 의해서 자바를 실행 시킬때 사용됨 즉 단지 실행을 위해서 사용된다.
		//main 클래스도 static 임 즉 인스턴스 필드나 메소드는 생성자로 불러서 사용 해야 한다.
		
		field = "자바";
//		field2 = "자바";
		
		method();
//		method2();
		
		StaticMember2 sm = new StaticMember2();
		sm.field2 = "자바";
		sm.method2();
	}
}
