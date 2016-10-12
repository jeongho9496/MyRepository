package ch07.exam12;

public class Theater {
	public void check(Person person){//다른 타입이 들어오면 예외 발생하므로 instanceof로 검사를 해줘야함
		if (person instanceof Adult) {
			Adult adult = (Adult)person;
			System.out.println("주민번호: " + adult.ssn);
			System.out.println("어른");
		}
		
		if (person instanceof Student) {
			Student student = (Student)person;
			System.out.println("학생번호: " + student.sno);
			System.out.println("애기");
		}
	}
}
