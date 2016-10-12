package ch06.exam03;

public class FieldInitValueExample {	//main이 있으므로 실행클래스

	public static void main(String[] args) {
		
		FieldInitValue fiv = new FieldInitValue();
		
		System.out.println("byteField : "+fiv.byteField);
		System.out.println("shortField : "+fiv.shortField);
		System.out.println("intField : "+fiv.intField);
		System.out.println("longField : "+fiv.longField);
		System.out.println("booleanField : "+fiv.booleanField);
		System.out.println("charField : "+fiv.charField);
		System.out.println("floatField : "+fiv.floatField);
		System.out.println("doubleField : "+fiv.doubleField);
		System.out.println("arrField : "+fiv.arrField);
		System.out.println("referenceField : "+fiv.referenceField);
	
		fiv.run();
	}

}
