package ch05.exam02;

public class ArrayReferenceCompare {

	public static void main(String[] args) {
		// 0822
		String[] names = new String[3];
		names[0] = "홍길동";
		names[1] = "홍길동";
		names[2] = new String ("홍길동");	//새로운 객체 생성
		
		System.out.println(names[0] == names[1]);	//같은 객체 참조하므로 true
		System.out.println(names[0] == names[2]);	//다른 객체 참조하므로 false
		//문자열을 비교 하고 싶다면 equals 사용
		System.out.println(names[0].equals(names[2]) );	//문자열이 같으므로 true
		
		
	}

}
