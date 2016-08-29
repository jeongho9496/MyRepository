package ch06.exam13;

public class SchoolExample {
	//0829

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		School s1 = new School();
//		School s2 = new School();
		
		School s1 = School.getInstance();
		School s2 = School.getInstance();
		System.out.println(s1 == s2);	//참조 변수에서 == 은 값이 같은지 비교 하는 것 이다.
		
//		School.singleton = null;	//정적 필드가 private 이므로 적용 할수 없다.
		School s3 = School.getInstance();
		

	}

}
