package ch05.exam02;

public class ArrayCreateByValueList2 {

	public static void main(String[] args) {
		//08.19
		int[] scores1 = { 83, 90, 87 }; // 한가지 타입으로만 값에 들어갈수 있다
		
		System.out.println(scores1[0]);	// scores1이 참조하는 배열로 가서 0번째 인덱스 값을 참조 하시오
		System.out.println(scores1[1]);
		System.out.println(scores1[2]);
//		System.out.println(scores1[3]); //ArrayIndexOutOfBoundsException : 배열의 인덱스를 초과 할 경우 나오는 예외
		
		int arrayLength = scores1.length;	//scores1이 참조하는 객체에 접근하여 length라는 필드의 값을 읽고 대입 하는 것
		System.out.println("배열의 길이는? => "+arrayLength); //length -> 배열의 길이 확인
		
		for (int i = 0; i < scores1.length; i++) {
			System.out.println(scores1[i]);
		}
		
		int sum = 0;
		for (int i = 0; i < scores1.length; i++) {
			sum += scores1[i];
		}
		System.out.println("전체 합은 => "+sum);
		
		double avg = 1.0 * sum / scores1.length;	//정수를 실수로 바꿀때 casting 하면된다.
		//double avg = (double)sum / scores1.length;//위와 같은 값이 나온다.
		
		System.out.println("평균 값은 => " + avg);
		
	}

}
