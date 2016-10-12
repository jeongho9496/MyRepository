package ch05.exam03;

import java.util.Scanner;	//Scanner 클래스가 있는 패키지 경로-> 표준 api

public class ScannerExample {

	public static void main(String[] args) throws Exception {
		//0822
		Scanner scanner = new Scanner(System.in);	// 참조 타입 -> 객체를 만들어야 함 system.in -> 키보드 입력 값
		
		System.out.print("학생 수: ");
		String strNum = scanner.nextLine();
		int num = Integer.parseInt(strNum);
		int[] scores = new int[num];
		
		for(int i=0; i<scores.length; i++){
			System.out.print("점수: ");
			String data = scanner.nextLine();	//스캐너 객체에 있는 nextLine()메소드를 호출하여 data에 대입한다.
												//=>스캐너 변수가 참조하는 객체를 접근해서 해당 객체의 메소드를 실행 시킨다.
			int score = Integer.parseInt(data);	//데이터 타입을 숫자로 변환
			scores[i] = score;
			
		}
		
		int sum = 0;
		for (int s : scores) {
			sum += s;
		}
		
		System.out.println("총합: " + sum);
		System.out.println("평균: " + (double)sum/scores.length);

	}

}
