package ch06.exam04;

public class PersonExample {

	public static void main(String[] args) {
		Person p1 = new Person("홍길동","남",20,180.0); //=> 참조 변수 선언을 안하면 객체가 저장된 번지수를 못 찾기 때문에 반드시 변수 선언을 해주어야 한다.
		
		//기본타입 : 0 or 0.0 참조타입 기본값 : null //기본적인 데이터
		System.out.println(p1.name);
		System.out.println(p1.gender);
		System.out.println(p1.age);
		System.out.println(p1.height);
		System.out.println(p1.married);
		
		//데이터 수정
		p1.age = 27;
	}

}
