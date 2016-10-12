package ch06.exam13;

public class SchoolExample2 {
	//0829

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		School s1 = new School();
//		School s2 = new School();
		
		School2 s1 = School2.getInstance();
		School2 s2 = School2.getInstance();
		System.out.println(s1 == s2);	
		

		

	}

}
