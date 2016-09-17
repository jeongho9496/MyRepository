package ch06.exam03;

public class Korean {
	
	String nation = "대한민국";
	String name;
	String ssn;
	
	public Korean(String name, String ssn) {
		this.name = name;	//필드값을 외부에서 받은 매개변수의 값으로 초기화 한다.
		this.ssn = ssn;
//		
//		System.out.println("국적 : " + nation);
//		System.out.println("이름 : " + name);
//		System.out.println("주민 번호 : " + ssn);
	}
}
