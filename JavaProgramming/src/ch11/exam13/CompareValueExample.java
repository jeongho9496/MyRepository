package ch11.exam13;

public class CompareValueExample {

	public static void main(String[] args) {
		//0906
		Integer obj1 = 500;
		Integer obj2 = 500;
		
		System.out.println(obj1 == obj2);
		System.out.println(obj1.intValue() == obj2.intValue());// 값만 비교
		System.out.println(obj1.equals(obj2));//Integer에서 equals() 재정의 값만 비교
		
		Integer obj3 = 100;
		Integer obj4 = 100;
		System.out.println(obj3 == obj4);
		System.out.println(obj3.intValue() == obj4.intValue());
		System.out.println(obj1.equals(obj2));

	}

}
