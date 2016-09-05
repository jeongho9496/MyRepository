package ch11.exam10;

public class StringCharAtExample {
	//0905
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ssn = "010472-1496123";
		char gender = ssn.charAt(7);
		switch (gender) {
		case '1':
		case '3':
			System.out.println("남자");
			break;
		case '2':
		case '4':
			System.out.println("여자");
			break;
			
		}
//		System.out.println(ssn.charAt(7));	//지정한 인덱스 번호 리턴
		
	}

}
