package ch05.exam03;

import java.util.Scanner; //import : Scanner 클래스가 있는 패키지 경로 설정 ctrl + shift + o -> 표준 api

public class ScoreManagement {

	public static void main(String[] args) throws Exception {
		// 0822
		Scanner scanner = new Scanner(System.in);
		String[][] students = null; // 전체에 쓰이기위에 main에서 초기화 배열길이는 결정 안함.

		while (true) {	//무한 루프

			System.out.println("-------------------------------------------------------------------------");
			if (students == null) {	//student 배열에 데이터가 없다면
				
				System.out.println("| 1.총학생수 | 7.종료 |");

			} else {
				
				System.out.println("| 1.총학생수 | 2.목록 | 3.입력 | 4.삭제 | 5.최고 점수 | 6.평균 | 7.종료 |");
			
			}
			
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("선택 : ");
			String choice = scanner.nextLine();	//키보드로 선택한 숫자를 읽어온다.

			if (choice.equals("1")) {
				
				System.out.print("총학생수 : ");
				int totalNum = Integer.parseInt(scanner.nextLine()); // 학생수 입력 받기
				students = new String[totalNum][]; // new String{{학생수}{이름,성적}}

			} else if (choice.equals("2")) {
				
				System.out.println("******************************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("******************************************************");
				
				for (String[] student : students) { // for-each문
					// for(int i = 0; students.length; i++){ for문 방식
					// String[] student = students[i];
					// }
					if (student != null) { // null도 비교 가능 -> student에 배열이 있어야 실행 가능
						System.out.println(student[0] + "\t\t" + student[1] +"\t\t" + student[2]);
					}
				}
				

			} else if (choice.equals("3")) {
				
				System.out.print("이름 : ");
				String name = scanner.nextLine();
				System.out.print("점수 : ");
				String score = scanner.nextLine();
				
				for (int i = 0; i < students.length; i++) {
				
					if (students[i] == null) {
						String[] student = {String.valueOf(i+1),name,score};
						//String.valueOf(i) => 매개변수 안에 있는 숫자를 문자열로 바꿔준다.
						//(<=> Integer.parseInt() => 매개변수 안에 있는 문자열이 숫자형식이면 숫자로 바꾼다.)
						students[i] = student;
						break;
					}
				}

			} else if (choice.equals("4")) {
				
				System.out.print("삭제할 학번 : ");
				int sno = Integer.parseInt(scanner.nextLine());
				students[sno-1] = null;

			} else if (choice.equals("5")) {

				System.out.println("******************************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("******************************************************");

				int max = 0;
				for (String[] student : students) {
					if (student != null) {						
						int score = Integer.parseInt(student[2]);//학생들의 점수를 int 에 담아 max 값과 비교한다.
						if (max < score) {
							max = score;
						}	
					}
				}
				
				for (String[] student : students) {	//최고 점수가 여러명 있을수 있기 때문에 필요

					if (student != null) {	
						int score = Integer.parseInt(student[2]);
						if (max == score) {
							System.out.println(student[0] + "\t\t" + student[1] +"\t\t" + student[2]);
						}
					}
				}
				
			} else if (choice.equals("6")) {
				int count = 0;
				int sum = 0;
				for (String[] student : students) {
					if (student != null) {
						count ++ ;	//student 객체가 null 이 있을수 있기 때문에 현재 있는 객체만 계산한다.
						sum += Integer.parseInt(student[2]);
					}
				}
				System.out.println("평균 : " + (double)sum/count);
				
			} else if (choice.equals("7")) {
				break;
			}

		}

	}

}
