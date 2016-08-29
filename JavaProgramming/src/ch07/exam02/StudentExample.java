package ch07.exam02;

public class StudentExample {
	public static void main(String[] args) {
		Student student = new Student("김정호", "891006-1******", 1);
		System.out.println("name : " + student.name);
		System.out.println("ssn : " + student.ssn);
		System.out.println("studentNo : " + student.studentNo);
	}

}
