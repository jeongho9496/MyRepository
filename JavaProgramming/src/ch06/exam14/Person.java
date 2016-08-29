package ch06.exam14;

public class Person {
	//0829
	final String nation = "Korean";
	final String ssn;
	String name;
	
	public Person(String ssn, String name){
		this.ssn = ssn;
		this.name = name;
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("123456-123456", "계백");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
//		p1.nation = "미국";
//		p1.ssn = "333333-333333";
		p1.name = "을지문덕";
		System.out.println(p1.name);
	}

}
