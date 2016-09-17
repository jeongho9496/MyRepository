package ch05.exam02;

public class ArrayCreateByValueList1 {

	public static void main(String[] args) {
		// how1
		int[] scores1 = { 83, 90, 87 }; // 한가지 타입으로만 값에 들어갈수 있다

		// how2
		int[] scores2;
		// scores2={83, 90, 87} //배열 변수 선언후 다음에 목록을 배열변수에 담으면 안된다. 새로운 객체 생성후 설정한다.
		scores2 = new int[] { 83, 90, 87 };

		sum(new int[]{83, 90, 87});//메소드 호출. 배열 변수 선언후 나중에 배열 값을 바로 넣을수 없다. new int[]{...} 식으로 사용
	}

	public static void sum(int[] arr) {	//매개변수가 int[](배열 변수)인 메소드 생성
			
	}

}
