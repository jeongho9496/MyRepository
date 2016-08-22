package ch05.exam02;

public class ArrayInArray {

	public static void main(String[] args) {
		// 0822
		int[][] scores = new int[2][3]; // 다차원 배열 //앞쪽 배열을 지정한루 각 배열에 있는 인덱스에 다음
										// 배열이 붙는다.

		System.out.println("배열의 길이");

		System.out.println(scores.length); // 베열수2
		System.out.println(scores[0].length); // 배열수3
		System.out.println(scores[1].length); // 베열수3

		System.out.println("항목값 접근");

		System.out.println(scores[0][0]);
		System.out.println(scores[0][1]);
		System.out.println(scores[0][2]);

		System.out.println(scores[1][0]);
		System.out.println(scores[1][1]);
		System.out.println(scores[1][2]);

		System.out.println("for문 이용");

		for (int i1 = 0; i1 < scores.length; i1++) {
			for (int i2 = 0; i2 < scores[i1].length; i2++) { // 두번째 배열 -> 항목의 값이
																// 저장되는곳
				System.out.println(scores[i1][i2]);
			}
		}

		System.out.println("값 변경");
		scores[0][1] = 50;
		System.out.println(scores[0][1]);

	}

}
