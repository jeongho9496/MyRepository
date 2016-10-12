package ch07.exam02;

public class Student extends People {// 자식 클래스
	// 0829
	public int studentNo;

	public Student(String name, String ssn, int studentNo) {
		super(name, ssn);
		this.studentNo = studentNo;
	}
}
