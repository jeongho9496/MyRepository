package ch07.exam12;

public class TheaterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Theater cgv = new Theater();
		
		Adult a = new Adult();
		a.ssn = "123456-1234567";
		Student s = new Student();
		s.sno = "2083518";
		
		cgv.check(a);
		cgv.check(s);

	}

}
