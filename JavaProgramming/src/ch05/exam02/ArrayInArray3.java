package ch05.exam02;

public class ArrayInArray3 {

	public static void main(String[] args) {	
		//0822
		int[][] scores = {{2,3,4},{5,6,7,8}};
		
		System.out.println(scores.length);	//바깥배열의 항목수
		System.out.println(scores[0].length);	//첫번째 배열의 항목수
		System.out.println(scores[1].length);	//두번째 배열의 항목수
		
		for (int i1 = 0; i1 < scores.length; i1++) {
			for (int i2 = 0; i2 < scores[i1].length; i2++) { // 두번째 배열 -> 항목의 값이
																// 저장되는곳
				System.out.print(scores[i1][i2]+",");
			}
		}
		
	}

}
