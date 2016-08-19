package ch05.exam01;

public class ValueReferenceCompare {

	public static void main(String[] args) {
		//08.19 값 비교
		int v1 = 100;
		int v2 = 200;
		System.out.println(v1 == v2); // 저장된 값이 다르므로 false
		System.out.println(v1 != v2); // 저장된 값이 다르므로 true
		System.out.println("-----------------------------------------------------");
		
		//참조 비교 (=객체 비교)
		String r1 = new String("자바");	// 새로운 자바 객체 주소 참조 
		String r2 = new String("자바");	// 새로운 자바 객체 주소 참조 (둘은 다른 객체)
		System.out.println( r1 == r2 );	// r1이 참조하는 객체와 r2가 참조하는 객체가 같은지 비교
		System.out.println( r1 != r2 );	// r1이 참조하는 객체와 r2가 참조하는 객체가 다른지 비교
		System.out.println("-----------------------------------------------------");
		
		String r3 = r1;					// r1에서 참조하는 객체 번지를 r3에 대입
		System.out.println(r3 == r1);
		System.out.println(r3 != r1);
		System.out.println("-----------------------------------------------------");
		
		String r4 = "자바";				// 객체 번지수 참조
		String r5 = "자바";				// 객체 번지수 참조 (둘이 같은 번지를 참조)
		System.out.println(r4 == r5);
		System.out.println(r4 != r5);
		System.out.println("-----------------------------------------------------");

	}

}
