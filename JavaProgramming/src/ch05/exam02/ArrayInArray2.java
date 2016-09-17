package ch05.exam02;

public class ArrayInArray2 {

	public static void main(String[] args) {	
		//0822
				int[][] scores = new int[2][]; // 첫번째 배열 길이 설정 
				
				scores[0] = new int[2];	//scores[] 첫번째 [] 에 int[2] 다중 배열 추가 
				scores[1] = new int[3]; //scores[] 첫번째 [] 에 int[3] 다중 배열 추가
				
				System.out.println(scores.length);
				System.out.println(scores[0].length);
				System.out.println(scores[1].length);
				
				for (int i1 = 0; i1 < scores.length; i1++) {
					for (int i2 = 0; i2 < scores[i1].length; i2++) { // 두번째 배열 -> 항목의 값이
																		// 저장되는곳
						System.out.print(scores[i1][i2]);
					}
				}
		
	}

}
