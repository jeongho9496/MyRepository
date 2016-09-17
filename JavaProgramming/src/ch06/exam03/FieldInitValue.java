package ch06.exam03;

public class FieldInitValue {	//라이브러리 클래스
	//필드
	byte byteField;
	short shortField;
	int intField;
	long longField;
	
	boolean booleanField;
	char charField;
	
	float floatField;
	double doubleField;
	
	int[] arrField;
	String referenceField;
	
	public FieldInitValue() {
		System.out.println("오잉");
//		String a = "asdf";
		String a = "1234";
		Integer.valueOf(a);
	}
	
	void run(){
		System.out.println("실행됨");
	}
}
