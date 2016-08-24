package ch06.exam12;

public class StaticMember {
	//0824
	//Static(정적) Field
	static String field;
	
	//Static Block
	static{
		System.out.println("static Block 실행");
		field = "자바";
	}
	
	//Static Method
	static void method(){
		
	}
}
