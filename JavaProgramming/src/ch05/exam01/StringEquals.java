package ch05.exam01;

public class StringEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//0819
		String name1 = "자바";
		String name2 = "자바";
		String name3 = new String("자바");
		
		System.out.println(name1 == name2);				//같은 객체 주소 참조
		System.out.println("------------------------");
		System.out.println(name1 == name3);				//다른 객체 주소 참조
		System.out.println("------------------------");
		System.out.println(name1.equals(name3));		//객체가 아닌 문자열만 비교

	}

}
